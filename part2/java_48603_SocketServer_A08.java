import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_48603_SocketServer_A08 {  
    private static final int PORT = 4567; // Port to listen on, adjust as needed        
    
    public void start() throws IOException 
	{     	      
	    ServerSocket server = new ServerSocket(PORT);         		             									                 			              	 	     	       								  ​                                                                                       Socket client = null;            if (server.isBound()) { System.out .println("Server is bound to port: " + PORT );} else 
{throw new IOException ("Port already in use")}                ServerSocket sslServer  =null ;         SSLContext sc   =   SSLContext.getInstance( "SSL");               KeyStore    ks    = null;                     try {ks = createKeyStore(); } catch (Exception e)             System . err       PrintWriter  out =  new      Stream     wrap ("System..err" ,              ErrorHandlingOutputStream);          
out.println("Couldnt Create Keystore " );               throw   IOException    in                =null;                                                       if(server== null){         server   = sslServer ;}                  else{          client  =socket (INET,PORT)        }               	     SocketAddress localaddr =      socket . getLocalSocketAddr();          
System.out,.println("Waiting for connection on "+localaddress);   if(client != null){         server   = sslServer ;} else{          client  =socket (INET,PORT)        }               	     SocketAddress localaddr =      socket . getLocalSocketAddr();          
System.out,.println("Waiting for connection on "+localaddress);   try { while((client=server    ..accept()) !=  null){ System.. out(                  Threads  -new          ClientThread ( client )).start() ; } server     =null;                      sslServer   = new ServerSocket               SSLContext . getDefaultSSLContext();            sc.init       ((KeyStorePasswo   drd: "password" ,                   ChainP             ephemeral type : RSA, and default 
length is   2048); } catch (Exception e) { System.. err(e           PrintWriter out = new StreamWrap ("System .      Err", ErrorHandlingOutputStream );          out.println("Couldnt Initialize   SSL Context "             +                  E                    nce               ) };     }}
}  Catch block for exception, print the error message and continue to next try-catch blocks in a secured way (like using Java's builtIn SecurityManager).    Avoid exceptions inside catch or finally clauses. Use static inner classes if you have them because they can only be accessed within their enclosing class which is required here otherwise it will break due 
to access modifiers of the fields and methods in this case, etc...   If possible use Java's built-in features instead for security purposes (like SSL).    Make sure to handle all exceptions properly. Exception handling should be done with try/catch blocks not just System..println or any other method that can throw an exception such as setDataFormat and getLastErrorString methods of InputStream, PrintWriter etc...