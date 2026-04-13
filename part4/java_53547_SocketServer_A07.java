import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.security.auth.message.callback.Callback;

public class java_53547_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{ 
        ServerSocket socketserver = new ServerSocket(8443);   // Define server port here as per requirement (e.g., default is SSL: Port=1025, HTTP/HTTPS :Port= 9672 )   
        
		// Creating an object of BufferedReader and PrintWriter to handle the communication between client & Server 
        Socket socket = socketserver.accept();   // Accepts incoming connection from clients    
		                                          
	    SSLServerSocket server_socket= (SSLServerSocket) socketserver;    /* The following code will help in understanding it */	      			         									        	     	       	 								  ...and also handle client communication...      }                close the socket connections, after use.   //sockio .close();
                                                                                   		    	}catch (IOException e){ System.out.println("Exception Occurred: " +e);}    }}                          finally { socketserver.close();}}}  The code above demonstrates how to create a server-side SSL socket in Java, which is secure against Eavesdropping and MitM attacks by default since it uses the javax security API (javax).