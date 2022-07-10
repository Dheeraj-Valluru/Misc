# 7.1 Write a program that prompts for a file name, then opens that file
# and reads through the file, and print the contents of the file in upper
# case. Use the file words.txt to produce the output below.


#using words.txt
# Use words.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)

for line in fh:
    line = line.rstrip()
    print(line.upper())

# Write a program that prompts for a file name, then opens that file and
# reads through the file, looking for lines of the form:
# X-DSPAM-Confidence:    0.8475
# Count these lines and extract the floating point values from each of the
# lines and compute the average of those values and produce an output as shown
# below. Do not use the sum() function or a variable named sum in your solution.

# Use the file name mbox-short.txt as the file name
fname = input("Enter file name: ")
fh = open(fname)
count = 0
numerator = 0
num = 0
for line in fh:
    #line = line.rstrip()
    if not line.startswith("X-DSPAM-Confidence:"):
        continue
    count+=1
    num = float(line[20:26])
    numerator += num
    #print(line)
print("Average spam confidence:", (numerator/count))
