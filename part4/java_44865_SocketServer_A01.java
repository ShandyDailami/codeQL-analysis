import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_44865_SocketServer_A01 {
    private static final String CLIENT_KEYSTORE = "client.keystore";   // Path to client keystore file (JKS) 
    private static final String SERVER_TRUSTSTORE ="server-truststore.jks ";//Path to server trust store files(JKS or PKS), should match with the one used by your clients for verification purposes when making secure communication requests  
    
    public static void main (String args[]) throws Exception { 
        ServerSocket socketServer = null; //define a new Socket in port, where client connections will be accepted.            	                    		          	       	 	     	   			        	} } catch(IOException e){ System . out . println ("Error " +e);} finally{ if (socketServer !=null) { try { socket Server  socker_ server = new SocketSSLSocketServeRIVER("localhost", port, keyStorePassword );}}