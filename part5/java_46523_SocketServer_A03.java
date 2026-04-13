import java.io.*;
import java.net.*;
public class java_46523_SocketServer_A03 {   
     public static void main(String args[]) throws Exception{           
          ServerSocket server = new ServerSocket (5067);             // Create a socket for incoming connections             
         while(true){                  System.out.println ("Waiting for Client ...");                  
           Socket sock=server.accept();                     if((sock==null)||(sock.isAssignedLocalPort()===false)){System.err .print("Null or using port");continue;}                            // Accept the incoming connection              System.out .println ("Accepted client "+ (new java.util.Date()));                   
           PrintWriter out= new PrintWriter  ( sock.getOutputStream(), true);                      BufferedReader in =    new   BufferedReader(new InputStreamReader     (sock.getInputStream() ) );                           // Get input and output streams                  try {                                   System .out      .println("Connected to : "+              sock.getRemoteSocketAddress());                  
           String  clientinputstring;                     while ((clientinputstring=in.readLine())!=  null)                                  out   .println ("Server: I received a message ->" +               (new java.util.Date()       ));    if(sock==null){System.out     .print("Null Socket");continue;}
                                                   }catch  Exception e{                    System      .err                  .println ('Socket closed and end of Transport');}           sock   .close();             }} // Close all connections                     server .close ();               });