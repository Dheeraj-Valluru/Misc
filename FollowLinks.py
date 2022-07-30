import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup

#url = 'http://py4e-data.dr-chuck.net/known_by_Fikret.html'
url = input('URL- ')
count = int(input('Count- '))
pos = int(input('Position- ')) - 1

for i in range(count):
    html = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(html, features='html.parser')
    tags = soup('a')
    url = tags[pos].get('href', None)
    print(tags[pos].contents[0])
