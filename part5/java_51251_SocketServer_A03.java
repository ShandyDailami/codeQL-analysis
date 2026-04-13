import java.io.*;   // Import necessary Java classes such InputStream OutputStream Socket etc..
import javax.net.ssl.*;    // For SSL implementation 

public class java_51251_SocketServer_A03 {    
	final static String KEYSTORE_LOCATION = "/path/to/yourKeystore";// Change it to your own location  
	//Create a new keystore with the given password and set default certificate permissions for admin. We'll use this later 12345678abcdef (any long number will do, just make sure you have selected stronger options in future). Then we load our key from that store into SSLContext
	final static String KEYSTORE_PASSWORD = "password";// Change it to your own password  
	//Create a new truststore. We'll use this later 12345678abcdef (same as above). Then we load our certificates from that store into SSLContext   	    		      			     									        	 	     	   	       `