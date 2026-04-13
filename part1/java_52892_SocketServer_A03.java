import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_52892_SocketServer_A03 {    
    private static final String SSL_PORT = "8443"; // Change this port if you want 1025 or something else (default: '8443')
      
        public void startServer() throws IOException{        	         		     			  	     									          	 								     Socket socket;   	    SSLEngine sslEngine = null ;                try {            	        // Create a server-side socket and bind it to port           	socket =  new ServerSocket(8091).accept();                 SSLServerSocket sslsocket=  (SSLServerSocket)socket.getShared().createSSLSocket(socket,sslEngine);                  Thread thread=new     Thread(){@Override public void run() {
      try{sslsocket =((SSLServerSocketImpl)  	 sslengine .getState()).accept(); 		 // Accept new connection                 BufferedReader inbuf =  null;        String str;         while(true){          if(! ((InputStream ) sslsocket).isReadyOutputStream()) break;}           try{              
      InputStream is =sslsocket.getInputStream ();             Reader reader=null ;     boolean   bool=  false 	boolean flag    ,bool2  =false,flag3   = true;            while((str       !    = null)) {                    if(reader==          nul         l) break;}
}catch      exception e        catch(){} }}}`}}{{{{}}} }}