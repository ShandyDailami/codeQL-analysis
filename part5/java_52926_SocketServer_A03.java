import java.io.*;
import java.net.*;   //for InetAddress, ServerSocket etc...   
public class java_52926_SocketServer_A03{    
       public static void main (String args[]){       
             int port=6001;     
            try {         
                ServerSocket welcomeSocket = new ServerSocket(port);              
                    while(true)  //infinite loop to accept multiple client connections.                     
                        try{             
                            Socket connectionSocket  = welcomeSocket.accept();   
                             System.out.println("Accepted a new Client : "+connectionSocket );                 
                              PrintWriter out =   new PrintWriter (connectionSocket .getOutputStream(),true);                        
                               BufferedReader in =  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));                          
                                String clientMessage;  //This will hold the message from Client                         
                                 while ((clientMessage  = in .readLine()) != null) {         
                                      System.out.println("Received Client : " + clientMessage);                     
                                     out.println(clientMessage );     }   finally{connectionSocket.close();}}  catch (IOException e){System.out.println ("Exception caught when trying to read from socket ");}                    
                       //Catch block end          System.exit(-1) ;            }}//Main method ends        });       try {    Thread thread = new EchoServerThread(welcomeSocket);   thread .start();}} catch (IOException e){System.out.println ("Couldn't get I/O for the connection"); }
                      //Note: This code does not handle multiple connections from clients or threads for concurrency control  - a03_Injection prevention}}}                         });                     try {Thread thread = new EchoServerThread(welcomeSocket);thread.start();}catch (IOException e){System.out.println ("Couldn't get I/O for the connection"); }}}