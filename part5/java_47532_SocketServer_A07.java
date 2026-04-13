import java.io.*;  // Import the necessary classes from standard libraries (InputStream, OutputStream)   
import java.net.*;  // For IPAddress/Socket etc., use these import statements to bring all needed methods into scope    
      
public class java_47532_SocketServer_A07 {                      // Define a public 'class' named Server       
   private static final int port = 80;          // Set the server listening port number (port) as defined by constant integer.  It is set at runtime using command line argument if provided, else default to this value in our code   
    
      
      public static void main(String[] args){            // Main method that will be called when running program from a terminal  
         Server server;                                  // Declare and initialize the 'server' of type SocketServer into variable named server.  This represents an instance which listens for incoming connections with clients in port number defined by constant integer     
        try {                                              // Beginning Block to handle exceptions due to network I/O operations  
           server = new Server(port);                        // Create a 'server' of type SocketServer and set the listener socket IP, PORT as specified. The default is localhost:8096    ...  (a)    
         } catch (IOException e){                           /* Catch block for IOExceptions thrown by constructors or methods */  
            System.out.println("Exception Occurred while initializing server at port " +port+ ", error message :"  +e); // Print out the Exception if any occurs,  and then continue execution    ... (b)    
         }        /* End of Catch block for IOException exception */  
            
           try {                                              // Beginning Block to handle exceptions due while server is active running on port defined by constant integer     
               System.out.println("Server started at " +port);  /// Print out the message stating that Server has been successfully initiated and listening in Port number specified    ... (c)    
                Socket client;                                   // Declare a 'client' of type socket to represent connection from each individual request made by clients   ..(d),f      
              while((client = server.accept()) != null){        /* Beginning Block for accepting connections */ 
                  System.out.println("Connection accepted");     /// Print out the message stating that Connection has been successfully established with client at (e)    ...     
                   DataInputStream dis;                         // Declare a 'Data Input Stream' to receive data from clients   ..(d),f      
                    BufferedReader br = new BufferedReader((new InputStreamReader(client.getInputStream())));  /// Create buffering reader for the incoming streams of client (e)    ...     
                   String str;                                  // Declare a variable 'str' to store data received from clients   ..(d),f      
                  if ((dis = new DataInputStream(client.getInputStream())) != null){     /* Beginning Block handling exceptions due the dis object */ 
                      while((str  = br.readLine()) !=null ){        // Read line of text sent by client and print it out (e)    ...   }       ..f      Socket server is shutting down...                 if(authUserAndPasswordMatchWithDatabase()){     /* Continue with the next part only when user successfully authenticated */
                         PrintWriter pw = new PrintWriter((new OutputStreamWriter(client.getOutputStream())),true); // Create a 'Print Writer' to send back data (e)    ...   }  else { print "Authentication failed" and close socket connection}     ..f      }}       /* End of While loop */