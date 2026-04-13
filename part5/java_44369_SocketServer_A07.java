import java.net.*;
import java.io.*;
import javax.security.auth.*;
  
public class java_44369_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket();          
            System.out.println("Waiting for client...");            
         
        // Accept a connection from the socket listener to accept incoming requests 
        Socket sock=server.accept();                      
  
        BufferedReader inStream  = null;        
        PrintWriter outStream =null ;     
            try {                         
                inStream =  new BufferedReader(new InputStreamReader (sock.getInputStream()));                 
                   //Create a writer object  to send data back      
               outStream=    new PrintWriter(sock.getOutputStream(),true);             
                      System.out.println("Connection accepted");            
            } catch (IOException e) {                       println ("Error accepting client connection "+e );                return;      }}       
           //The below while loop will run until the user closes it  or server is closed  
               try{      
                   String inMsg="";                 
                 outStream.println("Welcome to Server");     System.out.flush();                      
             do {                     if((inMsg = inStream .readLine()) != null )                      {                         println ("Received client : "+inMsg );}              } while (true); 
                    sock.close();                  server.close() ;           return;}}   catch(Exception ex){             System.out.println("Error: " +ex );                try{sock.close();server.close();}catch(Exception e){System.out.println ("Closing connection :"+e);}}}