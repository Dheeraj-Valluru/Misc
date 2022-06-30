#add
x = 2
x += 2
print(x)

#multiply
y = 440 * 12
print(y)

#divide
z = y / 1000
print(z)

#remainder (modulo)
j = 23
k = j % 5
print(k)

#exponent (power)
print(4**3)

#type conversions
print(float(99) + 100)

i = 42
type(i)

f = float(i)
print(f)
type(f)

#integer division produces a floating point result
print(10/2)
print(9/2)
print(int(9/2)) # gets the floor value
print(99/100)
print(10.0/2.0)
print(99.0/100.0)

#casting to int from string
sval = '123'
ival = int(sval)
ival +=1
print(ival)

#taking input from user
name = input("Who are you? ")
if name == "Dheeraj Valluru" or name == "Dheeraj":
    print("Welcome, " + name + "!")
else:
    print("Access Denied.")
print("program finished")

#European elevator converter
inp = input("Euorpean floor: ")
americanFloor = int(inp) + 1
print("The American floor is: " + str(americanFloor))
