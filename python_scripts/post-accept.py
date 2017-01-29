import json
import requests
import pprint
#url = 'http://localhost:8880/PostAccept'
url = 'http://192.168.10.112:8880/PostAccept'
data = {"deviceid":"deviceid01"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.post(url, data=data_json, headers=headers)
print(data_json)
print(response.url)


