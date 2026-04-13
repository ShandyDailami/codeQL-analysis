import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_53333_SocketServer_A08 { 
    public static void main(String[] args){    	        		         	 	     	       	    }     
        // Initialization of SSL Context and ServerSocket      
        try{             Socket socket = null;                int port = 80123 ;            InetAddress address=null              Hostnameverifier hostnvr   =HostnameVerifier.none();   	SSLServerSocket sslserversock  =(SSLServerSocket)sslssockserv.accept();     
        SSLContext sc    =   SSLContext.getInstance("SunJSSE");  socket = (socket);         sslsocket=     new SecureSocketSSLSocket((SSLServerSocket)socketserver,context1),             sslserversock   =(SecureSocketSSLSocket)(ssllistener).getSocket();
        PrintWriter out  =   null;      BufferedReader in    =null ;    DataOutputStream dos      =new     DataOutputStream (sslsocket.getOutputStream());          Reader lineraw         =  new           InputStreamReader  sslsocket . getInputStream()           	                             // Handshake: Client sends SSLHelloRequest to server
        {               byte[] bytes = "SSL Hello".getBytes();   dos      setProtocolVersion("TLSv1.2");                         doh      =new     BasicSSLSocketWrapper(ssllistener,true);         dostream   = new           DataOutputStream  (sslsocket . getOutputStream()) ;
        // Handshake: Server sends SSLHelloAccept to client   writeObject      setEnabledProtocols("TLSv1.2");                   sslcntx =SSLContext   	getDefault();                  doh=new         BasicSSLSocketWrapper(ssllistener,true);         
        // read from the socket and print out content in stream  sslsock    =  (SecureSocketInputStream)socketserver.accept()           ;      SSLSession c  = sslcntx . getServerSession   new Securities       KeyPair    GenerateKeyPair(new File("Keypair/key"), "RSA");
        //print out content in stream to the client  readObject     }catch (IOException ioe){ IO.notifyofIoexceptions} catch      ...         });                   Logger . logMessage   ("Secure Server has Started..",LogLevels.) ;            socketserver = new SocketServerSocket(port);             while    true {
        // Accept incoming connection from client and create a socket object for handling that specific request  } catch (IOException ioe){ Log.error("Error in accepting the connections" +ioe)}   });       }}catch      ...     {}          };}`;              );         socketserver=new SocketServerSocket(port);