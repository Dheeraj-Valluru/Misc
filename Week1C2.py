#Strings
str1 = "Hello "
str2 = "there"
unit = str1 + str2
print(unit)

str3 = '123'
try:
    var = str3 + 1
except:
    print("could not add string to an int")
    print(int(str3) + 1)

#input gives us back a String
age = input("Type your age: ")
print("Your age is: " + age)

try:
    ageNxtYear = age + 1
except:
    print("could not add string to an int")
    ageNxtYear = int(age) + 1
    print("You will be " + str(ageNxtYear) + " years old next year.")

#strings are indexed
fruit = "banana"
#b a n a n a
#0 1 2 3 4 5
print(fruit[0]) #prints b
print(fruit[1]) #prints a
print(fruit[5]) #prints a
x = 3
print(fruit[x-1]) #prints n

#len gives a strings length
print(len(fruit)) #prints 6

#loop using len function
index = 0
while index < len(fruit):
    print(str(index) + fruit[0])
    index+=1

#prints each letter in banana
for letter in fruit:
    print(letter)

#counts how many times the a character appears in the word banana
countA = 0
index = 0
while index < len(fruit):
    if fruit[index] == "a":
        countA +=1
    index +=1
print("The letter A appears " + str(countA) + " times.")

#slicing Strings
#the line below gives the letter with indices from 0 to 3 inclusive
#includes the first number excludes the second
#"up to but not including"
print(fruit[0:4])
#line below does the same as the line above
print(fruit[:4])
#line below prints all of the strings
print(fruit[:])

#in can be used as a logical operator
if "b" in fruit:
    print("true")
else:
    print("false")

#example of a string function
greet = "Hi There"
zap = greet.lower()
print(zap)
print(greet)
print("Hi There".lower())
