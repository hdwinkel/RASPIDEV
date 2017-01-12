import json
import requests
import pprint
url = 'http://localhost:8880/PostRegistration'
data = {"deviceid":"deviceid01","name":"Detlef Winkelvoss","email":"winkel@egladil.de"}
data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.post(url, data=data_json, headers=headers)
#pprint.pprint(response.json())
#pprint.pprint(response.json()['json'])



