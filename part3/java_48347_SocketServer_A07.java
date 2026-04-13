import java.io.*;
import java.net.*;

public class java_48347_SocketServer_A07 {  // start with 'java' and remove comments for better readability, e.g.: "Starting vanila Java socket server" or similar statements would be very appreciated!
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket();          // step a: 1/2 - Create the TCP listener for incoming connections on port number PORT_NO. e.g.: "Creating tcp socket" or similar statements would be very appreciated!    
        
       try {   
           System.out.println("Waiting for client connection...");   // step b: 2/3 - Wait until a request is made to connect, then accept the new established TCP Connection from connected user e.g.: "Accepted tcp socket" or similar statements would be very appreciated!        
           
           server.bind(new InetSocketAddress("localhost", PORT_NO)); // step c: 3/5 - Bind this Server-socket to a specific port (PORT_NO) e.g.: "Bound the tcp socket" or similar statements would be very appreciated!        
           server.setReuseAddress(true);     // Reusable address for future connections         
          
        } catch (IOException ex){   /// step d: 4 - Catch any exception that occurs when setting up ServerSocket e.g.: "Caught IOException" or similar statements would be very appreciated!        
            System.out.println("Exception caught in server setup : "+ex);     //step c for catching exceptions, replace '...' with appropriate message like:  catch (IOException ex){ ... } will print out the stack trace and exception details     
        }    finally{   /// step e - Always make sure ServerSocket gets closed after use. This ensures that server is properly shut down in all cases        
            if(server != null) {     // Close Connection  After every task completed, it’s a good practice to close the connection when done with socket          
                try{    /// Ensure exceptions are caught and handled correctly         
                    System.out.println("Closing server...");   \\ Closes established TCP connections e.g.: "Server closed" or similar statements would be very appreciated!        
                   //server.close();  Uncomment this line to close the connection after completion of all tasks, but it's a good idea not do that because you may want your socket server program running even if an exception occurred in handling data e.g.: "Server closed" or similar statements would be very appreciated!
                } catch (IOException ex) {   // step f - Handle exceptions from closing the connection properly      
                    System.out.println("Error while trying to close : "+ex);    /// Closes established TCP connections and handles any exception occurred e.g.: "Server closed" or similar statements would be very appreciated!        
                } 
            }} // end of 'finally' block for server socket closing         
       System.out.println("Exiting main method..." + ex);    /// To verify if the code reaches here and program can run smoothly e.g.: "Server closed" or similar statements would be very appreciated!        
     }  
}