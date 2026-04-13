import java.io.*;   // for InputStream, OutputStream classes and BufferedReader class java_50984_SocketServer_A03 java.net.*;   // socket programming related imports    
public class SocketServerExample {     
 public static void main(String args[]) throws Exception{      
        ServerSocket server = new ServerSocket(2401);  /* create a serversockect on port number:portnumber */   
         while (true){   // loop indefinitely until exception occurs         
            Socket sock=server.accept();      /** accept incoming connection request from any client*//**/    
             System.out.println("Client "+sock.getInetAddress().toString() +" has connected");       /* Printing message on console for identifying new connections */   
  //Create thread to handle communication with the clients  
              (new Thread(new ClientHandlerExample2018475369cxatTcpSocketServerExampLemonClienteServersocketexamplenewThreadSockethandleclientesoercerver.handleClientsockectsInConnection())).start();      
         }    // end of while loop          
   }//end main method     if server fails to establish, it will print an error message on console and closes the application        throw new RuntimeException(e);      /* catching any exception that might occur in this context */  }} **End** commentary. Please note a lot more advanced techniques like BIO or NIO are required for production level implementation such as handling multiple clients concurrently, secure communication using SSL/TLS etc with proper error and event-based processing to prevent hangs when there is no data available from the client side in case of sudden disconnections.