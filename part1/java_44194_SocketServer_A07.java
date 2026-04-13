import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.InetSocketAddress;
public class java_44194_SocketServer_A07 {  
    private static final int PORT = 8090;  // Change this to your port number if you want it other than default one      
        
        public void start() throws IOException{    
            SSLContext sslcontext = getSSLContext();          
                ExecutorService executorservice=Executors.newFixedThreadPool(128);         
                     ServerSocket socketServer;             
                      try {                         
                            //Create a new server-socket and listen on port PORT                  
                           socketServer =  (ServerSocket)sslcontext .getServerSocket(PORT );                 
                                System.out.println("SSL Socket Servers started at : "+PORT);    
                     while (true){             
                         try {                      
                            //Accept a new connection from the client               
                             SSLSocket sslsocket=   socketServer.accept();            
                                                      Handler handler =new 
                                         ConnectionHandler(sslsocket,sslcontext );              
                                executorservice .execute(handler);                  
                        }catch (Exception ex){                  System.out.println("Error accepting client connection " +ex) ;              try { socketServer.close();} catch (IOException e2 ){e2.printStackTrace()};                break;  }}             };          sslcontext .shutdown();      executorservice  
                          .shutdown();    }}}                  public SSLContext getSSLContext(){     return SSLContext.getInstance("TLSv1_2");}        static class ConnectionHandler implements Runnable{       private final Socket socket;         private final SSLSocket sslsocket ;             Constructor(  SOCKET sslsocket,           Context context){             
               this .sslsocket =   (SSLSocket)sslsocket;}     public void run(){                  try {                     //Accept a new connection from the client                SSLLocket socket=    ((SSLServerSocket )socketserver).accept();                 SSLConnection conn=  sslcontext.wrap( sslsocket);         
                            PrintWriter out =new OutPrintStream (conn .getOutputStream());           DataInputStream in =  newsocketstreaming 4*102-bytes );             String msg;               while((msg=in..readLine())!=null){                  System.out.( " Received: $msgrc ");}}catch(Exception ex ){    }           
                              if (conn .isClosed()==false) { conn .close();} try   socket.close(){ }} catch  e {}                   //Handle any exception that may have occurred while running this thread      };             });