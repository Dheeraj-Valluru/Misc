#how to open a file in python
fileHandle = open("Stuff.txt")

#actually prints the lines in the file
for line in fileHandle:
  print(line)

#counting lines in a file
count = 0
for line in fileHandle:
    count +=1
print("Line count:", count)

#reading the entire file including newlines
fileRead = fileHandle.read()

#Searching through a file
for line in fileHandle:
    #line below removes the newline at the end of a line in a file
    line = line.rStrip()
    if line.startswith("From: "):
        print(line)

for line in fileHandle:
    line = line.rStrip()
    if 'hi' in line:
        print(line)

fileName = input("Enter file name: ")
try:
    fHand = open(fileName)
except:
    print("file could not be opened.")
    quit()
count = 0
for line in fHand:
    if line.startswith("hi"):
        count+=1
print("The count is", count)
