#!/usr/bin/python
# Verwenden von GPIO
import RPi.GPIO as GPIO
import json
import requests
import pprint
import time

ledpin=31
buttonpin=29

url = 'http://localhost:8880/PostManned'

# Warnungen ausschalten
#GPIO.setwarnings(False)
# Pin Nummern verwenden
GPIO.setmode(GPIO.BOARD)
# Pin 11 als Input
GPIO.setup(buttonpin, GPIO.IN)
# Pin 12 als Output
GPIO.setup(ledpin, GPIO.OUT)

# Endlosschleife
while True:
  # Solange Button nicht gedrueckt wird (False)
  if not GPIO.input(buttonpin):
    GPIO.output(ledpin, False)
    data = {"deviceid":"coworker-button", "ismanned":0}
    data_json = json.dumps(data)
    headers = {'Content-type': 'application/json'}
    response = requests.post(url, data=data_json, headers=headers)
    print(data_json)
    print(response.url)
    time.sleep(3.0)
    
  # Wenn der Button gedrueckt wird
  else:
    GPIO.output(ledpin, True)
    data = {"deviceid":"coworker-button", "ismanned":1}
    data_json = json.dumps(data)
    headers = {'Content-type': 'application/json'}
    response = requests.post(url, data=data_json, headers=headers)
    print(data_json)
    print(response.url)
    time.sleep(3.0)

GPIO.cleanup() 





