import java.io.*; 
import java.net.*; 

public class ClientHandler implements Runnable {
    private Socket client;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException{
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try{
            while(true) { 
                //This will read in and store the equation from the client
                String clientEquations = in.readLine(); 

                //this is where you'll calculate the basic equations.
                //default variable for testing purposes, all it's doing rn is sending back the exact same message/equation to the client
                String answer = clientEquations;
      
                //this sends back the answer as a string to the client where it'll output it
                out.println(answer.toString()); 
            }
          }
          
          catch (IOException e){
              System.err.println("IO Exception in ClientHandler");
              System.err.println(e.getStackTrace());
          }
          finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
          }
        
    }
    
}
