import java.io.*;
import java.net.*;
import javax.net.ssl.*;
 
public class java_53397_SocketServer_A01 {    
    static SSLServerSocket server;   //SSL Server Socket        
     
    public void start(int port) throws IOException{       
       try{          
          System.out.println("Starting the secure socket server at "+port);           
            
          //Create a KeyStore and load it into SSLServerSocket factory                  
          KeyStore keyStore = KeyStore.getInstance("JKS");             
                 
         FileInputStream fis= new FileInputStream("/path/to/yourkeystorefile");    
          
        String keystorePassword="mypassword";                      // Your password  
                    
      InputStream is =  new BufferedInputStream(fis);         
                  
       try{                 
             System.out.println("Loading KeyStore From "+ fis +'('  +keyStorePassword+  ')' );   
              keyStore.load(is, keystorePassword  .toCharArray());                     // Load your Keys store  
           }catch (Exception ex){                     
                try { if(fis != null)fis.close();} catch(IOException e1){e1.printStackTrace();}}                   
                   KeyManagerFactory keyMgrs = STSResolverUtil     .getKeyManagers(keyStore, keystorePassword  ,null);         // Get the Asymmetric Cipher for managing client sessions and traffic encryption/decryption          finally{SSLContext context= SSLServerSocketInit.initSSLServerSocket(server  
           new String[] { "TLSv1" }, keyMgrs, null );                 System.out.println("Starting Server on Port: 8092");    server = (SSLServerSocket) s.accept();                   //Accept connection from client and start protocol read write thread       }catch(Exception e){e .printStackTrace()}}                   
   catch{        if(s != null ) try {server.close();}     finally  System.out.println("Closed the Server")}            return;               }}             protected void runServer ( int port) throws IOException          {{                SecureSocketServer s = new           this .getClass().getName() +"_Securesocket";             
    try {s=new         SSLServerSocket(port);} catch     (IOException e){System.out.println("Cannot create Sockserver on Port: 8092"); return;}}                System .....        }                                                    }}      // Test the code and then run it in your IDE or use command line to compile and execute