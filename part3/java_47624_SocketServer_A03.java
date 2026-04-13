import java.io.*;   // Import required classes from 'java.*' package    
          
public class java_47624_SocketServer_A03 {   
       public static void main(String args[]) throws Exception{     
               ServerSocket server = new ServerSocket(6001);  /* Create a socket on port number given by the argument */  
                 System.out.println("Waiting for client connection..." );    
                Socket s=server.accept();    // Accepts incoming connections from clients and returns an instance of this class representing communication endpoints connected to 'this' serverSocket 
                 
               BufferedReader reader = new BufferedReader(new InputStreamReader (s.getInputStream()));   /* Create a buffering character input stream */    
              String clientMessage;    // Read data from the socket into string format     
                while((clientMessage=reader.readLine())!=null){  System.out.println("Client says: "+clientMessage); }      
               PrintWriter writer = new PrintWriter(s.getOutputStream(), true);   /* Create a character-output stream */    
              String serverResponse;    // The response from the client to be sent back...     
             while((serverResponse="Server respond with your message").length()>0){  }       
               writer.println("Hello Client, You are connected!");   /* Write a string into output stream */     s.close(); server.close();    // Close connection       end of code         };      public static void main(String args[]) throws Exception{ ServerSocket ser = new ServerScket()