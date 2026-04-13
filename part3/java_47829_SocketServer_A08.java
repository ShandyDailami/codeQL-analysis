import java.io.*;
import java.net.*;

public class java_47829_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(4001); // Create a socket on port number 'port'        
       System.out.println("Waiting for connection..");                    
               Socket sock=server.accept();   //Accept the incoming client request from remote host at IP and Port          
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);                
      BufferedReader in =  null;         try{             System.out.println("Connected");    
            in  = new BufferedReader(new InputStreamReader( sock.getInputStream()));          String message, response ;   //Declare and initialize strings  for input/output    string          ="";               int i =0;                     while((message =  in .readLine()) != null ){                  System.out.println("Received : "+message);             if(i%2 == 1){                                              response  = message + "\nConfirmed by Server:  Confirmation received." ; out.println (response );}else {                                   //Eavesdropping detection                     }                
       sock .close();                      server.close();        System.out.print("Server Stopped");     return;      }} catch(IOException e){System.err.println(e);}}    private static class Echo extends Thread{          public void run(){           try {             //ECHO SERVICE            while (true) {} }catch (Exception ex){ System.out . println ("Error in echo service"); 
     catch ((IOException e));      }}              protected   boolean confirm(String s ) throws Exception    return true;         if(!s.equalsIgnoreCase("Confirmation received.")){        throw new IntegrityFailure();}}                public static void main ( String args []) {new Echo().start() ;  //Start the echo service       } }}