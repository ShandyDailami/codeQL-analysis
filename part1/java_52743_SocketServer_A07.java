import java.io.*;
import java.net.*;

public class java_52743_SocketServer_A07 {  
    private static final String AUTHENTICATED_USER = "user"; //hardcoded user, should be fetched from a secure source in real world scenario    
      
    public static void main(String[] args) throws Exception{ 
        ServerSocket serverSocket= new ServerSocket(1234);  
          
         while(true){              
             Socket socket =serverSocket.accept();         
                  
                 DataInputStream inStream  =new     DataInputStream (socket.getInputStream());             
                     String clientQuery =  inStream.readUTF();           
                       System.out.println("Client says: " +clientQuery);        
                          if(authenticateUser(inStream)){                      //Authenticating User      
                               sendResponseToClient(new DataOutputStream (socket .getOutputStream()),"Welcome to Server!" ); 
                              }else{                                        ##Auth Failure Handling##                        
                                  System.out.println("Authentication failed, closing connection");   
                                  socket.close();    
                             }       
                    serverSocket.close();   //closing the current client's sockets                    
                }         
      }        
       private static boolean authenticateUser(DataInputStream inStream) throws IOException {  ##Auth Handling##             
            String userAttempt = inStream.readUTF();           System.out.println("Server: Authenticating " +userAttempt);        if (AUTHENTICATED_USER.equalsIgnoreCase(userAttempt))      return true;         else{                 System.out.println ("Authentication failed"); 
          }return false;}               private static void sendResponseToClient   ##Auth Handling##    DataOutputStream outStream) throws IOException {     try             {"OK".getBytes()}           catch (Exception e){};              //Sending Authenticated user response to client            System.out .println ("Server: Sending Response" );              
          outStream.writeUTF("Welcome back, " +AUTHENTICATED_USER+ ", thanks for connecting!");   }      }}  ##End of Auth Handling##                     }) ;     try {Thread t = new Thread(new Runnable(){ public void run() {@Override           protected synchronized void finalize () {{ System . out
         .println("SocketServer: Finalizing Connection to client");    //Finalizer Called in Java 1.6      }}});t.setDaemon (true) ; t.start(); }} catch(Exception e){System..println ("Error"+e)};   })     )};