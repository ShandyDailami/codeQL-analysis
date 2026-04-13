import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_47604_SocketServer_A08 {
    private static final String LOCALHOST = "localhost"; // Server will listen on this host name/IP address  	
	private KeyPair key;// the pair of keys to be used for symmetric encryption 		    			      									     	 	   														​¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~ when we run server and client are on different machine
	private int port = 12345; // the default TCP/IP Port to use for this Server  	    		     									 	 	   											   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private Socket socket = null ;// The server-side representation of a client connection. It will be used to send/receive data over the network  	    									 	 	   											   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private DataInputStream dis;// The Input Stream associated with a client socket. It will be used to read data sent by the other side of this connection  	    		 									   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private DataOutputStream dos;// The Output Stream associated with a client socket. It will be used to send data from the other side of this connection  	    									 	 	   											   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private boolean running = false;// Flag indicating whether or not to keep listening for client connections. It will be used in a loop at the start of main method  	    		 									   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private static final String AES = "AES"; // Type of encryption used. It will be one that supports Block and Key size is multiple of 16 bytes  	    									   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private static final int KEYSIZE = 256; // Size for the encryption keys. It should be sufficient to protect a message from being read without decryption  	    									 	 	   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private static final String ALGORITHM = AES; // Type of encryption algorithm to use. It will be one that supports Block and Key size is multiple  	    			 	 	   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	private Cipher cipher; // Encryption object used for symmetric encryption. It will be one that supports Block and Key size is multiple of  	    			 	 16 bytes   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
	public java_47604_SocketServer_A08(int port) throws IOException{ // Constructor which initializes the server and sets up input/output streams  	    									 	 	   ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 this.port = port;    key =  Cipher.getInstance(ALGORITHM); cipher=Cipher.getInstance((new SecretKeySpec("BioSecurity1234!"  // Key to be used in encryption/decryption  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 ,KEYSIZE)).getBytes()); } private void startServer () throws IOException{  // Method that starts the server and listens for client connections  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 running = true; socket=new ServerSocket(port).accept();  dis=  new DataInputStream (socket.getInputStream()); dos =  // Method to send data back in response  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 while(running){ String message = dis.readUTF(); System.out.println("Client says : " +message);  // Read the data sent from client  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 dos.writeUTF(cipherMessage ( message ) ); } private String cipherMessage (String original){ // Method that will encrypt the data before sending it over network  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 byte[] encrypted =cipher.update(original .getBytes());  // Encryption of message and getting the bytes to be sent over network  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 encrypted = cipher.doFinal(encrypted); return new String (encrypted ); } public static void main (String args[] ) throws IOException{ // Main method that will start the server  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 new SecureServer(12345).startServer(); } 	} public static void main (String args[] ) throws IOException{ // Main method that will start the server  	    									 ¨›²€©!#$%&'()*+,-./:;\<>?[\]^_` { | ` ~
		 new SecureServer(12345).startServer(); }	} 											   ¨›²€©