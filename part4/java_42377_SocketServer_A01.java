import java.io.*;
import java.net.*;
import javax.net.ssl.*;
    
public class java_42377_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{      
        ServerSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();  // use default protocol to create Sockets in JDK10 and later versions        
            
            try (SSLServerSocket serverSocket = 
                  (SSLServerSocket)factory.createServerSocket(new InetSocketAddress("localhost", 12345), 60, 1000)) {   // create SSL Server socket       
                System.out.println ("Starting Secure Socket Server on port : " +  serverSocket.getLocalPort() );   
                
                    while (true)     {                  
                        try(SSLSocket client = (SSLSocket)serverSocket.accept())  // accept incoming connection              
                        {                    
                            System.out.println("Client IP: " +client.getRemoteSocketAddress());  
                            
                                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));                
                                    
                                    String line;                     
                                        while ((line=in.readLine()) != null) {  // read from client               
                                          System.out.println ("Received: " + line);  
                                         }     
                                if (serverSocket instanceof SSLServerSocketSSL ){    
                                      try(PrintWriter out = new PrintWriter((client.getOutputStream()), true))   
                                        {                    
                                            // Send response to client           
                                             out .println("Thank you for connecting");                     
                                                        }            
                                     catch (Exception e){              System.out.println ("Closed connection from " +  
                                         client.getRemoteSocketAddress());  }}        else{System.out.println(client);}                   // end of if         close the socket           try-finally block to always ensure a clean up and shutdown          }catch (IOException e) {e .printStackTrace();}}                 
    public static SSLServerSocketSSL wrapSocketInSslServer(final Socket sock, final KeyStore keyStore,  // Wraps existing client socket in an Secure Server     TLS Handler.  
                                                          String protocol) throws IOException{              SSLEngine engine = null;                     try {engine= SSL.createSSLEngine (socket ,keystore);}catch(Exception e){ System . out .println ("SSL Engine Creation failed: " +    socket );  }return new SSLServerSocketSSL ((SSLServerSocket) sock, engine ) ;}}         
                                                 catch (IOException ex) {ex.printStackTrace();}}} // end of main method           public static void start(int port){   try{Security.addProvider(new org.apache.xerox.squashfs4._provider());  new SecureSocketServer().start(port);}catch(Exception e ){e . println ("Error: " + e );}}