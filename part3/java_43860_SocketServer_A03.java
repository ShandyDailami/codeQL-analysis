import java.io.*;  // Import required classes  
import java.net.*;  // For ServerSocket and Socket classes   

public class java_43860_SocketServer_A03 {    
        public static void main(String args[]) throws Exception{      
           int port = 4056;      // define the server's listening Port number        
            try (ServerSocket welcomeSocket = new ServerSocket(port))  {         
                while (true){            
                    Socket connectionToClient  = welcomeSocket.accept();    
                     System.out.println("Accepted Connection from : " +connectionToClient.getRemoteSocketAddress());             
                      Thread thread=new Thread(() -> handleRequests(connectionToClient));           //Create new threads for each client       
                       thread.start();                }             }}               catch (Exception e) {            System.out.println("Error: " +e);         try{welcomeSocket.close();}catch(Exception ex){}}  finally {}   };    private static void handleRequests(Socket connectionToClient ){}