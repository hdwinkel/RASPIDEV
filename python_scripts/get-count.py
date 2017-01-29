import requests
import json
import pprint
#url = 'http://localhost:8880/GetCount/~'
#url = 'http://localhost:8880/GetCount/deviceid01'
url = 'http://217.212.91.29:8880/GetCount/deviceid01'
#data = {"deviceid":"device03"}
#data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.get(url, headers=headers)
print(response.json())
print(response.url)




