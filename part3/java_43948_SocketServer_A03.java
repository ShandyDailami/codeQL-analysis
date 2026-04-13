import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_43948_SocketServer_A03 {  // Define Server Class with SSLSocket and Handler inside it  
    private static final String SERVER_SOFTWARE = "Secure Chat/1.0";          
      
        public void start(int port) throws IOException,SSLException{    
            SSLServerSocket serverSocket=null;  // Declare Server Socket variable and set up an SSLLocalHostener  
              
                try {   
                    KeyStore keyStore = KeyStore.getInstance("JKS");      
                      /* Load our keystore which is in the .jks file */     
                       keyStore.load(new FileInputStream("/path/to/.keystore"), "password".toCharArray());   // Password for Keys   
                          
                    KeyManagerFactory keyManagerFactory =   Security.getKeyManagerFactory("JKS");     /* Create a Default Java keymanager */ 
                            SSLContext sslContext=SSLContext.getInstance("TLSv1_2") ;      
                                    sslContext .init(keyStore,null/*password*/ , new java.security.SecureRandom());      // Initialise the context with Keystore and password  
                           SSLEngine ssle =sslContext.createSSLEngine("localhost");     /* Create an SSLEngine from our initialized Context */ 
                            serverSocket= (SSLServerSocket)ssle .accept();       // Accept Connection to Server   
                                  socket  =serverSocket.accept(socket);          //Get client connection and start communication          
                           SocketInetAddress sin = new InetSocketAddress(/*IP Address or hostname*/,port );  /*Set up a server side for receiving messages from clients */  
                            PrintWriter out=new PrintWriter ( socket . getOutputStream(), true);        //Get Output Stream and write data to client    
                                  BufferedReader in = new BufferedReader((InputStreamReader(socket.getInputStream())));       /** Set the InputStream we can read on by reading from a Socket connection  */  
                               String userInput, response;           /*Declare input & output string variables*/    };         // Begin Execution of Server code     }      catch (IOException e){}//End Block for catching any IOException.          });            System .exit(0);        }}                     ** End Main Function**  */