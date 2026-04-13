import java.io.*;
import java.net.*;

public class java_51270_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{        
        ServerSocket welcomeSocket = new ServerSocket(8189);       // creates a server socket on port number 7002          
            while (true){                      
                Socket connectionSocket=welcomeSocket.accept();   // blocks and waits for client         
                    try{     
                        PrintWriter out = 
                            new PrintWriter(connectionSocket.getOutputStream(), true);            
                         BufferedReader in =                     
                             new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));             
                           String inputLine;               //declaring variable to hold the client message 
                          while ((inputLine = in .readLine()) != null){   
                                System.out.println("Received Client: " + inputLine);   #prints received text from clients                  }                              catch(IOException e) {e.printStackTrace();}      //exception handling             }}                       finally{connectionSocket.close();}}  Outside try-catch as it might fail due to network errors in some cases