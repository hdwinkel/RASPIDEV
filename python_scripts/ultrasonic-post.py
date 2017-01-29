#!/usr/bin/env python

import RPi.GPIO as GPIO
import time
import json
import requests

# PINS (pin numbers; BCM =24; 23)
TRIG = 18
ECHO = 16

# set post-event variables
url = 'http://localhost:8880/PostEvent'
data = {"name":"distsensor01","count":1,"type":"sensor"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}

#Parameters:
# clock measure in sec
clockM=0.3
# sensor distance - lower threshold in cm
lowerTh=10
# sensor distance - upper threshold in cm
upperTh=100
# countdown (how much connected events a person is recognized)
countdown=20

# queue list to collect events to be smoothed as rolling input (7 events)
eventQueue=[upperTh+1]*7

def setup():
	GPIO.setmode(GPIO.BOARD)
	GPIO.setup(TRIG, GPIO.OUT)
	GPIO.setup(ECHO, GPIO.IN)

def smoothing(eq):
	seq=list(eq)
	seq.sort()
	seq[2:5]
	av=(seq[0]+seq[1]+seq[2])/3
	return round(av)


def distance():
	GPIO.output(TRIG, 0)
	time.sleep(0.000002)

	GPIO.output(TRIG, 1)
	time.sleep(0.00001)
	GPIO.output(TRIG, 0)

	
	while GPIO.input(ECHO) == 0:
		a = 0
	time1 = time.time()
	while GPIO.input(ECHO) == 1:
		a = 1
	time2 = time.time()

	during = time2 - time1
	return during * 340 / 2 * 100

def loop():
# count the events until countdown; start at 0 if person is outside
	cd=0
	while True:
		dis = distance()
		print dis, 'cm'
#building a ring buffer
		eventQueue[6]=eventQueue[5]
		eventQueue[5]=eventQueue[4]
		eventQueue[4]=eventQueue[3]
		eventQueue[3]=eventQueue[2]
		eventQueue[2]=eventQueue[1]
		eventQueue[1]=eventQueue[0]
		eventQueue[0]=dis
		smoothedDis=smoothing(eventQueue)
		print smoothedDis, 'cm smoothed'
		print ''
		
		if smoothedDis>lowerTh and smoothedDis<upperTh:
# event shall be counted			
			cd=cd+1	
		else:
			cd=0
			
		if cd>=countdown:
			print 'countdown reached!!!'
			print ''
			cd=0
			
			response = requests.post(url, data=data_json, headers=headers)
#print(response.json())
			print(data_json)
			print(response.url)
		
		time.sleep(clockM)

def destroy():
	GPIO.cleanup()

if __name__ == "__main__":
	setup()
	try:
		loop()
	except KeyboardInterrupt:
		destroy()
