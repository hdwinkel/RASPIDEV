#!/usr/bin/env python2.7
# 
import RPi.GPIO as GPIO
import json
import requests
import pprint

# set post-event variables
url = 'http://localhost:8880/PostEvent'
data = {"name":"button01","count":1,"type":"button"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}


GPIO.setmode(GPIO.BCM)

# GPIO 18 set up as input. It is pulled up to stop false signals
GPIO.setup(18, GPIO.IN, pull_up_down=GPIO.PUD_UP)

print "Make sure you have a button connected so that when pressed"
print "it will connect GPIO port 18 (pin 12) to GND (pin 6)\n"
raw_input("Press Enter when ready\n>")

print "Waiting for falling edge on port 18"
# now the program will do nothing until the signal on port 23 
# starts to fall towards zero. This is why we used the pullup
# to keep the signal high and prevent a false interrupt

print "During this waiting time, your computer is not" 
print "wasting resources by polling for a button press.\n"
print "Press your button when ready to initiate a falling edge interrupt."
print("button status0: " + str(GPIO.input(18)))
try:
    while 1:
	print("button status1: " + str(GPIO.input(18)))
	GPIO.wait_for_edge(18, GPIO.FALLING)
	print("button status2: " + str(GPIO.input(18)))
	print "\nFalling edge detected. Now your program can continue with"
	print "whatever was waiting for a button press."
	response = requests.post(url, data=data_json, headers=headers)
        #print(response.json())
        print(data_json)
        print(response.url)

except KeyboardInterrupt:
    GPIO.cleanup()       # clean up GPIO on CTRL+C exit
GPIO.cleanup()           # clean up GPIO on normal exit
