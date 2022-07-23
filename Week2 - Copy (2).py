#using re.search() like find()
hand = open('mbox-short.txt')
for line in hand:
    line = line.rstrip()
    if line.find('From:') > = 0:
        print(line)

import re
#uses hand from before
for line in hand:
    line = line.rstrip()
    if re.search('From:', line):
        print(line)

#using re.search() like startswith()
for line in hand:
    line = line.rstrip()
    if line.startswith('From:'):
        print(line)


for line in hand:
    line = line.rstrip()
    if re.search('^From:', line):
        print(line)

#extracting out data
#import re
x = 'My favorite 3 numbers are 2, 11, and 939'
y = re.findall('[0-9]+',x)
print(y)

import re
#greedy matching means that the function will try to get everything within a set
#in order to make something not greedy use the ? character
x = 'From: Using the : character'
y1 = re.findall('^F.+?:',x)
print(y1)

#parentheses tell the reg exp when to start extracting and when to stop
sent = 'From stephen.marquard@uct.ac.za Sat Jan 5 09:14:16 2008'
y2 = re.findall("^From (\S+@\S+)", sent)
print(y2)
