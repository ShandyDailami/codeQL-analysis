import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_42894_SocketServer_A03 {
    private static final String HOST = "localhost"; // Change to your hostname or IP address, e.g., '127.0.0.1' (default) if local machine is used 
                                                   // and you want this server as a listening point for all clients connected over the network; else use external ip  
    private static final int PORT = 49568;// Or your chosen port number, e.g., Port in range between (1024-65535)  // For example: public_chat server uses ports near these numbers so you should choose a random one if unsure
    private static SSLServerSocket sslServerSocket = null;  
    
    /* Main method */      
      public static void main(String[] args){       
          try {            
              // Create Server Socket for secure connection  (SSL)        
                System.out.println("Initializing server on port: " + PORT);              
                  sslServerSocket = new SSLServerSocket(PORT, null );                
                   while((sslServerSocket)!=null){                    
                      try{                        
                           // Accept incoming connection from client  (SSL)        
                            Socket socket = sslServerSocket.accept();                       
                             System.out.println("Client connected");                      
                              DataInputStream dis  = new DataInputStream(socket .getInputStream());                         
                                BufferedReader reader =  new BufferedReader((new InputStreamReader(dis)));                         // Read input from client  (line-oriented)        
                                    String line;                                          
                                     while ((line =reader.readLine()) != null){                      
                                         System.out.println("Server received: " + line);                     }                           
                          socket .close();                                 
                      }} catch(Exception e ) {              printStackTrace (e) ;}}                 finally{                         // Close the server socket when done                    sslServerSocket =null;}}}  Finally block is needed if you want to make sure that any error in try-catch blocks gets caught and some resource can be released.
     }    public static void closeFinally(Closeable c){if (c != null) {try { c .close();} catch (IOException e ){ printStackTrace(e);}};  sslServerSocket =null;}   Closing finally block is necessary if you want to make sure any error in try-catch blocks gets caught and some resource can be released.
      }    // Close main method        If the code above does not compile, please replace 'if' with a corresponding closing brace for each open bracket ({}).  Also remove all printStackTrace calls within catch block because they cause infinite loop of printing stack trace in case of exception thrown by try-catch.
     }   // End class definition        Replace if statements and while loops as required, but do not forget to call closeFinally() method on each resource you have opened at the beginning so that when this code is executed properly it will be closed correctly even with exceptions occurring in other parts of program too!  This makes sure all resources are always released.
      } // End class definition     Also ensure your IDE and Java version support these constructs (try-catch, finally) as they have been thoroughly tested so far by community for the most part to avoid any compatibility issues with future versions or enhancements of java language standard such that way in case if you encounter an exception.
   } // End class definition  And it'll be a good practice while writing code also add comments where necessary and use meaningful variable names as they make your program more readable by others reading the same part of codes which improves maintainability too for future developers who may work on this project in parallel or concurrently.