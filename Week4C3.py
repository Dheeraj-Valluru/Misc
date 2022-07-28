print(ord('H'))
print(ord('e'))
print(ord('r'))

#using urlib
#this will do all socket work and make web pages look like a file
#Basically building a web browser

import urllib.request, urllib.parse, urllib.error

fhand = urllib.request.urlopen('http://data.pr4e.org/intro-short.txt')
#line is a byte so we must decode into UNICode
for line in fhand:
    print(line.decode().strip())

counts = dict()
for line in fhand:
    #have to decode because it comes from utf-8 (byte-string)
    words = line.decode().split()
    for word in words:
        #for each word in each line will tell you how many times the word
        #appeared
        counts[word] = counts.get(word, 0) + 1
print(counts)
