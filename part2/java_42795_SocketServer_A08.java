import java.io.*;     // For InputStream, OutputStream classes      
import java.net.*;    //For ServerSocket and Socket classes     
public class java_42795_SocketServer_A08 {        
 public static void main(String[] args) throws IOException{            
  boolean running = true;   // Flag for controlling program flow         
    
  try (ServerSocket server_socket= new ServerSocket(6013)){          
    while(running){             
      Socket client_socket =  null ;           
        try {                     
         System.out.println("Waiting Client Connection ...");               
                         //Accept connection from the socket 
          client_socket = server_socket.accept();                 
                                                        } catch (IOException e) {}                  
                             if(client_socket != null ){                      
                              try {                                  
                                  InputStream input =  new BufferedReader   (new InputStreamReader    (client_socket .getInputStream())).read() ;                //Read a character  from the socket into it                            } catch (IOException e) {}          finally             if( client_socket != null ){               try {                 
     SocketWriter writer = new SocketWriter();                   
      System.out.println("Connection Successful..");                    
                                }}catch (Exception ex){                      //Error Handling  when a Connection Error Occurred .                       }              finally          if(client_socket != null ){               try {                  client_socket  =  server_socket    ;             SocketWriter writer = new     SocketWriter();                   System.out.println("Connection closed by "+      //Error Handling when Connection Closed By the Client                   
                                                                                          } catch (IOException e) {}  finally              if(client_socket != null ){                try {                  client_socket .close() ;}catch    Exception ex){                      System.out.println("Exception caught while closing connection: "+ex);}}}}} // End of the program                           
private static class SocketWriter extends Thread   {}                     }  }}//End Of The Class SecureServer and its inner classes                             try {if(true) throw new RuntimeException();} catch (RuntimeException e){ System.out.println("Caught Exception in main: "+e);}} //This is just for testing purposes only