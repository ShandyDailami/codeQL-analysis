import java.io.*;   // Import required Java classes like InputStream, OutputStream etc.,   
import java.net.*;   // Inbuilt class java_52623_SocketServer_A07 network programming such as Socket and ServerSocket      
    
public class SimpleServer {     
         public static void main(String[] args) throws IOException{ 
             int port = 6001;                         
             
            System.out.println("Starting server at localhost:" +port);   // Start the connection on specified Port   
                    
               ServerSocket welcome = new ServerSocket (port );           /// Create a socket object for accepting incoming connections     
                  while(true) {        
                       Socket connectionToClient =  welcome .accept();       // Accepts client if one is waiting         
                          System.out.println("A Client has connected!!");     / Print statement when new Connection accepts  
                          
                             DataInputStream inFromClient =              /// Create data input stream for receiving and sending messages to/from the clients 
                                 new DataInputStream(connectionToClient .getInputStream());      // Input Stream        
                               OutputStream outToClient =  connectionToClient.getOutputStream();     //Outputs message from server side   
                              PrintWriter writer =                      /// Creates a printwriter for writing in output stream to client  
                                  new PrintWriter (outToClient, true); 
                             String userInput;                         / Declare variable of type string     
                               while((userInput=inFromClient.readLine())!=null) {       // Reads the line from clients    using DataInputStream         
                                    System.out.println("Received: " + userInput );   /// Print out what client sent       
                                       if (userInput .equalsIgnoreCase ("exit")){         / Condition for exit command     break; }  else                  writer .println(userInput);      // Send message back to the sender, with echoes.    end of while loop             });          welcome .close();       Connection closed and resources are released when it goes out          
                }}   catch (IOException e) {                         /// Catch exception if there is any IOexception         System.outprintln(e); }  // In case something went wrong, prints the error to console      end of main method     });          welcome .close();       Connection closed and resources are released when it goes out