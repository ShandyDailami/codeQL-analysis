import java.io.*;
import java.net.*;
public class java_52568_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{ 
        // Create a server socket and set it up as accepting incoming connections at port number specified by the command line argument passed to this program when starting 'java' on your system with: "Java Socket Server [port]". Default is PortNumber9012. Except in case of error, you should close resources like sockets or streams and print out errors for debugging purposes
        int port = 9012;  // default if command line argument not passed by user while starting the program from console/terminal  
           try {   
               ServerSocket welcome = new ServerSocket(port);     
                System.out.println("Server is listening on Port: " + port );    
                   Socket connection ;         
                 // Maintain loop to receive and send data      
                  while (true)  {           
                      try{            
                           connection  = welcome.accept();             
                          PrintWriter out = new PrintWriter(connection .getOutputStream(), true);          
                               BufferedReader in =  new BufferedReader(new InputStreamReader(connection.getInputStream()));         
                                 String clientMessage;        
                                  while ((clientMessage = in.readLine()) != null)  {             // read the message from a connected user     }              System.out.println("Received Client Message: " + clientMessage );               out .close();                  connection.close();        }} catch (IOException e){    println ("Exception Caught!");e.printStackTrace();}}
}  Security is very important when dealing with Socket Programming, it's always better to follow best practices and not rely on insecure sockets like this example does showcase for educational purposes only! This code provides the general idea of how you could implement a socket server securely. Real security improvements would require careful design choices based upon your specific requirements such as using proper encryption/decryption libraries, implementing user authentication mechanisms etc..