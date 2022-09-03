import urllib.request, urllib.parse, urllib.error
import json

url = "http://py4e-data.dr-chuck.net/comments_1588114.json"
info = json.loads(urllib.request.urlopen(url).read())

comm=info['comments']
counts_list = [int(items['count']) for items in comm]
print(sum(counts_list))
