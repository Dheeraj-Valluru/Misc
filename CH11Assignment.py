import re

#opens file
hand = open('regex-sum-real.txt')
#create list to append numbers to
lst = list()
#for each line in the file
for line in hand:
    #remove the newline at the end of the line
    line = line.rstrip()
    #find all numbers in a line, store in variable y
    y = re.findall('[0-9]+', line)
    # take these numbers and append them to the list
    lst = lst+y

#sum variable meant to store the sum of all numbers in the list
sum = 0
#for each num in the list
for num in lst:
    #add the parsed integer value to the sum
    sum+= int(num) #need to parse
#print the sum
print(sum)
