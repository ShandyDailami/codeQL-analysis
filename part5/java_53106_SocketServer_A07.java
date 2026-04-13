import java.net.*;   // for InetAddress and ServerSocket class java_53106_SocketServer_A07 javax.net.ssl.*;  // Import required classes to implement SSL/TLS server side features (SSLServerSocket)     
      
public class SocketService {    
           private static final int PORT = 3456;       
        
            public void start() throws Exception{         
                ServerSocket sock = null ;   // the socket for listening to client requests.   
                   try  {                    
                        SSLServerSocket serverSock=null;     //SSL Socket     
                         
                         KeyStore keyStore =  KeyStore.getInstance(KeyStore.getDefaultType());        
                             char[] passwords = "password".toCharArray();       
                             
                            sock  = new SSLServerSocket(PORT,keyStore ,passwords);   ## Setup server socket with port number and default keystore  .....    //SSL Server Socket    
                          /*sslContext=TransportFactory.createSslContext ( keyStorePath );*/      ...//Set up ssl context..          
                        
                            System.out.println ("Waiting for client on port " +PORT);   ....              while(true){  .....          //Infinite loop to accept multiple clients                 socket=serverSock .accept();                }                  catch (Exception e) { ...e.printStackTrace() ;}     finally{ if(sock !=  null ) sock.close();}}