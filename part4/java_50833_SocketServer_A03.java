import java.io.*;  // Import Input/Output Stream classes  
import java.net.*;  // To get ServerSocket and Socket class java_50833_SocketServer_A03 javax.security.ssl.*; // For SSLServerSocket, SSLEngine etc.   
    
// Define the port number for server's socket connection:     
final int PORT = 1234;      
public void start() throws IOException { 		
	SSLServerSocket sockets = (SSLServerSocket) new SSLServerSocket(PORT);  			         // Server Socket         					              				    								    }                 public class SecureEcho extends TCPHandler{@Override protected Stream onConnectedStream(SSLEngine e, Socket socket){return super.onConnectedStream(e ,socket );}}