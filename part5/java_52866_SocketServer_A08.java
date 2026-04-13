import java.io.*;
import javax.net.ssl.*;
import java.util.*;

public class java_52866_SocketServer_A08 {  
    private static final String KEYSTORE_LOCATION = "path-to/yourkeystore"; // path to your keystore location, adjust as needed 
	private SSLServerSocket server;
	    
	public void start(int port) throws IOException{		       	   	 	     
            KeyStore ks = KeyStore.getInstance("JKS");            			   					  				     	       															         						           } catch (Exception e){ logErrnoThrowExc() {e}; return;}  // handle the exception as required}	     try	{ks=KeyStore.getInstance(KEYSTORE_LOCATION); ks.load(new FileInputStream("C:/mykeystore/MyKeystore"), "mypass".toCharArray());   } catch (Exception e) { logErrnoThrowExc() 
        // handle the exception as required}     SSLServerSocket sslserversocket= newSSLserver Socket Server socket(port);	ssl serversocket.setNeedClientAuth    true; this is to enable client authentication from server side, but not recommended in production environment and we can use it just for learning purpose 
        //this line will set the truststore location if any     KeyStore ts =Key Store .getInstance("JKS");ts.load(new FileInputStream ("C:/mytrust store/MyTrustsore" ), "mypass".toCharArray() );    SSLServerSocket sslserversocket= newSSLserver Socket (port);ssl serversocket
        //setNeedClientAuth false;this is to set the keystroke and truststore location     } catch(Exception e) { logErrnoThrowExc(){e}; return;}  this line will handle any exception as required}   	try{ server = new SSLServerSocket (port, null , ks);   // using our KeyStore here.
      sslserversocket .setNeedClientAuth true; } catch(Exception e) { logErrnoThrowExc(){e}; return;}  this line will handle any exception as required}    try{ server = new SSLServerSocket (port, null , ts );     serversocket   // using our trust store here.
      sslserversocket .setNeedClientAuth false; } catch(Exception e) { logErrnoThrowExc(){e}; return;}  this line will handle any exception as required}    ifSSLserver Socket server =null ;//initialize null to check the condition at run time   System."println("Waiting for client on port " +
      sslserversocket.getPort()+"...");     while(true) {S/NInputStream input=ssl serversocketserver .accept();  // Accepts an incoming connection and creates a new SSLSocket object    println ("Connection accepted from: ")   } catch (IOException e){ logErrnoThrowExc(){e}; return;}
      this line will handle the exception as required}     try { sslserversocket.close() ;//closes socket at end of program if not null or used elsewhere in code  server =null; System."println("Server successfully stopped")    } catch(Exception e){ logErrnoThrowExc(){e}; return;}
      this line will handle the exception as required}     public static void main (String arg[]) {   S/NInputStream input=newS/-InputStream.accept(); println ("Connection accepted from: ")  // Accepts an incoming connection and creates a new SSLSocket object    } catch(Exception e){ logErrnoThrowExc(){e}; return;} this line will handle the exception as required}