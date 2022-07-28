#Web scraping is when a program pretends to be a browser and retreives web pages
#Search engines scrape web pages
#"Spidering the web" - bc its like a spider web working its way from the middle
# to out

#this program retreieves anchor tags
import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup

url = input('Enter - ')
html = urllib.request.urlopen(url)  .read()
soup = BeautifulSoup(html, 'html.parser')

# Retrieve all of the anchor tags
tags = soup('a')
for tag in tags:
    print(tag.get('href', None))
