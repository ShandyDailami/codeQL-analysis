import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
  
public final class java_42401_SocketServer_A03 {   
  private static SSLServerSocket sslServerSocket = null;    
      public static void main(String[] args) throws IOException, InterruptedException      
        {          
            ExecutorService executor=null ;         
              try{              
                int cores  =  Runtime.getRuntime ().availableProcessors();             //determine the number of CPUs available to this program        
                  System . setProperty("java.util.logging.manager", true)    )      }catch(Exception e){}            executor = Executors . newFixedThreadPool  (cores + 1);              
                 sslServerSocket=new SSLServerSocket(-1,null /*SSLContext*/ ,false/*true if server should listen on port number which is not occupied */ );          //create a Server socket with the same local machine IP address and listening to an arbitrary available TCP/IP Port.  false means this will be non-blocking  
            SSLSession ssl = null;               
                  while( true ){                   int recv = 0 ; BufferedReader in  =null    , out=null, br   =new BufferedReader ( new InputStreamReader(sslServerSocket . getInputStream () ))      //establish a connection                    Socket cliente  =  sslServerSocket.accept();              
                  Handler handler = null;           try {                          if ((recv  = in . read()) < 0 ) throw new IOException("Couldn't accept the incoming Connection request");    Thread (new Runnable ()  //establish a thread for each connected client,   Run n=null ;             ssl =  SSL.getSSL(cliente);                
                  handler = new ClientHandlerSocketImpl((SSLSocket)ssl ,in );               } catch (IOException e){ Logger . getInstance() (. ). log ("Couldn't establish a thread  for the client : " +   // print out exception to check if it is happening.                    });    break;                        
                  Run n = new Thread( handler ) ; executor.execute( n );               }      finally{          sslServerSocket . close();executor !=null && executdown (exec  uthority() ,0)   /* shutdown the Executors and then exit */        };    });           // end of main thread