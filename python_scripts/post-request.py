import json
import requests
import pprint
url = 'http://localhost:8880/PostEvent'
data = {"id":"id01","number":1,"type":"button"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.post(url, data=data_json, headers=headers)
#pprint.pprint(response.json())
#pprint.pprint(response.json()['json'])

#url = 'http://localhost:8880/PostRegistration'
#data = {"regid":"regid01"}
#data_json = json.dumps(data)
#headers = {'Content-type': 'application/json'}
#response = requests.post(url, data=data_json, headers=headers)
#pprint.pprint(response.json())
#pprint.pprint(response.json()['json'])
##


