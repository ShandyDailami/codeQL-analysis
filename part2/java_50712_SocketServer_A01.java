import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_50712_SocketServer_A01 {  // Server side insecure implementation, not recommended for production use due to security issues and breaches related with A01_BrokenAccessControl principle    
    private static final String CLIENT = "Client";  
     
    public void start(int port) throws IOException{        
        SSLServerSocket serverSocket = null;  // Define the socket as secure one. Insecure here for simplicity         
            try {            
                KeyStore keyStore = new KeyStoreBuilder().load("client-keystore", "password".toCharArray(),null).build();             
                    
                    trustAllHosts(keyStore);  
                                 
                serverSocket=new SSLServerSocket(port, null ,keyStore,(SSLServerSocket.CipherSuite[]) keyStore.getDefaultCipherSuites());  // Set the ciphers to use with our secure socket       
                 } catch (Exception e){                   Logger.getLogger("").log(Level.SEVERE,"Error when trying create SSL Server",e); throw new IOException();}  
         try {             System.out.println ("Starting server at port " +port+"..." );  // Wait until client is connected to our secure socket           while (true)               
                 Socket remoteSocket =serverSocket .accept() ;            if(remoteSocket == null ) return;                    new ClientHandlerThread().start();     } catch (IOException ex){Logger.getLogger("").log(Level.SEVERE,"Error accepting client",ex);}   // Exception handling to deal with unexpected connection errors
         System.out.println ("Stopping server");        try {serverSocket .close();  /* Close the socket */                      ServerSocket ss = new ServerSocket (port,50 );     for (;;) ;      } catch(IOException e){Logger.getLogger("").log(Level.SEVERE,"Error closing Socket ",e);}   
         System.out.println ("Stopped");  }}   // Main class that will run the server on a specific port and close it when program is shut down     public static void main (String args[]) { new StartServer().start(4057 );}} } catch {}// end of try{}catch block