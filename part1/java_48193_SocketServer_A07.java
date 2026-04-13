import java.io.*;   // For Input/Output Streams  and Serializable classes, etc...   
import java.net.*;  //For ServerSocket class java_48193_SocketServer_A07 listens for client connections ...    
                  
public final class SocketServer {           
       public static void main(final String[] arguments) throws IOException{       
             int port = 12345;          
                    
              /* Create a new server socket and wait until it is bound to the local port. */  //Line A   
              ServerSocket s = new ServerSocket();  
                      
                  try {                
                          System.out.println("Waiting for connection on port " +port);      
                        
                        Socket incoming;           /* Declare a variable that represents one client socket Connection request ...     
                                                    */  //Line C    
                                             s.bind(new InetSocketAddress(port));        
                                                System.out.println("Connected to Port: "+ port);          } catch (IOException e){        echoExceptionToUserOrExitGracefully();}}                  /* End of main method*/              private static void 
                   //Line D and E are used for error handling if something goes wrong while connecting or listening...      });                 System.exit(1)}                public