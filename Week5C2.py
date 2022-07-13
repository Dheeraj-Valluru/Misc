#simple dictionary example
dictionary = dict()
#how to add a key-value pair
#key is in brackets and value is what is on the other side of the = sign
dictionary["money"] = 9999999
dictionary["candy"] = 1
dictionary["car"] = 1000
print(dictionary)
print(dictionary["money"])
dictionary["candy"] = 2
print(dictionary)

#count program
counts = dict()
names = ["csev", "cwen", "csev", "zquian", "cwen"]
for name in names:
    if name not in counts:
        counts[name] = 1
    else:
        counts[name] +=1
print(counts)

#same program as above but using the get method
counts2 = dict()
for name in names:
    counts2[name] = counts2.get(name, 0)+1
print(counts2)

#counting words from a line of text
line = input("Enter a line of text: ")
words = line.split()
print("Words:", words)
print("Counting...")

countDict = dict()
for word in words:
    countDict[word] = countDict.get(word, 0)+1
print(countDict )
