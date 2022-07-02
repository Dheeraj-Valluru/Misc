#Stored steps
def thing():
    print("Hello")
    print("Thing")

thing()
print(" ")
thing()

print(99/100)

def greet(lang):
    if lang == "espanol":
        return "Hola"
    elif lang == "frances":
        return "Bonjour"
    else:
        return "Hello"

print(greet("frances"), "Mark")

def addTwoDigits(a, b):
    return a+b

print(addTwoDigits(1,1))
