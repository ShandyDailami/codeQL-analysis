import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_52736_SocketServer_A07 {
    private static final String SSL_PORT = "1234"; // default port for ssl server, change as per requirement 
    
   public void start() throws IOException{      
        ExecutorService executor=null;     
         try{           
              int poolSize = 50 ;//number of threads to be created in threadpool            
              executor = Executors.newFixedThreadPool(poolSize);  // creating a new fixed size Thread Pool  
               SSLServerSocket serverSocket = null;   
                KeyStore keyStore=null, trustStore=null;     
                   try{         
                        char[] passwords  = { '1', '2','3' ,'4','5' };//password for keystore and truststore        
                      // Creating a KEYSTORE which contains our privateKey to be used by clients 
                       keyStore = KeyStore.getInstance("JKS");  
                        keyStore.load(new FileInputStream("/path/to/yourkeystore"),passwords);   
                     /* Here, truststore is created from some certificate issued in production environment */       
                      TrustStore ts  = new JettyTrustStore();  //Creating a sample class for holding the data about our trusted certificates. This will be used to store information of client's Certificate  
                       KeyManagerFactory kmf = null;   
                         try{      
                             kmf =  new KeyManagerFactory.getInstance("SunKS");    
                               kmf .init(keyStore,passwords);  //Initializing the factory with our keystore and password     
                             }catch (Exception ex){   System.out.println ("Key manager error : "+ex );}    return;      
                      SSLEngine engine = null ;             try{         
                       serverSocket  = new SSLServerSocket( Integer.parseInt(SSL_PORT), executor,kmf);      //Creating our ssl socket and setting the pool of threads       
                        }catch (IOException ex ) {System .out  out ("Io error : " +ex );}     return;    try{           while ((engine = serverSocket.accept()) != null)          {}       catch(Exception e){ System.err   .println("Server caught exception: ",e);         } finally{ executor..shutdown();}} 
                //This example program does not include client authentication and will fail if clients are connected, in a real production environment you should add code to verify the server's certificate (and optionally other certificates) using SSL ServerSocket.setNeedClientAuth(true);    
               } catch (Exception e){ System .out  out ("Main error: "+e );}    finally {executor..shutdown();}}   // This will close down all threads at the end of main method        try{         new SslServer().start() ;      }}catch(IOException ex ) {System.err    
          out("Io Exception :" +ex);  }//This is a basic catch block for any exception that may arise during execution, this helps to debug your code by giving you an idea of where the error was thrown   if (!e.getClass().getName() .equals( "sun.security."+ e)) {      System..println ("Not SSL Exception:",ex); } 
                //It's always a good practice not catch all exceptions, instead use try-catch blocks to handle specific ones at the point where they occur and give appropriate error messages   if (e instanceof javax .net.ssl.) then it should be handled here because client ssl related exception might come up in that part 
                //Also include handling of different types/exception like socket close, server certificate issue etc... based on requirements to your program         } catch(Exception e){ System..println ("Main Exception :" +e );}     finally { executor.shutdown();}}    return;   }}catch (IOException ex) 
          //Here we are handling all IOExceptions here and then catching it inside each try-catch blocks if any exception occurs in them, so that the program can handle exceptions appropriately        } catch(Exception e){System .out ("Main Exception: "+e);}}    finally {executor.shutdown();}}}