import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_51967_SocketServer_A08 {  
    private static ExecutorService executor = Executors.newCachedThreadPool();  //pool for thread creation and management, you could use a Thread Pool based on your requirements e.g., fixed size pool or an actual multithreaded approach like new threads are created to serve client requests etc..  
    
    public static void main(String[] args) throws Exception {        
        SSLServerSocket sslServer = null; //SSL Server Socket     
          try{            
            KeyStore keyStore  = KeyStore.getInstance("JKS");             
            InputStream inputStream =  new FileInputStream("/path/to/yourkeystorefile");  
                 
                System.out.println(inputStream);      
                 //change the keystore password,key and alias to match your existing truststore    
             keyStore .load(inputStream , "password".toCharArray()); 
            SSLServerSocketChannel sslChanel = (SSLServerSocketChannel)sslServer.channel();  
              TrustManagerFactory tmf= new TrustManagerFactory(){...}; //your custom implementation for trust manager factory    
             PortUnlimiter portun =  newPortLimiter(3092);//you can implement your own logic here to limit the ports used by SSL server   
         sslChanel.bind(portun ); 
            tmf .init();  
              //create a custom socket factory using our keyStore,truststore and trust all cipher suites    
          SocketChannelFactory scf = new SocketChannelFactory(){...};//your implementation for the sockt channel Factory   
           SSLSocket sslSoc= (SSLSocket)scf.createChannel(sslChanel);   //socket create with our custom socket channal    
            System.out.println("Server Started..");              
                  while((sslsoc)!= 0){  }               
          catch{...}             
           finally {    if ( sslSoc != null) sslsoc .close();   ExecutorService executors = ... ; // Close the server and free resources.     try ececute(executors, runnable);      return;  }                    };                catch{...}            
};                      public static void main (String args[]){    ......}}      `