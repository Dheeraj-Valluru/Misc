#import
from urllib import request
import xml.etree.ElementTree as ET


url = 'http://py4e-data.dr-chuck.net/comments_1588113.xml'
print ("Retrieving", url)
html = request.urlopen(url)
data = html.read()
print("Retrieved",len(data),"characters")

tree = ET.fromstring(data)
results = tree.findall('comments/comment')
count=len(results)
sum=0

for result in results:
    sum += float(result.find('count').text)
print(count)
print(sum)
