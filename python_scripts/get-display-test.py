import requests
import json
import pprint
url = 'http://192.168.10.142:8880/GetDisplay'
#url = 'http://localhost:8880/GetDisplay'
#data = {"deviceid":"device03"}
#data_json = json.dumps(data)
headers = {'Content-type': 'application/json'}
response = requests.get(url, headers=headers)
data = response.json()
print(data)
print(response.url)

text1=data['display1']
text2=data['display2']

print(text1 + "/" + text2)





