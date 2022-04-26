# CS4390Project

In this project, we implemented a network application using JAVA. It uses
key concepts of intercommunication between programs running on different computers in the 
network by using Java Sockets. The application consists of a centralized Math server and two 
or more clients. The server will provide basic math calculation services to the client(s). 

This application contains a TCPServer.java file:
1. The server will keeps track of all users – who, when and how long the user attached to the server.
2. The server wil wait for the client’s request. Upon attachment, the server will log the details about the client. 
3. The server can have connections simultaneously with multiple clients. 
4. The server will be able to accept the string request for basic math calculations and show who has sent what request. (ex. 5 + 6, 8 / 2)
5. The server will respond to clients in order of requests it gets from different clients. 
6. The server will close connection with client upon request from the client and log it.

This application contains a TCPClient.java file:
1. The client gives name during initial attachment to the server and waits till it gets acknowledgement from the server for a successful connection. 
2. After a successful connection, the client can send basic math calculation requests (at least 3) to the server at random times. 
3. Another client can join during this time and start sending its requests.
4. The client should send a close connection request to the server and the application terminates. 


The way we have been compiling the project is by running it on the powershell in Visual Studio Code but you can run it through the command prompt as well.
1. If you use command prompt, use ‘cd’ to go to the folder that contains the java files.
2. You’d first type ‘javac TCPServer.java’ and press enter. 
3. Then type ‘java TCPServer.java’ and press enter to run the file. 
4. Next, in a new command prompt or powershell, you’ll do the same for the client. i.e ‘javac TCPClient.java’ and then enter, followed by ‘java TCPClient.java’ and then enter, to run the client application. 
5. You then type your equation on the client side and you’ll receive your answer.
6. To send a close connection requests, simply type “stop” or “Stop” into the client application and it will close the connection between the client and the server. 
