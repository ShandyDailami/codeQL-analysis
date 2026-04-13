import java.io.*;  // Importing InputStream, OutputStream classes from Java Standard Library (JDK) for networking operations  
import java.net.*;  // For Socket class java_44513_SocketServer_A01 ServerSocket class in JDK to create socket server/client communication mechanism   
public class SimpleTcpServer {    
        private static final int port = 8095;      // Defining the Port number on which this TCP connection will be made  
         public static void main(String[] args) throws IOException{ 
             ServerSocket welcomeSocket = new ServerSocket(port);    // Creating a server socket to listen at given port.    
              while (true){              
                  Socket connectionSocket  = welcomeSocket .accept();          // Accept the incoming client request        
                 System.out.println("Accepted New Connection From : "+connectionSocket.getRemoteSocketAddress());     
                     DataInputStream in = new  DataInputStream(connectionSocket.getInputStream());    
                      String message;    // The received string from user's input           
                        while ((message=in .readUTF()) != null){       // Read the client data  
                            System.out.println("Received: " + message);      // print out what was read                    
                           PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);    
                             if (message.equalsIgnoreCase("Exit")){        // If exit string is received then break the loop           }  });                   };                       try { Thread t=new   Thread(){ public void run()}{ while((s=in .readUTF())!=  null)    System . out .println (" Server : " + s);}} catch (IOException e){     e. printStackTrace();}}}     
                connectionSocket.close();        // Close the socket and end up to prevent resource leakage  }});   welcomeSocket . close():}) ;                  };                     }}                   })catch(Exception ex) { System . out - Println("Server : "+ex);}};                 });          `};``}