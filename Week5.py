#conditional execution
x = 5
if x == 5:
  print("x is 5")
if x <= 5:
  print("x is less than or equal to 5")
if x >=5: print("x is greater than or equal to 5")
print("indentation matters")

if(x != 10):
  print("x")
  print("is")
  print("not equal to 10.")

#nested decisions
y=42
if y > 20:
    print("y is greater than 20")
    if y > 100:
        print("y is greater than 100")
print("end of nested clause")

z = 20
if x>20:
    print("x is greater than 20")
else:
    print("x is not greater than 20")
print("All Done")

#try except clauses
astr = "Hello Bob"
try:
    istr = int(astr)
except:
    istr = -1
print("First " + str(istr))

astr = "123"
try:
    istr = int(astr)
except:
    istr = -1
print("Second " + str(istr))


userInput = input("Enter a number: ")
try:
    num = int(userInput)
except:
    num = -1

if num>0:
    print("Good work, you entered: " + str(num))
else:
    print("You did not enter a number.")
