import javax.net.ssl.*;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_50995_SocketServer_A01 {
    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());  
    
	public void start() throws IOException, SSLException{  //starting the server with BouncyCastle certificate verification        	
        Socket socket=null;              			//declaring new sockets   	       			     									               	   	 	     
                                                                          DatagramSocket datagram = null ;             DataOutputStream out  =   null       ;                   HostAddress host =  null            //  declairing the variable type and name          	    						             								        };                     }                    @Test                                                      TestClient test=new    SecureServer();                  try{test.start()}catch(SSLException e){logger .log (Level...