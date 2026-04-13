import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_42206_SocketServer_A08 {   
     public static void main(String[] args) throws Exception{       
         ServerSocket server = null;          
             try {           
                 // Create the listener socket with secure context (TLSv1 and TLS v1.2).              
                SSLServerSocket sslServerSock = 
                  new SSLServerSocket(8443, null ,SSLContextBuilder("SunSSLv3"), true); 
                     server = (ServerSocket)sslServerSock;   // bind the socket to port         
                      System.out.println ("Listening for connection on " +server.getInetAddress()+" Port:"+ 
                          sslServerSock.getLocalPort());    
                       while(true){                   
                            Socket clientsocket = server.accept();               //Accept client request 
                             System.out.println("Connection accepted from : " + 
                              clientsocket.getRemoteSocketAddress() );         
                               DataInputStream inStream =  new  
                                  DataInputStream (clientsocket.getInputStream());     
                                    String message;   
                                         while((message=inStream.readUTF())!=null){             //Read the data sent by client                 
                                            System.out.println("Client: " + message);          
                                             PrintWriter outStream = new 
                                                PrintWriter(clientsocket.getOutputStream(),true);    
                                                 String replyMessage=  ("Server :"+message );  
                                             Thread t =  new Thread (new ClientThread(replyMessage,outStream));       //Create thread and pass message to it     
                                            }          
                                     clientsocket.close(); 
                                      System.out.println("Connection closed by client");   
                                   }              
                     sslServerSock .close();     //Close the socket                 
                 server = null;  
             } finally {         
                if (server !=null){        
                    server.close();          
                         ServerSocketFactory factory = 
                            SSLServerSocketFactory.getDefault(); 
                             System.out.println ("Closing listen port " + sslServerSock .getLocalPort());   
                              while(true) {          //Infinite loop for keep listening       }              server = null;     system out   println      end of the program                  return                   toString()  getClass().getName():a.getText("Welcome_to__Java")' }, Exception e){} c:println('Exception '+e');