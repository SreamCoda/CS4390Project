import java.io.*; 
import java.net.*; 

public class ClientHandler implements Runnable {
    private Socket client;
    BufferedReader inFromClient;
    PrintWriter outToClient;

    //Constructor
    public ClientHandler(Socket clientSocket) throws IOException{
        this.client = clientSocket;
        inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outToClient = new PrintWriter(client.getOutputStream(), true);
    }

    //Calculates basic math equations 
    @Override
    public void run() {
        try{
            while(true) { 
                //Reads in equation from client
                String clientEquations = inFromClient.readLine(); 
                String answer = clientEquations;
      
                //this sends back the answer as a string to the client where it'll output it
                outToClient.println(answer.toString()); 
            }
          }
          catch (IOException e){
              System.err.println("IO Exception in ClientHandler");
              System.err.println(e.getStackTrace());
          } finally {
            outToClient.close();

            try { inFromClient.close(); } 
            catch (IOException e) {e.printStackTrace();}
          }
    }
}
