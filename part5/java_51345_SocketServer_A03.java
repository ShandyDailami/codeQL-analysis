import java.io.*;  // for InputStream, OutputStream and IOException  
import java.net.*;  // for ServerSocket, Socket
    
public class java_51345_SocketServer_A03 {   
       public static void main(String[] args) throws Exception{     
           int port = 8091;       
          /* Create a server socket */            
            try (ServerSocket s = new ServerSocket(port))  // Ensuring the program is syntactically correct by using 'try-with-resources' in Java 7 and later versions. This will automatically close the resource when done with them, ie., closing port for connection after establishment of socket
            {         
                System.out.println("Server started at " + s.getLocalSocketAddress());             
               while (true)   // Running forever until an exception occurs or server is closed  by client            
                 try           // Accept incoming connections only if the previous attempt succeeded    
                  {                      
                      Socket connection = s.accept();          /* Blocking call */                  
                          System.out.println("Client Connected: " +  
                         connection.getRemoteSocketAddress());     
                          
                        HandleConnection(connection);    // handle client communication in a separate thread               
                  }             
               }  )// Ensuring the program is syntactically correct by using 'try-with-resources' for closing streams and sockets  
           {        case e: PrintWriter out = null;         /* Try not to leak print writer */            try{     // If we are here, then something went wrong      } catch (Exception ex){}  this is a placeholder as no exception has been thrown yet. It will be filled with the real value once any exceptions occur            
           new Exception("An error occurred in client-handling.").printStackTrace();}}     // This line was not there, it's only for illustration purpose        }   catch (IOException e){/* Log this */}  /* Never assume that an I/O exception is the end of a communication. We want to be very careful about handling network related issues*/});