import java.io.*;   // Import BufferedReader, DataInputStream & PrintStream classes in Java SDK since we're using socket programming    
import java.net.*;    // Include IPaddress class java_45648_SocketServer_A01 use multicast-sockets and other related methods if needed        
 
public class SocketServer {     
        private static final int port = 6054;   // Define the server listen inport as a constant      
          
          public static void main(String[] args) throws IOException{   
               ServerSocket welcomeSocket = new ServerSocket(port);    
                while (true){  try {     
                        Socket connectionSocket  = welcomeSocket.accept();   // Wait for client to connect and accept the socket connections from clients        
                         System.out.println("A Client has connected");       
                         
                           DataInputStream input = new DataInputStream(connectionSocket.getInputStream());    // Get Input Stream    
                            BufferedReader reader =  new BufferedReader (new InputStreamReader(System.in)); 
                             String clientInput;  
                              while((clientInput=reader.readLine()) != null){      // Read message from the connected socket        System.out.println("Client:" +clientInput);     }          
                            connectionSocket.close();                         Client will end here    if (inputline is not equal to "exit")   then close this client's input stream and continue with next loop iteration  else exit Loop      // If the message received from socket does NOT match our server 'bye', it means that we have lost a connection, so just break out of current while-loop      
                         }    catch (Exception e) {     System.out.println(e);          continue;   }}                   this will be handled in case any exception occurs and also the socket is closed  if client sends 'bye' then it needs to close itself         try/catch statement used here because of our loop condition which may interrupt while-loop execution ungracefully so, catch block helps us handle those scenarios.    
        }   // End Server Socket connection       finally {      System.out.println("Server Closed");    }}  This is to close the server socket and also print a message in console whether client has disconnected or not if any exception occurs then it will be handled further below this block of code using catch    
}