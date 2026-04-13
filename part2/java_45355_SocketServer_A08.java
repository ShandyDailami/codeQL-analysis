import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_45355_SocketServer_A08 {
    private static final String CLIENT_IDENTIFIER = "SSLClient"; // Client identifier in SSL certificate 
      
        public static void main(String[] args) throws Exception{     
            ServerSocket serverSock;         
              ExecutorService pool;          
              
             int port = 8090;         //default Port number.    Modify as per requirement  
                      SSLEngine sslEngine = null ;       SSLServerSocket secureSock  =null  ;    
                       try {        serverSock    = new ServerSocket(port);           pool= Executors .newFixedThreadPool (10) ;          }catch (IOException e ){ System.out.println ("Could not listen on port: " +   port );    Environment.getExitStatus () ==  2  ?  System.exit (-1)};
                          while(true){     Socket incomingSocket = serverSock .accept() , clientSocket=null ;          try {            sslEngine  = SSL.createSSLEngine (incomingSocket,sslEngine);                    SSLEngine_initParams params =  new   SSLengineInitparams ()  _SSLVERSION_TLSv1;   
                           sslEngine . setUseClientMode(true) ;                     Connection con=s slingEngi newConnection     //using the Socket incomingSocket ,ssl engin and connection to establish a secure session.      (Connections   in server )  }catch (SSLException e){ System .out    .println ("Handshake failed"+e); continue;}
                           ExecutorService_pool_.execute(new ConnectionHandler     //connection handler thread for each client connected,threadPoolExecutor is used to handle connection-based tasks.       );      };           sslEngine  null; }   });              try { Thread .sleep (20 *60*100);}catch   
                           (InterruptedException e){ System .out Println ("Error in     sleeping: " +e ) ;}}}}}          finally{ if(serverSock !=null) server Sock.close();   pool_.shutdown()};  }           };      })         }} //End of main function