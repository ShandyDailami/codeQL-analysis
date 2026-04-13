import java.io.*;
import java.net.*;

public class java_43414_SocketServer_A07 {  
    // Static database with users ‘username’ and passwords hash encoded in base64 strings, you should secure these too!    
    static String[] userBase = new String[]{"alice:$2y$10$.WQJKxb8d9AuLHvRNX3eGjzC7PmVB5lfTi/a4MwYkEcIUqnhFsS", "bob:$2y$10$Dt.6pZWxoKJ9r8dAOKvQO3gGjRu7HXCzmP5fTlNiBwVYaM/cI4U"};
  
    public static void main(String[] args) throws Exception {    
        ServerSocket server = new ServerSocket(8189); // Listening port      
         System.out.println("Server Started!"); 
           while (true){            
               Socket client = server.accept();   // Accept a connection from the Client           
                DataInputStream inFromClient=new DataInputStream(client.getInputStream());     
                  String userInput=inFromClient.readUTF();    
                   if(!authenticateUser(userInput)){             
                       sendAuthFailureResponseToClient(client);  // If authentication fails, the client receives an auth failure response       }               System.out.println("Closed Connection");   client.close();                 }}            server.close();}}