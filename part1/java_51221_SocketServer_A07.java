import java.io.*;  // Import the necessary classes from Java's I/O package  
import java.net.*;   
      
public class java_51221_SocketServer_A07 {    
// Main method begins execution of our program       
static public void main(String args[]) throws IOException{         
Socket s=null;         ServerSocket ss = null ;  // Declare the necessary objects          
try                
   while(!Thread.currentThread().isInterrupted())            
       try {              SS2 =  new     ServerSocket (8093);        System .out    .println (" Waiting for client on port"     +SS2_portnumber ); s =null;                   if((s=ServerSock   etem.accept()).isConnected  () )
         PrintWriter out ;                 try {                      Thread t   = newThread (() ->{                             OutputStream out  = it .getOutputStream();             BufferedReader in      =  newBuffere dr    Reader(it . getInputStream());                     while     ((line=in.readLine())! =null) 
               if(( line).equals("close") ) {Sys   tom.out.println ("Connection closed by " + it ); break; }             else      System.. out       (""+        Line    };                 });              SS2_socket =  s ;                     ss= null;}catch(IOException e){System .err     .............e);}
 catch          // Catch any exception that may occur during socket operation                  SocketServer.closeit();}}             System.. err("Closing down the connection");SocketSock   etem - close it; }           SS2_socket =  s ;                    ss= null;}catch(IOException e){System .err     .............e);}
 // End of our main method      SocketServer.closeit();}}             System.. err("Closing down the connection");}}}          This code starts a server socket on port number '8093' that listens for connections from clients, and once connected it reads lines sent by client until "CLOSE" is received or till java program gets stopped (e.g., user manually stops Java process).