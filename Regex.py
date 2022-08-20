#the following two programs act the same way

hand = open('mbox-short.txt')
for line in hand:
    line = line.rstrip()
    if line.find('From:') >=0:
        print(line)
#####################################################
import re

hand = open('mbox-short.txt')
for line in hand:
    line = line.rstrip()
    if re.search('From:', line):
        print(line)
#####################################################
#the following two programs act the same way

hand = open('mbox-short.txt')
for line in hand:
    line = line.rstrip()
    if line.startswith('From:'):
        print(line)
#####################################################
import re

hand = open('mbox-short.txt')
for line in hand:
    line = line.rstrip()
    if re.search('^From:', line):
        print(line)

#####################################################
#Greedy matching
x = "From: Using the : Character"
y = re.findall('^F.+:', x)
print(y)

#Non-greedy matching
x = "From: Using the : Character"
y = re.findall('^F.+?:', x)
print(y)
