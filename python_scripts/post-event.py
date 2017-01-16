import json
import requests
import pprint
url = 'http://localhost:8880/PostEvent'
data = {"name":"button01","count":1,"type":"button"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.post(url, data=data_json, headers=headers)
#print(response.json())
print(data_json)
print(response.url)



