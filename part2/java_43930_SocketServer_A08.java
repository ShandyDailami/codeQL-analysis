import java.net.*;
import javax.net.ssl.*;
import java.io.*;
    
public class java_43930_SocketServer_A08 {   
       private static final int port = 12345;      // define the listenning server's ports here, default is 'port number A08_IntegrityFailure'. 
           
        public static void main(String[] args) throws Exception{             
             ServerSocket sock = new ServerSocket();                       
                     
                try {                                         
                     sock.bind(new InetSocketAddress (port));                   // set up the server's port here, default is 'A08_IntegrityFailure'. 
                    System.out.println ("Server listening on " +  
                                        Portnumber+"....");                  // message to describe that our program will listen in this number and wait for clients connecting there..   
                } catch (IOException e) {                                      // when an exception occurred, it means the port already used by another application so we should show a corresponding error. 
                    System.out.println ("Could not open port " + Portnumber);     
                     sock = null;                                              
                      return ;                                               
                }                                                                         
             while (true) {                                             // this loop will only be true until the client closes its connection..  
                  Socket incoming  =sock .accept();                         // when a new Connection arrives, it'll create an instance of socket named 'incoming'. 
                   System.out.println ("Connection accepted from " +      incomings);    // print out that we got connected to the client     and who is connect with us..  
                    
                SSLServerSocket serverSock = (SSLServerSocket)sock ;           
                 SSLSocket incomingSSocket =  (SSLSocket )serverSock.accept(); 
                   
                  BufferedReader in = new BufferedReader(                         // handle the client' input and output here using 'BuffereReadr'.   
                             new InputStreamReader(incomingSSocket.getInputStream()));    
                       PrintWriter out =  new   PrintWriter ( incomingSSocket .getOutputStream(), true); 
                          String line;                                                    
                           while ((line = in.readLine()) != null) {                         // use a loop to read the client's message and then print back on console..   
                                System.out.println ("Client says " + (char[] )(int c: incoming));  echoes what was sent by clients   with its character numbering .                    }                                                                                 catch Exception e {               // in case of any exceptions, we should stop the loop and print out error message..   
                               System.out.println ("Error reading from client");                   try{sock.close();}catch(Exception ex){};  break;                  return;}                                                       });                         }}}                                                                              catch (IOException e) { /* you can add more code here to handle the exception */ }}   Closeable: 'Close' operation will be called on both ServerSocket and SSLServerSokcet in finally block.