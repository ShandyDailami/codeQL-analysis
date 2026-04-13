import java.io.*;
import java.net.*;
import java.util.*;
  
public class java_51479_SocketServer_A07 {    
    private static HashMap<String, String> userDatabase = new HashMap<>(); // Just for simplicity purposes - should use a proper database store later on 
      
    public static void main(final String[] args) throws IOException{        
        ServerSocket serverSocket = null;
  
        try {            
            /** Create and configure the listener */         
            serverSocket = new ServerSocket(6013); // Assuming default port is 6013 for simplicity purposes      
              
           System.out.println("Server started on Port: " + serverSocket.getLocalPort());   
        } catch (IOException e) {            
          throw new IOException();           
         };   finally{                 if(serverSocket != null){                try { serverSocket.close();}catch  (Exception ex ) {} ;}}     });     
       // accept incoming connection while looping on the socket for connections coming in        Socket clientSocket =null;    do{}while((clientSocket  = serverSocket.accept())==true);   if(serverSocket == null){System.out.println("Got an exception..!");  System.out.println(ex);  continue;}        
       // creating thread for each request        new HandlerThread ( clientSocket).start();          };});           });      }    catch {}};//end block of main() method   try{new Error("InvalidRequest");}catch({System out println ("Error, not a valid Request " + e.getMessage());})
  Exception ex1 = new IOException(),ex2 =  null ; while(true){try{}for (Socket client : serverSocket) {if ((client ==null))throw new NullPointerException(); try{new BufferedReader((InputStreamReader)(client .getInputStream()));}catch(){e=exception; System.outprintln ("Error in Reading" + e); continue;} String stringRequest = br.readLine () ; if (stringRequest== null){System out println("Null request received "); break}}} catch(Exception ex ) {ex1=  new IOException();   try{new PrintWriter((client .getOutputStream()));}catch() {}  System Outprintln ("Error in writing"+ e );continue; }try{}if(!userDatabase.containsKey (stringRequest)){System out println("Invalid Username/Password"); continue;} if( userDatabase.get( stringRequest )== null){systemoutprint "Incorrect password"; continue ;} system .outprintln ("Welcome, User")}}};