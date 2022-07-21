 #sockets in python

#this is built in support for sockets
#this is not sending data more like dialing the phone
import socket
mysock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#    host we want to connect to, port we want to connect to
mysock.connect(('data.pr4e.org', 80))
# now the connection is made
# so we now want to send data back and forth

#now we want to send the command
cmd = 'GET http://data.pr4e.org/romeo.txt HTTP/1.0\n\n'.encode()
mysock.send(cmd)

while(True):
    data = mysock.recv(512) #receive up to 512 characters
    if (len(data) < 1):
        break
    print(data.decode())
mysock.close()
