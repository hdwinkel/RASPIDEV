import json
import requests
import pprint
#url = 'http://localhost:8880/PostRegistration'
url = 'http://192.168.10.142:8880/PostRegistration'
data = {"deviceid":"deviceid02","name":"Det Winkelvoss","email":"winkel@egladil.de"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.post(url, data=data_json, headers=headers)
#print(response.json())
print(data_json)
print(response.url)



