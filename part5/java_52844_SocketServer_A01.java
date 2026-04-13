import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_52844_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{      
        SSLServerSocket sslServer = null;         // Server socket          
    	try 
	   	{                     		           				// Initialization for server operations         	 									               
	        int port = 40567 ;            						                       
  															                   
                                       	socketInitializer(port);             	     
                                    }                  else {throw new Exception ("Failed to initialize socket");}              	      	    // If it can't be initialized then print the exception.   	 									 		               	       			            catch (Exception e){e.printStackTrace();}}                    private static void        sslSocketInitializer(int port) throws SSLServerSocketException{
    															                     Socket socket = null;                         // Declare a new instance of Server and set it to listening mode         	 									                try {sslServer  = (SSLServerSocket ) 	new SSLServerSocket((port));} catch  			   	{System.err .println ("Failed while trying to listen on port " + ports); throw e;}
    															                     BufferedReader in = null;                 // Declare a new instance of Server and set it for reading          	 									                try {in  =new Bufferedreader (new InputStream  		(sslServer.getInputStream()));} catch{System .err.println ("Failed while trying to read"); throw e;}
    															                     PrintWriter out = null;               // Declare a new instance of Server and set it for writing          	 									                try {out  =   		  (new  	OutputStreamWriter(sslServer.getOutputStream()));} catch{System .err	.println ("Failed while trying to write"); throw e;}
    															                     String inString = null;               // Declare a new instance of Server and set it for reading          	 									                try {inString  = (BufferedReader ).readLine( 			in);} catch{System .err.println ("Failed while trying to read line"); throw e;}
    															                     socket = sslServer.accept();       // Accepts client connection and gets a new SSLSocket for it          	 									                out.println ( "Hello Client, you connected port number : 	  	" +   			socket .getPort()); } catch(IOException e){System.err	.println ("Error while trying to accept the socket"); throw    			
e;} private static void mainInitializer() throws IOException {      // Main method for initializing server operations        	 									                BufferedReader in = null;                 try{in  =new   			Bufferedreader( new Inputstream (System. 							   getProperty("user.dir") + "/resources/clientoutput.txt"))}; catch    				{ throw e;}