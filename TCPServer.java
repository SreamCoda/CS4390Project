import java.io.*; 
import java.net.*; 

class TCPServer { 
	
	  public static void main(String argv[]) throws Exception 
	    { 
	      String clientSentence; 
	      String capitalizedSentence; 

	      //create socket at this port
	      ServerSocket welcomeSocket = new ServerSocket(6789); 
	  
	      while(true) { 
	  
	        
	    	 //create a socket
	    	  Socket connectionSocket = welcomeSocket.accept(); 

	    	  //input stream attached to socket
	           BufferedReader inFromClient = 
	              new BufferedReader(new
	              InputStreamReader(connectionSocket.getInputStream())); 

	           //output stream attached to socket
	           DataOutputStream  outToClient = 
	             new DataOutputStream(connectionSocket.getOutputStream()); 

	           //read in line from socket
	           clientSentence = inFromClient.readLine(); 

	           
	           capitalizedSentence = clientSentence.toUpperCase() + '\n'; 

	           //write out line to socket
	           outToClient.writeBytes(capitalizedSentence); 
	        } 
	    } 
	} 
	 
