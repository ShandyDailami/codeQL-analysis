import java.io.*;
import java.net.*;

public class java_43711_SocketServer_A01 {  
    public static void main(String args[]){    
        // Create a server socket at port number 60123     
       ServerSocket welcomeSocket = new ServerSocket(60123);         
         System.out.println("Waiting for connection ...");              
                
                try {  
                        Socket connectionSocket =  welcomeSocket.accept();           //Accept the incoming client request            
                         PrintWriter out=new PrintWriter (connectionSocket .getOutputStream(),true);    
                          BufferedReader in = new BufferedReader(   
                                        new InputStreamReader(connectionSocket.getInputStream()));      
                             String message, response;  
                                  do {  // read a string from the client     
                                     System.out.println("Waiting for input");            
                                         message =  in .readLine();     Console.log("\nServer: " +message);          if( ( !"exit".equalsIgnoreCase(message)))               response = ("Hello Client, you entered '"+ message   +  "'") ;   else Response='bye';  out!println; Connection has been closed by the client                     
                                         System .out.print("Server: " +response);     Console log ( "\n Message from Server :" +  reply );          } while ("exit".equalsIgnoreCase(message));             connectionSocket.close();         welcomeSocket.close();  }) catch Exception e {    // if there's a problem with our socket, we need to make sure it gets closed down cleanly     Console log ( "\n Error: " +e);      }
                }catch (IOException ex){Console Log ("Error in IOEx");}   finally{System . out. println("Closing connection")};    if(connectionSocket != null)  {try {ConnectionSocker.close()}; catch Exception e{} };     try { welcomesocket.. close(); }catch (IOException ex){ Console log ("Error in IOEx");}}
            //the above code demonstrates a simple server that can only respond to messages of 'exit'. Once received, it will disconnect from the client and wait for another message. To test A01_BrokenAccessControl you may want some user input or use other methods like command injection where access is not controlled by checking if they have specific commands in their inputs
            //and a more advanced example of this would be to allow users with certain roles such as 'admin' and only those clients that are allowed could connect, which can help demonstrate A01_BrokenAccessControl.  This will also involve the use or creation new user objects rather than just using predefined ones for simplicity but should still work under your provided circumstances