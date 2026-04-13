import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_44844_SocketServer_A01 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket sock = null;  // Socket for incoming client connections             
              
          try {                      
            SSLServerSocket sslsock = (SSLServerSocket)sock.accept();  
                       
                    SSLEngine engine =  sslsock.createSSLEngine("localhost",843);                
                   /* Create a custom trust manager that allows all certificates */ 
                    
                      X509TrustManager tm = new X509TrustManager() {  
                        public java.security.cert.X509Certificate[] getAcceptedIssuers(){ return null;}    // returns an array of trusted CAs    
                       /* For simplicity, this method always allows any certificate */     
                          public void checkClientTrusted(X509Certificate[] certs){}      
                        public  void checkServerTrusted(X509Certificate[] certs) {}    };   // returns to client a trusted one    
                       engine.setNeedClientAuth(true);                 /* Request Client Authentication */        
                     SSLEngine e = sock .createSSLEngine("localhost",843 );  /** Create an SSL connection for the socket, using TLS protocol and default port*/      
                        //establish a new client-side encryption to send/receive data     
                         engine.setUseClientMode(true);     /* Set up encrypted communication in Server side */  
                       e . setNeedServerAuth ( true );    /** Request server authentication from the Client  *//* End of setting SSL Engine properties, and then connect it with socket using send/receive data to client or use a different engine for sending message.*/       
                      sock = sslsock;            /* Assign new created encrypted SSLEngine */       e . setSSLServerSocket(sslsock);   /** Attach the SSL Server Socket  *//* Now we can start communication with our client by writing data to socket and reading from it.*/    
                       PrintWriter out =e . getOutputStream().getWriter();        /* Send encrypted information */      String str="Client: Hello Client";    byte[] bytesend=str.getBytes( );   e.startHandshake(); /** Hand Shaking starts here,  and waits for the server to confirm a possible client certificate-based authentication request*/
                        out .println (bytesend);         /* Send Data */                     System.out.println("Sent from Server: " + str) ;    // print something back as response        sock..setKeepAlive(true,0);          /** Set Keep Alive properties to true and time in milliseconds  *//* Start receiving data - read server's message */    
                       DataInputStream dis = e.getInputStream();   byte[] bytes= new byte[256]; int len; String str2 ;    // receive a string from the client      while((len=dis . available() )>0) {       BufferedReader br=  new  BufferedReader(new InputStreamReader ( dis));    
                         } catch (Exception e1){e.printStackTrace();}        sock.close(); sslsock.close();         /* Close the Socket */    }}            // End of Server code   });      try { Thread thread= newThread("accepting socket connections");  thread . start( );}}catch(IOException ex)
{ex. printstacktrace ();}     } catch (Exception e){e-printStackTrace();}}}**End Program*/