#Tuples are like lists
x = ("Glenn", "Sally", "Joeseph")
print(x[2])

y = (1,9,2)
print(y)
print(max(y))

count = 0
for num in y:
    count+=1
print(count)

#lists are mutable
#tuples are not mutable
#this allows for tuples to be more efficient in terms of memory use

#assignment with Tuples
(x,y) = (99,100)
print(x)
print(y)
(a,b) = ("Red", "Blue")
print(a)

#Tuples are comparable
(0,1,2) > (5,1,2) #returns false
(0,2,3) > (0,1,229292929) #returns true

#sorting through a dictionary in key order
d = {'a':10,'c':29,'b':2}
t = sorted(d.items())
for k,v in t:
    print(k, v)

#sorting through a dictionary in value order
tmp = list()
for k,v in d.items():
    tmp.append( (v,k) )
print(tmp)
sortedDictValue = sorted(tmp, reverse=True)
print(tmp)

#getting the top 10 most common Words
fhand=open("romeo.txt")
counts = dict()
for line in fhand:
    words = line.split() #splitiing each line in the file
    for word in words:
        counts[word] = counts.get(word, 0) + 1 #counts the number of times a word appears

lst = list()
for k,v in counts.items():
    lst.append((v,k))
    lst = sorted(lst, reverse=True) #sorts the list by value

for v,k in lst[:10]: #this gives us the first 10 values indices 0 through 9
    print(k,v)

#code below is read print the sorted version of
# for all create tuples v,k for k,v thats in c.items()
print(sorted([(v,k) for k,v in c.items()]))
