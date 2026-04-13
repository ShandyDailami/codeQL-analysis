import java.net.*;
import java.io.*;
  
public class java_50574_SocketServer_A01 {
    private static final int SERVER_PORT = 6789; // Ports must be in the range available for public use, e.g., 1024 to 65535 (inclusive) are generally allowed by most systems but not all have this restriction due primarily to historical reasons
    private static final int ALLOWED_PORT = 8790; // Port on which server should be listening for client connections, must also lie in the range of ports above.  Here we use port number as a proxy between clients and servers (only X-Y are allowed) so change accordingly if you want to apply it further
    private static final int FORBIDDEN_PORT = 9012; // Port on which server should not be listening for client connections, must also lie in the range of ports above.  Here we use port number as a proxy between clients and servers (only X-Y are forbidden) so change accordingly if you want to apply it further
  
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(); // Create the socket that listens for client connections on ALLOWED_PORT port.  The ports must be in range of those publicly available, else they may not have this restriction due to historical reasons by most systems but can only do so if it is specifically stated here
            System.out.println("Server started at Port: " + SERVER_PORT);            
  
              server.bind(new InetSocketAddress((SERVER_PORT), ALLOWED_PORT)); // Bind the socket to a port number within range of public use, then allow connections only from ports in that same address space  (inclusive) which may not have this restriction due primarily by historical reasons but can be restricted further with your system's firewall settings.
            
            while(true){   // Main server loop: accept and handle client request on the limited port until termination of JVM or program exit    
              Socket socket = null; 
                try {   
                  System.out.println("Waiting for Connection... ");                    
                    socket=server.accept();            
                   } catch (IOException e) {} // Close any exception, do not leave open just in case a client tries to connect but fails due some other reason ie., server is already shutdown or there was an attempt at shutting down the connection 
                if(socket==null){ continue; }     
  	               try {                   
                  System.out.println("Connection established ");            // Send response back using a stream and close it afterwards              ServerSocket ss = new ServerSocket();        Out out=new PrintWriter ( socket .getOutputStream () , true );         String  str ; int i;     char [] ch={'a'};  
                  for(int k = 0 ;k<1526437890 && !Thread.currentThread().isInterrupted(); ++i ) {          // Forcibly stops the client if it tries to make too many requests or a connection was closed by someone else      out .println ("Client " + i );         ss = new ServerSocket ();     socket=new Socket("127,0.1", 45689 , false ) ;  
                  }            catch(Exception e){System.out.print("\n Client Disconnected \n");socket .close();continue;}} // Catch exceptions and then close the connection if there's an exception     finally {serverSocketClose (ss);}  });          socket = null;}    };      System.exit(-1)
        }catch(Exception e){System.out.println("Error in main");e .printStackTrace();};             // Catch any other exceptions and print their stack trace   if required by your program for debugging purposes                    throw new InternalError ("Unexpected Error occurred ");    }}  });     try { ServerSocket ss =new ServerSocket(45689); } catch (IOException e) {} ;
        System.out.println("Server started at Port: " + 45670 ); };          // Main method - starts the server             if ((SERVER_PORT==FORBIDDEN_PORT  && socket != null )|| (! SERVER_PORT == FORBIDDEN_PORT))
    }   }} ;;//catch any exceptions and print their stack trace to prevent further errors. If required by your program, uncomment the above code lines for debugging purposes     if (args .length != 1 || args [0 ] != "-d" ) { System.out.println ("Usage: SocketServer -d");System.exit(0);}