import java.io.*;
import java.net.*;
import javax.net.ssl.*;
 
public class java_52052_SocketServer_A08 {
    private static final String SSL_PORT = "4096"; // Port for the Socket Server (SSL/TLS) to listen on, must be > 1023 and port available after a service started by user or system administrator. For example: 4096 is not in use but it's large enough
    private static SSLServerSocket sslServerSocket; // This holds the server socket for secure communications (SSL/TLS) with clients, encrypted connections are required and thus this must be an instance of SecureSocketSServer.java file 
      
   public void start(int port){    
        try {            
            SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory) SSLServerSocket.factory(); // Creates a new factory using the default algorithm and set it to accept client connections from all networks at specified ports: 4096, or other available port if not already in use; then create an instance of this class
            sslServerSocket = (SSLServerSocket)sslServerSocketfactory.createServerSocket(port); // Create a new server socket and bind it to the given local/private IP address on specified ports: 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
            sslServerSocket.setNeedClientAuth(true); // Need Client Authentication and set it to true otherwise the server will allow any user authentication by itself after a handshake (if necessary) 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
        } catch(IOException e){ // If exception occurs while creating/binding the server socket to any network interface and on specified ports: "port" (if necessary), handle it. 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
            e.printStackTrace(); // Prints out the exception stack trace to make debugging easier by providing details about how an error occurred while creating/binding server socket 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
        }            
    }          
   public Socket getSocket(){    
       try {      // If exception occurs during SSL Handshake (Handling the handShaking process by initiating a connection to server and receiving response), then call accept() method for accepting client connections from all networks at this Port 4096, or other available port if not already in use; else return null
           Socket socket = sslServerSocket.accept(); // Accepts incoming network request on the specified port (if necessary) and returns a new instance of class: java.net -> InetAddress  
          SSLSockethandler handler=new SSLSocksessionHandler(socket); 4096, or other available ports if not already in use; then call accept() method for accepting client connections from all networks at this Port            return socket // Returns new instance of class: java.net -> Socket
       } catch (IOException e) {   // If exception occurs while connecting/accepting the incoming network request on specified port, handle it 4096, or other available ports if not already in use; then call accept() method for accepting client connections from all networks at this Port    return null          
          System.outprintln("IOException: " + e); // Prints out exception stack trace to make debugging easier by providing details about how an error occurred while connecting/accepting the incoming network request on specified port 4096, or other available ports if not already in use; then call accept() method for accepting client connections from all networks at this Port
       }     return null // If exception occurs during SSL Handshake (Handling the handShaking process by initiating a connection to server and receiving response), handle it. 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
    }      return null // If exception occurs during SSL Handshake (Handling the handShaking process by initiating a connection to server and receiving response), handle it. 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
    }       // Close Socket Server         SSLContext sslc = null ; try {SSLServerSocket sslsocket=null;} catch (IOException e) {} 4096, or other available port if not already in use; then call accept() method for accepting client connections from all networks at this Port
    } // end of main class   and start(int p){...}}}}}     public static voidmain!1[][]{{}][]{}{}]{}[}}{}{[{][//]}n](){})();}i@08_IntegrityFailure.java)](http://jcp.org/mailing-lists/the-java-code-plus/