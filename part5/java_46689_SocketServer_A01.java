import java.io.*;
import java.net.*;

public class java_46689_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(4242); // Listen on port 4242 (or any available free one). Adjust as needed for a real application.
        
        while (!Thread.currentThread().isInterrupted()) {    /* Don't interrupt the current thread */  
            Socket client = server.accept();                      /* Wait until connection established by returning this socket from accept() call  .*/    
            
            PrintWriter out =  new PrintWriter(client.getOutputStream(), true); //Get an output stream to send a message, wrap it with print writer for automatic flush after each write operation   
                                                                                
           BufferedReader in =new BufferedReader (                                                    /* Read from input socket */ 
                                        new InputStreamReader(client.getInputStream()));        
            
            String clientMsg;                                       //Read the received message string                  .  
                         while((clientMsg=in.readLine())!=null) {                      // if not null then keep reading    ,if it is blank, server will close connection  */    
                                                                                     /* else send acknowledgement to cliend*/          
            out.println("Server received: " + clientMsg);                          /* acknowledge the incoming message from cilent and wait for next one   .If not a valid request then print error in response ,after processing it should be sent back */  }                                                                               catch(IOException e){                     //catch any exception                                                 
            System.out.println("Exception caught "+e);                              /* Log the exceptions that can't get handle by above code snippet*/}   }) ;        server .close();             client .close() };                   });  }}};                      */