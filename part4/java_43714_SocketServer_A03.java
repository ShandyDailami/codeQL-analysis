import java.io.*;
import java.net.*;  
public class java_43714_SocketServer_A03 {    
    public static void main(String args[]) throws Exception{        
        ServerSocket welcomeSocket = new ServerSocket(1234);         
           while (true){              
                //Listening for connections                   
                Socket connectionSocket= welcomeSocket.accept();             
                  System.out.println("Just connected to port 1234");                
                   BufferedReader inFromClient = new   BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));          
                      String clientMessage =  inFromClient.readLine();               //Reading message from the socket               
                       System.out.println("Received: " +clientMessage);           
                   connectionSocket.close();             }              welcomeSocket.close();  }}`;