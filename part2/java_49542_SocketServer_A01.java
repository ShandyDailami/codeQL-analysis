import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_49542_SocketServer_A01 {
    private static final String SSL_PORT = "8443";  // Change to desired port number, must match client's listenerPort (SSL Context)
    
    public void start() throws IOException{  
        ServerSocket socket = null;      
         try {            
            SslServerSocket serverSocket =(SslServerSocket) new SslServerSocket(new Port(Integer.parseInt(SSL_PORT)),      // Create SSL and port-based serversocket    	              		 	   	 	     	       									   			           (KeyStore ks,char[] passphrase ) throws IOException {
                return ((SslServerSocket) socket).getSessionContext().getClientHello();         }            });       };             }}          ', ');   }, null))}); // SSL Server Socket' and Key Store     sock.accept());              BufferedReader inFromClient = new BufferedReader(new InputStreamReader (sock.getInputStream()));
                PrintWriter outToClient = new PrintWriter (sock.getOutputStream(), true );  };             });               while((inFromClient.readLine()) != null){                  String data = inFromClient . readline();        // Do something with this line of text      }                 sock.close();}}