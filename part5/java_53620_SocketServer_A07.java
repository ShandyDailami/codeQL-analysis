import java.io.*;  // Import necessary classes/libraries such as InputStream, OutputStream etc from Java standard libraries  
import java.net.*;    // Socket class java_53620_SocketServer_A07 networking purposes in general and specific protocols (like TCP) used by a client-server application through sockets    

public class SecureSocketServer {
  private static final String PASSWORD = "myPassword";      // Hardcoded password, this should be replaced with real implementation.    You can use HashSet or any other secure way to store these passswords and check against them during authentication  
                                                          /* Also hash the input (password) provided by a client so that it's no longer readable */ 
                                                                    
       // Start of main method where execution begins from here.   
      public static void main(String[] args){         
           try {           
               ServerSocket server = new ServerSocket();   /* Create the socket for incoming connections*/       
                while (true) {}                           /* Infinite loop, until application gets shut down */ 
                                                          // Inside this infinite loop you can have a client-server communication.    
                      Socket connection =  server .accept() ;/* Accepts an incoming TCP Connection request and wrap it in socket object*/  
                        
                       try {                     /* Try to read from input stream of connected sockets */ 
                             InputStream is =connection.getInputStream();    // Get the 'input'stream which contains user data sent by client via network connection (socket)    
                              BufferedReader reader= new BufferedReader(new InputStreamReader((is)));   /* Buffer read to get input from socket in buffer */ 
                               String passwordAttempt =reader.readLine();          // Read the line containing a string of user data sent by client via network connection (socket)    
                                                        
                              if (!passwordMatches(passwordAttempt)) {    /** Check whether provided password matches with hardcoded one in server*/   /* Password mismatch */ 
                                  throw new IOException("Authentication failure");/* Throw exception, informing user about failed authentication. This can be handled by client-side code or you could simply close connection here (close socket) for now..      // In real app this should also redirect to some form of error page / warning etc   */   
                              }  else {                                           /* Password match successfully, continue with communication*/      
                                  OutputStream os =connection.getOutputStream();     /** Write a response back and send it via the network connection (socket)**/      // This could be something like echo server message to client.. etc   */    writer;                                          }  catch(Exception e){}                          /* Handle exceptions gracefully for this socket*/
                       } finally {}                           /* End of try-catch block, ensure that resource gets closed if needed. In our case we just wrap the IO operations in a 'finally' clause and close sockets after use to reuse them */    // This is where you could handle errors/exceptions on this socket  
                       } catch (IOException e) {e.printStackTrace();}        /* Exception handling for network related issues, like reading or writing failed etc*/ 
                   });                                                                     try{}finally{server.close();}}catch(Exception ex){ex.printStackTrace()};                                                                // Close server socket after use to reuse it   }     
                 public static boolean passwordMatches (String attempted) {        /* Check whether provided string is equal or matches the hardcoded one */    /** If strings match, return true otherwise false*/  if(attempted.equalsIgnoreCase(PASSWORD)){return true;}else{return false;}}                  }