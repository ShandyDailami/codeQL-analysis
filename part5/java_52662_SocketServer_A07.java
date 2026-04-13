import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.ssl.*;

public class java_52662_SocketServer_A07 {  
    private static final int PORT = 3456;  // you can change this port number, it's for demonstration purposes only     
    
    public void start() throws IOException{        
        SSLContext sslcontext = initSSL();      
          while(true){          
                ServerSocket server_socket=new ServerSocket(PORT);              System.out.println("Server started at port: " + PORT );             Socket client_socket = 0;            try {               // Accepting a new connection        
                    SSLSocket sslsocket = (SSLSocket)server_socket.accept();        sslcontext=initSSLContext(sslcontext);           System.out.println("Connection accepted from : " +sslsocket.getRemoteSocketAddress());              BufferedReader in  =new BufferedReader((InputStreamReader)(sslsocket.getInputStream()));             String clientquery;               
                    DataOutputStream out = new DataOutputStream ( sslsocket . getOutputStream() );               while(true){           // Handling each request as a separate thread for security         AuthFailure exception handling is omitted, you should include it here      }}} catch (IOException e) { System.out.println("Exception caught: " +e); socketNotUsed(client_socket);}      
          }}            public SSLContext initSSLContext(final SSLContext sslcontext){           return new SSLContext(){(cipher, password)-> cipher,(keyStoreBuilder->  keyStoreBuilder),(trustStoreBuilder - > trustStoreBuilder)};}}   catch (Exception e) { System.out.println("Error in setting up the context: " +e); }}