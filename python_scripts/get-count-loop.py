import requests
import json
import time
import pprint

url = 'http://localhost:8880/GetCount/~'
#url = 'http://localhost:8880/GetCount/deviceid01'
#data = {"deviceid":"device03"}
#data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}

while True:

	response = requests.get(url, headers=headers)
	print(response.json())
	print(response.url)
	time.sleep(3.0)

