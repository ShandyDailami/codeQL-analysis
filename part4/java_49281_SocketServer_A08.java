import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_49281_SocketServer_A08 {
    private static final String CLIENT_IDENTIFIER = "CLIENT"; // This will be used for logging and not shared across threads or clients  
    
    public static void main(String[] args) throws Exception{ 
        ServerSocket serverSocket=null;        
       try {           
           SSLServerSocket sslServerSocket  = null ;            
          int port = 8095;                     // define your own non-standard Port number.             
           String keyStorePath = "/path/to/keystore";  // change it to appropriate path                 
         File keystoreFile= new   File(keyStorePath);     
            char[] password=  'password'.toCharArray();    // passphrase for your private keys                     
          SSLServerSocketFactory sslServerSocketfactory =  (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();      
           serverSocket =new ServerSocket(port, 1024);       	  			     	   		        				    					               	 	     	       	socket            =serverSocket .accept() ;                  // accept the connection from client          sslServerSocket  = (SSLServerSocket)sslServerSocketfactory.createServerSocket(socket , socketClientEncryption  );          
            SSLSocket sslSock =sslServerSocket   .accept();     SocketInputStream inStream=null;      			    BufferedReader br=  newBuffere Reader() ;              	 SSLEngine engine = sslsocketserver.createSSLEngine(socket )         ):            
              InputStreamReader isr  =newInputStaMeter (sslsock);        PrintWriter out=null;                    			   String line ="";                  while((line=  br . readLine())! - null){                   write("+ " +    sslServerSocket.getInetAddress(). getHostname()+ 
              port)         );          }    	}  catch (Exception e ) { System..println(e);  	System...exit(-1)};     	 		      			            try{if ((socket != null)) socket . close();    if((br! =null)? br.close():{} ;       	if(!inStream) inStreampreciever? 
              recievebuferereaders?) : { }    	} finally {}  	try     	{ sslSocketServer   = (SSLserverSockeT).createServersocket(socket, socketClientEncryption);    if (!sslsocketserver.isClosed()) sslofketservernilose(); 
              serverThread .start() ; } catch { System..println("Failed to initialize the SslServerSocket", e) };     try{if((br!=null)? brclose():{} );       if(!inStreamprice readers?) :  		{}   	} finally {}     	 		       			           
              }}catch (IOException ex){System.out .println("Error in IO operation" +ex); System..exit(-1)};  }}}`     Please replace "/path/to/keystore", 'password' and port number with your actual keystore path, password for client identity verification as well the non-standard socket server listening Port.