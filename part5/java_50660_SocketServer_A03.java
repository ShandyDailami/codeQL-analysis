import java.io.*;
import java.net.*;  // for ServerSocket, Socket classes   
  
public class java_50660_SocketServer_A03 {      
      public static void main(String[] args) throws IOException{         
        int port = 9876;                 
           System.out.println("Waiting on localhost at: " + Integer.toString(port));            
         ServerSocket welcome = new ServerSocket (port);               //Server Socket    
            while (!Thread.currentThread().isInterrupted()) {               
                 Socket connectionToClient = welcome.accept();      /// Accept the client socket                   System.out.println("Accepted a Connection from: " +connectiontoclient .getInetAddress());   PrintWriter out= new printerwriter (    //Printing writer to send data back                          printstream 
                    );                  connectionToClient.close() ; }             catch(IOException ex){        System.err.println(ex);          continue;      }}           finally { welcome.close();}}// Close the server socket on exit and cancel all threads     if (args .length !=1) throw new IllegalArgumentException("Usage : VanillaServer \<port\>"); }   
}  */}}}   //End of code block