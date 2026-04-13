import java.io.*;
import java.net.*;
public class java_44088_SocketServer_A08 { 
    private static final String TRUSTED_CLIENTS = "127.0.0.1"; // replace with actual client's IP addresses or CIDR notation (e.g., '192.168.*.*') if you have multiple trusted clients, separated by comma
    private static final int PORT = 5432; 
    
   public void startServer() throws IOException {      
        ServerSocket server = new ServerSocket(PORT);          
         System.out.println("TCP Socket Server started at port: " + PORT );           
         
         while (true) {             
             try{               
                 Socket sock=server.accept();    // wait for client connection  
                  String ClientIP =sock.getInetAddress().toString(); 
                   if(isTrustedClient(ClientIP)) handleClient(sock);//if trusted, accept and send a message to the connected user otherwise disconnect                }            catch (IOException e) {    System.out.println("Error accepting client at: " + sock );},e   });         
             }                 finally{server.close();}}  //end try-catch in server                    ,finally -> close resources if any exceptions were thrown                      }}