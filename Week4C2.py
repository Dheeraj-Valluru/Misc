#lists
friends = ["Joe", "Mike", "Owen"]
print(friends[0]) #prints Joe
print(friends)

listInsideList = [1,2,[1,2]]
print(listInsideList)

emptyList = []
print(emptyList)

for friend in friends:
    print("Happy New Year", friend)
print("Done!")

lotto = [1,42,32,12,39]
print(lotto)
lotto[2] = 0
print(lotto)

#code below replaces all even numbers with -1
count = 0
for num in lotto:
    if num%2 == 0:
        lotto[count] = -1
    count+=1
print(lotto)
print("Done!")

print(len(lotto))

#range returns a list of all inputs up to but not including the specified number
print(range(4))
print(range(len(friends)))

#using the range function
for i in range(len(friends)):
    friend = friends[i]
    print("Happy New Year", friend)
print("Done!")

#concatenating lists
a = [1,2,3]
b = [4,5,6]
c = a+b
print(c)

#slicing lists
t = [9,41,12,3,74,15]
print(t[1:3]) #prints [41,12]

#building a list from scratch
stuff = list() #assigning an empty list to stuff
stuff.append("book")
stuff.append(99)
print(stuff)
stuff.append("cookie")
print(stuff)

#using in to determine whether something is in a list
some = [1,2,3,4,5,99]
if 2 in some:
    print("True")
else:
    print("False")

#it is possible to sort a list as well
friendsV2 = ["Eli", "Aden", "Owen"]
friendsV2.sort()
print(friends) #will sort alphabetically

#calculating the average of numbers inputted to a program
numlist = list()
while True:
    inp = input("Enter a number: ")
    if inp == "done":
        break
    value = float(inp)
    numlist.append(value)
average = sum(numlist)/(len(numlist))
print("Average: ", average)

#lists&strings
justAStr = "Hello there friend"
splitStr = justAStr.split()
print(splitStr)
print(len(splitStr))
print(splitStr[2])

#split has a default delimeter of a space
#one can specify a delimeter
colonWord = "Hello;there;friend"
splitOnColon = colonWord.split(;)
print(splitOnColon)
for w in splitOnColon:
    print(w)
