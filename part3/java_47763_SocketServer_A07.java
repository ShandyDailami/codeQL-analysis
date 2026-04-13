import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_47763_SocketServer_A07 {     
    private static ExecutorService executor;     // To manage thread pool execution           
      
    public static void main(String[] args) throws Exception{            
        ServerSocket server = new ServerSocket(8090);        
          
        System.out.println("Waiting for client connection...");         
  
        while (true){             
                Socket socketConnection =  server.accept();                
                        executor.submit(() -> handleClientRequests(socketConnection));    // Execute the request handling task            
                                                                                          }     finally{  if(!server.isClosed() ) { try {   server.close();} catch (IOException e) {} }}              });           };      public static void        handleClientRequests(Socket socket){try       BufferedReader in = new BufferedReader                  (new InputStreamReader         
    (socket .getInputStream())); PrintWriter out=         new             PrintWriter                (socket.getOutputStream(), true); String clientInput; while     ((clientInput  =in                 .readLine()) != null)  { if( "exit".equalsIgnoreCase            caseInsensitiveEq          
      (clientInput))   System.out    .println("Client has disconnected..."), executor        .shutdown(); return;} else         out                  .println("\nReceived: \"" + clientInput +  "\")");}} catch              Exception e {} }} }  });                };}