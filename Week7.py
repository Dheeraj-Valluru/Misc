#simple while loop
# n=5
# while n>0:
#     print(n)
#     n-=1
# print("Blastoff")
# print(n)
#
# #infinite loop with a break statement
# while True:
#     line = input("> ")
#     if line == "done":
#         break
#     print(line) #if the user input isn't done show what they typed
# print("Done!")
#
# #loop but with continue
# #continue will skip to the next iteration of the loop
# while True:
#     line = input("> ")
#     if line[0] == "#":
#         continue
#     if line == "done":
#         break
#     print(line)
# print("Done!")
#
# #for loops
# for i in [5,4,3,2,1]:
#     print(i)
# print("Blastoff")
#
# friends = ["tommy", "joeseph", "charles"]
# for friend in friends:
#     print("Good morning" , friend)
# print("Done!")
#
# #smart loops
# print("Before")
# for thing in [9,41,12,374,15]:
#     print(thing)
# print("After")

#finding the largest number
set = [9,41,12,3,74,15]
soFar = None
for num in set:
    if soFar is None:
        soFar = num
    if num > soFar:
        soFar = num
print("The largest number in the set is: " + str(soFar))

#counting in a loop
count = 0
for num in set:
    count+=1
print(count)

#sum of toal in a loop
sum = 0
for num in set:
    sum+=num
print(sum)

#finding the average in a loop
cnt = 0
sm = 0
for num in set:
    cnt+=1
    sm+=num
print(sm/cnt)

#search with a loop
bool = False
for num in set:
    if num == 3:
        bool = True
if bool:
    print("Number was found in set.")
else:
    print("Number was not found in set.")

#finding the smallest value in a set
small=None
for num in set:
    if small is None:
        small = num
    if num < small:
        small = num
print("The smallest number in the set is", small)
