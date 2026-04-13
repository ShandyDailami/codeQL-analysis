import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_49132_SocketServer_A08 {  
    private static SSLServerSocket serverSocket;
    
        public static void main(String[] args) throws IOException, ClassNotFoundException{     
            try {  // Initialize Server Side of the TLS Connection            
                KeyStore keyStore = KeyStore.getInstance("JKS");              
                
                    InputStream inputStream =  new FileInputStream("/path/to/keystorefile") ;         
                  String password1="password";              char[] arrayPassword  = password1 .toCharArray();  
                   // You can also use this to read the keystore from your external file            KeyStore ts = KeyStore.getInstance("JKS");                     try {ts.load(inputStream,arrayPassword)}catch (IOException e) {}                      TrustManagerFactory trustManagerfactory=null;             SSLServerSocket serverSocketsocket= null ;
                Socket client  =serverSocket .accept();       socketInputStream =  new BufferedReader  (new InputStreamReader   ((client).getInputStream()));                   System.out.println("New Connection Established: "+socket);                  String message =" ";                 HttpsURLConnection httpsconnection=null;
                SSLContext sslcontext=  null ;              //Create the context with keyStore and truststore                      try {sslcontext =  SslServerSocketFactory .create(serverSocketsocket,trustManagerfactory ) }catch (Exception e) {}  socketOutputStream = new PrintWriter     ((client).getOutputStream(),true);
             s   fwrite("SSL Server Started");socket.close();         BufferedReader in=null;                  try {in=  newBufferedInputStream(new InputStreamSocket());} catch    Exception aa      }catch (Exception e) {}       finally{        if  (!sslsocket .isClosed())          sslsocket   close () ;               System.out.println ("Connection closed :" +socket);          
            }}              //end of main method}}}        `