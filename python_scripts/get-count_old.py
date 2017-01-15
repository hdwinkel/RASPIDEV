import requests
import json
import pprint
url = 'http://localhost:8880/GetCount'
#data = {"deviceid":"device03"}
#data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
myparams={'deviceid':'dev01'}
response = requests.get(url, params=myparams, headers=headers)
print(response.json())
print(response.url)
#pprint.pprint(response.json()['json'])



