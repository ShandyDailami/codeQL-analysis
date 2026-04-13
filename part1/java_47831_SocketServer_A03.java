import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_47831_SocketServer_A03 {  
    private static ExecutorService executor = Executors.newCachedThreadPool();    
      
        public static void main(String[] args) throws Exception  {            
            SSLServerSocket sslServerSocket=null;                      
               try{                
                   //Create a new server socket at port number PORT_NUMBER using TCP protocol, and wrap it into an instance of SSLEngine.  
                  SSLServerSocketFactory sslsf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault(); 
                         sslServerSocket=(SSLServerSocket)sslsf.createServerSocket(PORT_NUMBER);                      
                           //Create a new socket with the same port number and wrap it into an instance of SocketChannel                
                  SSLSocket ss = (SSLSocket)sslServerSocket.accept();                       
                          System.out.println("New connection accepted");                     
                     Thread t=new EchoThread(ss);  //Create a new thread that echoes back any data received from the client                           
                   executor.execute(t);                 }                  catch (IOException e) {                    e.printStackTrace();}}}           finally{                           if(!executor.isShutdown()){                          System.out.println("Closing down");   //Stop accepting new connections and cleanup                         Executors                .shutdownNow());}}           
       private static class EchoThread extends Thread  {     public java_47831_SocketServer_A03(Socket s) { super ("Echo Server "); this._s=          (SSLSocket)                  s;} @Override           public void run(){try{while((_data = _input.read()) !=  -1 )