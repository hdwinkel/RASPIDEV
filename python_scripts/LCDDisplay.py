#!/usr/bin/env python
import LCD1602
import time

import requests
import json
import pprint


def setup():
	LCD1602.init(0x27, 1)	# init(slave address, background light)

def loop():
	url = 'http://192.168.10.142:8880/GetDisplay'
#	url = 'http://localhost:8880/GetDisplay'
	headers = {'Content-type': 'application/json'}
	response = requests.get(url, headers=headers)
	data = response.json()
	print(data)
	print(response.url)
#	LCD1602.init(0x27, 1)	# init(slave address, background light)
#	line1 = 'Please keep calm'
#	line2 = 'Help is coming )'
	line1=data['display1']
	line2=data['display2']
	LCD1602.clear()
	LCD1602.write(0, 0, line1)
	LCD1602.write(0, 1, line2)
	time.sleep(3.0)

def destroy():
	pass	

if __name__ == "__main__":
	try:
		setup()
		while True:
			loop()
			pass
	except KeyboardInterrupt:
		destroy()
