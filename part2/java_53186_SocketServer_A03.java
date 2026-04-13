import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;
  
public class java_53186_SocketServer_A03 {   
     private ExecutorService executor;  // Used for managing thread pool     
      
     public static void main(String[] args) throws Exception{       
         SSLServerSocket sslServer = (SSLServerSocket) new SSLServerSocketBuilder(8443).build();         
          
             Socket socket=null;             
               while((socket=  sslServer.accept()) != null){                     System.out.println("Accepting connection from: " + ((SSLClientSocket) (socket)).getSession().getId());                  Thread thread = new SocketThread(socket);          // Start a worker process to handle this client                         
                 executor.execute(thread );           }     setDefaultCaAndKey();         System.out.println("Server listening at port 8443.");        SSLServerSocketFactory sslServerSockf= (SSLServerSocketFactory) SSLServerSocketBuilder .forTLS().build() ;         
                  socket =sslServerSockf.accept(socket);           SocketThread st=new       // new worker process to handle this client             Thread thread1 =  New     TcpConnectionPoolHandler 4,0   (st).start();    }      private void setDefaultCaAndKey() throws Exception{             
        File file = null;          System.out.println("Generating Default CA and key");                  SSLContext sslcontext=SSLContextBuilder .load(file,"password".toCharArray()).setProtocol("TLSv1").build();           KeyStore   keystore  =KeyStore.getInstance  ("JKS") ;           
         char[] password ="sslpasswd ".ToCharArray() ,chars []=  new byte [32];          Random    random=new     Random ();                   for(int i = 0;i<8;) { chars[i]   =random.nextInt  (1 <<  6) +'A';                  }               System .out     
         string("password")+ ":");              KeyGenerator kg =KeyGenerator      =    K  generator,kg ;           keystore    =  kgenerator!keypair;                   PKCS8KeyPair keypair    =(PKCS8Key pair)  1.setPrivatekey ( private_RSA );        
        } catch({...}                  SSLServerSocket sslserver=null      try {sslserve    rver =SSLServe     mtBuilder .create           TLS       Server socket at port 9432;          System                     println("Accepting connection from: " + ((T                   lientSocke) tsocket).getSession().getId()); Thread thread=new SocketThread(tsockenserver);        
executor.execute (thread ); } catch(){...}//catch the exception if any             socket = sslserver,accept();  // Accepting connection from client      try {if ((Socket)soc‌et).isConnected() == true then{ System out .println("client is connected");   
        SocketThread st=new     TcpConnectionPoolHandler(socket); Thread thr = new       Thre.start(); } catch (IOException e){...}             socket, close()); }}  //Close connection         });           executor,,shutdown()}};      System out .println("Server is stopped");}}}