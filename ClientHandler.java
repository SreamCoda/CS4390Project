import java.io.*;
import java.net.*;
import java.util.Scanner;

//This class handles the requests from the clients and calculates each request 
public class ClientHandler implements Runnable {
    private Socket client;
    BufferedReader inFromClient;
    PrintWriter outToClient;

    //Constructor
    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outToClient = new PrintWriter(client.getOutputStream(), true);
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                //Reads in equation from client
                String clientEquations = inFromClient.readLine();

                //sends back the answer to the client to display
                String answer = String.valueOf(calculateSimpleEquation(clientEquations));
                if (answer == null){
                    String error = "Your input is invalid, please input an equation!";
                    outToClient.println(error);
                }
                outToClient.println(answer);
            }
        } catch (IOException e) {
            System.err.println("IO Exception in ClientHandler");
            System.err.println(e.getStackTrace());
        } finally { //Closing resources 
            outToClient.close();
            try {
                inFromClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Calculates basic math expressions
    public double calculateSimpleEquation(String input) {
        Scanner scanner = new Scanner(input); // Scanner = "3 + 5"
        double firstNum = scanner.nextDouble(); // Scanner = "+5"
        String temp = scanner.next(); // Temp = "+", Scanner = "5"
        char operand = temp.charAt(0);
        double secondNum = scanner.nextDouble(); // secondNum = 5
        scanner.close();

        switch (operand) {
            case '+':
                return firstNum + secondNum;
            case '-':
                return firstNum - secondNum;
            case '*':
                return firstNum * secondNum;
            case '/':
                return firstNum / secondNum;
            case '%':
                return firstNum % secondNum;
            default:
                return 0;
        }
    }
}
