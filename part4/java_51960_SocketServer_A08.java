import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;  // For ExecutorService, BlockingQueue and Callable  
import java.security.cert.*;
    
public class java_51960_SocketServer_A08 {     
    private static final int port = 4096;      
        
        public void start() throws IOException{         
            ServerSocket server = null;              //SSL/TLS setup          
             try  {                                  
                 System.out.println("Starting Socket SecureServer on " + port);    
                 
                server =  new ServerSocket(port,null/*unlimited*/ );   
               ExecutorService executorservice =Executors .newCachedThreadPool();   //thread pool for multiple client connection        
                 while (true) {     
                     Socket socketConnection=server.accept();     System.out.println("Client Connected");                     
                       SSLServerSocket sslServer=  (SSLServerSocket )socketConnection;                   
                         Handler handler =new  ConnectionHandler(sslServer,executorservice);                  //Thread per Client      
                          executorservice .submit(handler );   }          }           catch (IOException e) { System.out.println("Error accepting connection from "+e);        closeIt(server);}    finally{ stopExecutorService();}}      private void  closeIt(ServerSocket server){         try     { if ((server)!=null )      
                   server .close(); } catch (IOException e) {}          System.out.println("The Server is closing");   }}             //executor for client connections        @Override public void run()    {{try      {SSLContext sslcontext = SSLContext.getInstance ("SSLv2" );     javax.net.ssl .SSLSocketFactory sslsf = 
                (javax.net.ssl  .SSLSocketFactory) sslcontext   .getSocketFactory();          BufferedReader br  = newBuffere    dInputStream(socketConnection.getInputStream());        ObjectOutputStream out =new     OutputStreamWriter      //client information       written here,out);           
                  String userInput;         while((userInput=br..readLine())!=null){               System.out.( "Received: ." +   User    .class+""); }}catch (IOException e) {e(closeit     });}}           private void stopExecutorService(){      ExecutorServicemaintainerservice = null;
          } catch{}                    //if the executorserviecename is not empty         if            (!mainexecutorsservice.isShutdown())    mainexecutorsservi               eue  ().shutdownNow();}}}   SecureServer secureS=newSecretserver()     safe       SequenceFireshufflebuffer