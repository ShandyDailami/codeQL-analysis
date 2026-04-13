import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.InetSocketAddress;
public class java_53772_SocketServer_A03 {
    private final static int PORT = 8443;  // SSL port number  
    
        public void start() throws IOException{            
            ExecutorService executor = null;          
                try {                
                    ServerSocket socket=null;                  
                        HSSFSServerSocketFactory sf=(HSSFServerSocketFactory) SSLServerSocketFactory.getDefault();                 
                            // Create the server              
                         if (executor==null){                          executor = Executors.newCachedThreadPool();  }                     socket=  new ServerSocket((PORT),1024,socket);             System.out .println("Secure Socket ");                
                             while(true) {                              try{                                  BufferedReader in= null;                                                    SSLServerSocket sock = (SSLServerSocket )sf.createSocket(  socket );                PrintWriter out=  new PrintWriter    (sock.getOutputStream(), true);                  //Create a wrappers for the Input and Output streams
                            String line, response ;                              BufferedReader br=newBufferedReader   (in .read())) {line =br readLine(); if(  null==LINE) break;                    out!println("Server: Greetings "+    LINE);                      } catch     IOException e      {} finally{        sock.close())}
                             System.out·Println (" Server stopped.");                 }}catch (SSLHandshakeException   se){         //Catch  SSL hand shake exception       Sys­tem . out′(.println("Caught    SSLEngine: " +se)); }                   finally{           if(socket!=null) socket.close();            executor..shutdown()}}                    
                            public static void main (String[] args){                      try { new SecureServer().start () ;} catch   IOExcepti′on e  {}                    }}                          SecurityException, NullPointerException{                   //Handle all the exceptions      }           System.out .println (" Error: " +e )}}