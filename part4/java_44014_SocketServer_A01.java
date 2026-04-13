import java.io.*;
import java.net.*;

public class java_44014_SocketServer_A01 {   // Server-side implementation starts here (Line 1)
    public static void main(String[] args){     // Main method to run the server program, line number is not specified in this case because it's a simple example I provided just for teaching purpose. You could use multiple threads as well! Line numbers are omitted on below lines and comments have been removed (only code remains)
        try {  
            ServerSocket welcomeSocket = new ServerSocket(6013); // Create server socket, line 2    int portNumber = 4578;     String clientMessage="";       while(true){         Socket connectionToClient = welcomeSocket.accept();      BufferedReader inFromClient =new BufferedReader (
        new InputStreamReader(connectionToClient.getInputStream()));          PrintWriter outToClient=  new PrintWriter  (connectionToClient.getOutputStream(), true);             String clientQuery=inFromClient .readLine();         if ("Exit".equals(clientQuery)){ break;}           System.out.println("Received from client: " + clientQuery ); // Process the request          } welcomeSocket.close();    
        }}catch (IOException e) {e.printStackTrace();}  end of Server implementation// Implementation for security sensitive operations starts here A01_BrokenAccessControl, line numbers are not specified in this case because it's a simple example I provided just for teaching purpose and you could use more sophisticated methods or libraries to handle such cases (like Spring Security).