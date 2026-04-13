import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_52347_SocketServer_A01 {    
    public static void main(String[] args) throws Exception{       
         ServerSocket sock = null;          // Create a server socket to bind the echo service 
           try              
            {                 
                SSLServerSocket sslsock =  (SSLServerSocket)sock.accept();                
                   SSLEngine engine  =   sslsock .createSSLEngine( "localhost" ,40123);             // Create an ssl socket that will do the encryption/decryption work 
                SSLContext sc=     SSLContext.getInstance("SSL");          // Set up a secure context to use   
                 sc  =  (SSLContext)sc .init(null, new java.security.SecureRandom());         // Initialize it with default settings          
                  engine .setUseClientMode(true);                // Use the ssl socket for client mode  and pass in your certificate chain info             
             system    .out.println (engine );          System Exit      ;        return; } catch   (java.security.*Exception e) { java.util.logging.*;     log(" Error creating SSLContext : " +e)}catch( IOException var10 ){       Logger  LOG =  Loglevels!    .info ("IOException: %{}",var2 );return ;} finally        
                if ( sock != null) { try   { sslsock.close(); } catch     
                  (Exception e){ log("Error closing socket : " +e);}}  System Exit; return;}           // Close down the server properly after we finish up things       public static PrintStream    Logger LOG =Loglevels! .getLogger(SecureEchoServer.class );        private java_52347_SocketServer_A01(String msg){LOG != null ?     log ("[ " +msg+" ]") :      System  Exit ; }         // A simple logging method that can be used by the above methods           public static final int PORT = 40123;       };            try { sock = new ServerSocket(PORT);               
                  LOG.info("Server started on port " +   SecureEchoServer .class   +" ("  +  Port +  ") "); } catch (IOException e)     { log("\n Can't setup listener to port:",Port );}}        System Exit; return;} // main method ends here
             };            public static final String VERSION = "1.0";   }} ; Catch the exceptions and print out a message for debugging purpose . Println(e);  }}}} End of code snippet!