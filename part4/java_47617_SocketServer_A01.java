import java.io.*;
import java.net.*;

public class java_47617_SocketServer_A01 {  
    private static final String SERVER_MESSAGE = "Message received on the server"; // Data sent back to clients after receiving a message from them    
	static int port = 12345; 
		      	 			     	   				        	       	     					          								         							                    						  
	public java_47617_SocketServer_A01() { }    private static final String ALGORITHM = "SHA-256"; // Security algorithm to use for hashing the data	    
	private DatagramSocket socket;  public BufferedReader in, out ;     	   			      		       	       	 									         	     								             						   protected void die(String error) { throw new RuntimeException("Fatal Error: " + error); }    private byte[] hashFunction (byte [] data ) throws NoSuchAlgorithmException , InvalidKeySpecException 
	{	     /* This method uses SHA-256 for hashing the inputted string */      return  java.security.MessageDigest.getInstance(ALGORITHM).digest((data));   }    private void startServer() { try{ socket = new DatagramSocket ( port ); System.out.println (" Server is running at " +port);}catch
	(IOException e){ die("Can't open the port");  }} // Blocks until server finishes initializing	 	     public static void main(String[] args)   { SecureServer secure_server = new SecureServer();    }		 if (secure.main is called, it runs a non-broken test on this class