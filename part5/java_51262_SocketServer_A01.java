import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.security.cert.CertificateException;
  
public class java_51262_SocketServer_A01 {   
     private static final int PORT = 12345;  //Change this to your desired port number, change back if you want it public accessible on internet            
     
     ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);   
      
   private SSLServerSocket serverSocket;
        
  // Method to initialize the Server socket with specific port and create a new sslserversocket for it            
     public void startSSL(){          
        try{           
          KeyStore keyStore = KeyStore.getInstance("JKS");   
                  File keystoreFile=new File("/path/to/.keystore"));      //Change this to your .jks file and location 
              char[] passwordArray1 = "password".toCharArray();           // Change the above line too with appropriate key store type            
            int p = 8092;                                                  // Port number where you want it running              
                SSLServerSocketFactory sslserversocketfactory= (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();  
                 serverSocket =(SSLServerSocket)sslserversocketfactory .createServerSocket(p,null ,keyStore, passwordArray1);              // Create the Sockets Server     
             }           catch  (FileNotFoundException e){         printf("\n Error while loading keystore ");    println(" "+e.getMessage());}        finally { try{if((serverSocket)!= null) serverSocket.close();}}          if(keyStore !=  null ) keyStore.exportKeyStoreToJKS("/path/to/.keystore",passwordArray1); 
         } catch (IOException e){ println("Error establishing the SSL Server Socket");}           // Catch exceptions for proper handling        try {serverSocket=null;} finally {}             if(executors !=  null ) executors.shutdown();     
     }}       static public class Listener implements Runnable{    private  final SSLServerSocket server ;   char[] passwordArray1 = "password".toCharArray() , passphrase  ="passphrserexample." .toCharArray(), decryptedPassword; int port = 8092, keyStorePort= 5432;}
          // Listener class which listens to incoming connections  and serves the client request.     try { server=new SSLServerSocket(port);} catch (IOException e) {}        if((server)! = null){         for (;;)       Socket sock =  server .accept();   println("Accepted Connection From :" +sock.getInetAddress().toString()); 
             DataInputStream inFromClient= new DataInputStream(sock.getInputStream()) ;     BufferedReader in =newBufferereader (                                           // Handle the data from client side and echo back to server    try {while((receivedDataLine ) !=  null)   receiveddata =  stringDecoder .decode(); 
              } catch{println("Error Decoding Data From Client" + e.getMessage());}                      println( "Disconnected!");        finally     sockethooks..close() // Close the connections    }}      public static void main (String args[]){ new SecureServer().startSSL();}} 
   }                catch {println("Exception at accepting client :" + e.getMessage());}                 println ("Closing down"); executors .shutdown () ; try{ if(serverSocket !=  null) server socket.close()}; finally{} //Close the port and terminate all threads