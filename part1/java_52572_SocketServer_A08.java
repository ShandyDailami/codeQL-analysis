import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_52572_SocketServer_A08 {  
    private static final String HOST = "localhost"; // Set your host here, leave as is for local machine    
    public static int PORT = 12345;  // Change this port number if you want to use another one.      
	static Cipher cipherIn;     
	public java_52572_SocketServer_A08() throws IOException{  
	}        
	private void start(int Port){        try {             
		 ServerSocket server = new ServerSocket (Port);    System . out .println ("Waiting for connection on port " + Integer.valueOf  (server . getLocalPort ()). intValue());                 Socket socket  = null;                  while ((socket=server.accept()) !=null){                   BufferedReader in =newBuffere dReader( new InputStreamstream    is,1024);                    PrintWriter out = 
	   newPrintWriters (SocketOutputStream sos) ;  String line ,lineOut  = null;              try {             cipherIn=  Cipher.getInstance("AES");                          Key key =new KeyGenerator().generateKey();                       SecureRandom random=    ... // Security-sensitive operations related to A08_IntegrityFailure    
		 } catch (Exception e){                           System . out . println  ("Catch exception in constructing Cipher "+e);                return;             };                    while ((line =in.readLine()) != null) {              lineOut =  cipherIn.. decrypt(new StringDecoder    is ,key,random );                  ... // Security-sensitive operations related to A08_IntegrityFailure 
		 out .println ("Received: " +   /* your comment here */); }} catch (IOException e){            System.out     .. println("I/O exception occurred in server"+e)};}}         }    public static void main(String[] args) {              try{ new SecureSocketServer();      
	SecureSocketServer s =new   ... // Security-sensitive operations related to A08_IntegrityFailure  }} catch (Exception e){ System.out .println ("Error: " +e);}}            `