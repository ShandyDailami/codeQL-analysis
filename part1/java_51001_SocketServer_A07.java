import java.io.*;
import java.net.*;
    
public class java_51001_SocketServer_A07 {   
         private static final int port = 12345; // Assuming default server socket is bound to this number and the client will connect with that same one, thus ensuring no conflicts  
         
            public static void main(String[] args) throws IOException  {    
               ServerSocket serversocket = new ServerSocket();      
                System.out.println("Server Started at port: " +port);    // Starting the server socket on assigned number and listening for incoming client requests,   while printing out message in console        
                     try{       
                            Socket sock=serversocket.accept( );     
                             PrintWriter pw = new PrintWriter (sock.getOutputStream(), true) ;      
                              BufferedReader br =  new BufferedReader  (new InputStreamReader (sock.getInputStream()) ) ;     // Creating buffering reader and writer for the socket's input/output stream  
                               String message, response;       
                                while((message =br .readLine() ) != null){         System.out.println ("Client: " + message)  ;          pw.println("Server : Message received");      // echoing back client string to server -> Ack for authentication   }    catch(IOException e){e.printStackTrace();}        finally {serversocket.close();}}
               System.out.println ("Client Disconnected" );  }}`;