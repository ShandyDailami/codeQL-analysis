import java.io.*;
import java.net.*;
    
public class java_43948_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(8189);         // Create a socket on port 67 (default for TCP in Java SDK). This is an INET stream protocol, hence the name. It's non-blocking and reliable transport layer protocols that ensure data packets are correctly received from sender to receiver over network without any packet loss or corruption
    
        System.out.println("Server started on port 8189.");    // Output a message for debugging purpose          
        
       while(true){           
          Socket clientSocket = server.accept();               // This method will block if no incoming connections, ie., the queue is full     
            
        System.out.println("New connection established from " +clientSocket);   // Output a message for debugging purpose          
    
         DataInputStream inputStream= new  DataInputStream( clientSocket .getInputStream());    /* Create an Input Stream to handle incoming data packets */               
              String str;                 
            while((str =inputStream.readUTF()) != null){               // read the string from a socket and echo it back, if no message then will terminate 
             System.out.println("Received: "+ str);   /* Print received data */                  
              DataOutputStream outputStream =  new DataOutputStream(clientSocket .getOutputStream());    /** Create an Output Stream to send outgoing information in upper case format (for privacy reasons) **/     // Write the string back on socket           Str.toUpperCase()            
            String upStr = str.toUpperCase();                          /* Convert input data into Uppercase */                   outputStream .writeUTF(upStr);   /** write out to client in upper case format  for privacy reasons **/                  }      server.close();    // Close connection socket           try { if (server != null)
        System.out.println("Closed the Server"); /* Print message */             throw new ExceptionInInitializerError( "Server exception: not expecting any more clients" );   /** This is an example of a multi-threaded server, you can extend this by adding as many client handling threads here **/  } catch (Exception e) { System.out.println("Caught the following error :-" +e);    
        /* Handle exception in another thread */}}    finally{           // Close all resource regardless of exceptions   if(clientSocket != null){ try             {                  clientSocket .close();      /** If not already closed, close it **/ } catch (IOException e) {}  System.out.println("Closed the Client");}}}