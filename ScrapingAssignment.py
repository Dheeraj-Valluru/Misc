#this program retreieves anchor tags
import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup

from urllib import request
from bs4 import BeautifulSoup
html=request.urlopen('http://py4e-data.dr-chuck.net/comments_1588111.html').read()
soup = BeautifulSoup(html, features="html.parser")
tags=soup('span')
sum=0
for tag in tags:
    sum=sum+int(tag.contents[0])
print(sum)
