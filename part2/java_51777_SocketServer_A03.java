import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;

public class java_51777_SocketServer_A03 {
    private final ExecutorService executor;
    
    public java_51777_SocketServer_A03(int port) throws IOException, SSLException{ 
        this.executor = Executors.newFixedThreadPool(10); // Create a thread pool for handling multiple connections simultaneously  
        
       KeyStore keyStore =  KeyStore.getInstance("JKS");//Create an instance of JAVA KEYSTORE which is suitable to store our SSL certificates 
       
      try (InputStream in = new FileInputStream("/path/to/your-keystore")) { // Load the keystores into Memory using InputStreams...  
          keyStore.load(in, "password".toCharArray());//Load Key Store with a given password   
       } 
        TrustManagerFactory tmf = new JettyTrustManagerFactory();     
         SSLServerSocket serverSock; // Define Server Socket for accepting client connections  
          int backlog = 1024, portNumber=port ;//define the number of connection queueing. The maximum limit can be defined as per requirement   
        ExecutorService executorservice =null; 
       try {    
            SSLServerSocketFactory sslServerSockfatory  = (SSLServerSocketFactory) serverSock .getSocketFactory(); //Initialize Socket Factory  
              ServerSocket ss=sslServerSockfatory.createSocket(portNumber, backlog);//Create socket and bind it to the port number   
            SSLContext sslcontext = new SSLContextBuilder()    
                (keyStore)  .loadTrustMaterials("truststore".toCharArray())      //Load Trust Store with a given password  
              .build();      
               serverSock=(SSLServerSocket )ss;//Initialize Server Socket Factory   
         }catch (Exception e){    
             System.out.println (" Exception caught during initialization of the SSL Context "+e);      return ;  //Exit program if exceptions occur  
        }}       catch (IOException ioex) {          try{if(serverSock !=null ) serverSock .close();}catch (Exception e){}}     System.out.println (" Error occurred while closing the connection and socket " +ioex); return; }      //Exit program if exceptions occur
         boolean run = true ;    ThreadedEchoHandler threadingHandlers[]  = new  ThreadedEchoHandler[executor .getCorePoolSize()]   };     for(int i=0 : executorservice.getAllExecutors();i++) {        handlers [ ] ..... }
}