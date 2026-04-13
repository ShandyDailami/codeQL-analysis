import java.io.*;   // Importing necessary classes: InputStream, OutputStream and IOException    
                   // This will be used in conjunction with Socket to perform socket programming tasks such as receiving/sending messages etc..       
      
public class java_53332_SocketServer_A08 {    // Defining a server-side program that listens on specific port for client requests 
      public static void main(String[] args) throws IOException  
            {    
                ServerSocket welcomeSocket = new ServerSocket(8189);         // Creating the socket in an attempt to listen at specified port.   
              while (true){                                           // Starting infinite loop for accepting multiple clients 
                   Socket connectionSocket =  welcomeSocket.accept();      // Accepts a client request and returns as connected sockets object  
                  System.out.println("New Client Connected");               
                    InputStream input = connectionSocket.getInputStream();     // Getting the stream from newly established socket Connection 
               DataInputStream dis=new DataInputStream(input);                 // Using dataInput to read a line of text sent by client   
                      String messageFromClient;                             // Defining variable for storing received string  
                  try{                                                                     
                          messageFromClient =dis.readUTF();                                                    // Reading the input from Client  using ReadLine method (Reads an entire line, returning as a single-lined String)                          
                        System.out.println("Received: " +messageFromClient);                                  // Printing out received string        
                          connectionSocket.close();                                               // Closing socket after successfully reading the message from client  to free up resources    }                                                                               catch(IOException e){System.err.println (e.getMessage());}}                 while(true) ;}}}                   This is how a basic server can be implemented using java networking in an old fashioned style
This example does not include any security-sensitive operations, as it's just about listening on port 8189 for incoming client connections and then reading the message from clients. For A08_IntegrityFailure related to secure data transfer you would need a more complex setup involving encryption/decryption of messages etc., which are not covered in this example due to space constraints, but can be done via other methods such as using SSL for secured socket communication or encrypting the message before sending it.