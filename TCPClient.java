import java.io.*; 
import java.net.*;

class TCPClient {
	 
	
	    public static void main(String argv[]) throws Exception 
	    { 
	        String sentence; 
	        String modifiedSentence; 

	        //create input stream
	        BufferedReader inFromUser = 
	          new BufferedReader(new InputStreamReader(System.in)); 

	        //create socket object to connect to server
	        Socket clientSocket = new Socket("127.0.0.1", 6789); 

	        //output stream attached to socket
	        DataOutputStream outToServer = 
	          new DataOutputStream(clientSocket.getOutputStream()); 
	        
	        //input stream attached to socket
	        BufferedReader inFromServer = 
	                new BufferedReader(new
	                InputStreamReader(clientSocket.getInputStream())); 

	              sentence = inFromUser.readLine(); 

	              //send line to server
	              outToServer.writeBytes(sentence + '\n'); 

	              //read line from server
	              modifiedSentence = inFromServer.readLine(); 

	              System.out.println("FROM SERVER: " + modifiedSentence); 

	              //close socket
	              clientSocket.close(); 
	                         
	          } 
	      } 
