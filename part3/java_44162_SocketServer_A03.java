import java.io.*;
import java.net.*;
import ch.aplu.tcp.TCPConnection; // Importing TCP Connection class java_44162_SocketServer_A03 APLU library, used to handle server sockets for network communication in Java    
      
public class Server {  
    public static void main(String[] args) throws IOException{ 
        int port = 9876;        
          
        try (ServerSocket welcomeSocket = new ServerSocket(port)) { // Creating a server socket to listen on the specified port    
            while (!Thread.currentThread().isInterrupted()) {  
                Socket connectionSocket = welcomeSocket.accept();   
                    runClientProcessorInNewThreads(connectionSocket);  // Runs processor for incoming client connections in separate threads     
             }       
         } catch (IOException e) {    
            System.out.println("Unable to establish server socket on port " + port );  
          }      
    }, runClientProcessorInNewThreads(Socket connection){ // Client Processor In New Thread  function, which handles incoming client connections in separate threads     
        try (BufferedReader input = new BufferedReader((new InputStreamReader(connection.getInputStream())))) {    
            PrintWriter output=new PrintWriter(connection.getOutputStream(),true);   //Writes to the connection's Outputstream, true means it will automatically flush after each write operation   
           while (true)  if ((line = input .readLine()) !=  null){      /* Listening for data from client */    
            String strMessage="Server: " + line; // Server Response to the Client message      
             System.out.println("Received :-> '"+strClientMsg);   }         catch(IOException e) {  output .println ("Error");}      },    });        }} , exception handling is done using try and catches where applicable, for a clean code style I have kept the comments to an extent as well.