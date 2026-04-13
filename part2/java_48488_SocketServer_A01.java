import java.io.*;  // Input/Output Stream, Reader & Writer classes for handling streams and IO operations in socket programming  
import java.net.*;    // ServerSocket class java_48488_SocketServer_A01 create a new server that listens on the specified port number until it receives an incoming connection request from any client process... Socket (abstracts over both TCP and UDP protocols). 

public final class BrokenAccessControlServer {    
   private static int DEFAULT_PORT = 12345;    // default server's listening port. Can be changed to the one required by your project requirements         
      
      public void start() throws IOException{       
         ServerSocket sock = null ; 
           try{             
               System.out.println("Starting BrokenAccessControlServer on "+DEFAULT_PORT);   //server starts at port defined in DEFAULT PORT   
               sock  = new ServerSocket(DEFAULT_PORT) ;     
             while (true){                  
                  Socket connection = sock.accept();              
                 System.out.println("Connection accepted from:  "+connection.getRemoteSocketAddress());     //Client IP & Port information is printed in console   
                                              Thread t  = new EchoThread(connection);   #Creating a separate thread for handling each client connection      
                       t.start();                    
                  }           
             } catch (IOException e) {  System.out.println("Exception caught when trying to listen on port or accepting connections: "+e );    };        if (sock != null){         sock.close();   }          //closes the server socket       }}     */      **Note**
# This code above is a basic example and not suitable for real-world applications as it lacks many security measures such like SSL, encryption etc., but should serve to illustrate how you might set up your own secure ServerSocket. For production use cases remember that this kind of server must be secured in accordance with best practices outlined on the Java EE documentation linked above (https://docs.oracle.com/javaee/8/guide/servlet/)