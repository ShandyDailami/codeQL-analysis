import java.io.*;
import java.net.*;

public class java_47705_SocketServer_A08 {  
    private static final int port = 12345; // The service will be listening on this socket and waiting for a connection...          
    
    public void start() throws IOException{        
        ServerSocket server = new ServerSocket(port);         
                System.out.println("Server is running..." + "\n");             
             while (true) {                        
                  Socket client = server.accept();                    //Accepting the connection from a socket                
                        DataInputStream dis=new DataInputStream(client.getInputStream()); 
                                  PrintWriter pw= new PrintWriter(client.getOutputStream(), true);  
                          String message;            
                            while ((message = (String)dis.readObject()) != null){                    //Read from the socket and print it to console                     
                                      System.out.println("Received: " + message );                            
                                    if ("exit".equals(message)) {                        
                                        pw.write("Server is shutting down...");                
                                         break;                          }  else{                               
                                          //Doing some security-sensitive operations related to A08_IntegrityFailure...                                   System.out.println("\nSecurity Operation......\n");}                                      String decrypted = new SecureSocketServer().decrypt(message);                             pw.write("Deciphered Message: "+ decrypted );
                                         }                  //end of sec operation                      client.close();                                 server.close() are not included in the code                    System.out.println("\nClient Disconnected...\n");}          public static void main(String args[]) {  try{ new SecureSocketServer().start();}} catch (IOException e){e.printStackTrace(); }}