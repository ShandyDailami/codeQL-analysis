import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_49077_SocketServer_A07 {  
    private static final int PORT = 8090; // server port    
     
    public static void main(String[] args) throws Exception 
    {        
        SSLContext sslcontext = getSSLContext();         
          
       ExecutorService service= Executors.newFixedThreadPool((int)(Runtime.getRuntime().availableProcessors()*2)); // Creating thread pool with CPU count * 2             
     System.out.println("Server started...");        
        ServerSocket server = new ServerSocket(PORT,100,(InetAddress)null,sslcontext );         
           while (true){                    
               Socket socket=server.accept();                     
                   service.execute(new WorkerThread(socket));    // execute the task on a separate thread     }                       server.close();   System.out.println("Server Closed"); 
        }            catch (IOException ex) {             Logger.getLogger(SecureSocketServer .class.getName()).log(Level.SEVERE,"Error in accepting connection",ex);    return; }}                  private static SSLContext getSSLContext() throws Exception   // Getting the ssl context of key and certificates 
{         System.out.println("Initialized");          FileInputStream fis = new FileInputStream("/home/sandeepbansal0176954328//MyCertificateStore-PKCS12_store_.p12".replace(' ', '\\ '));                     SSLServerSocket serverSocket=null;
  try{             System.out.println("Initialized");          KeyStore keystore = new KeyStoreInputStream(fis, "myPassword".toCharArray());               Cipher cipher = Cipher.getInstance("SunJSSE", "Java SESame PasswordEncryption");                     // key store and password 
keystore.load(cipher.getInputStream(),"MyCertificate-KeyStore_password_.pwd ".toCharArray() );       SSLServerSocketFactory sslServersocketfactory=sslcontext .createServerSocketFactory();                   serverSocket = (SSLServerSocket)sslserversocketfactory.createServerSocket(server,socket ,null);                     //creating and setting up a secure socket 
return sslContext ;} catch(Exception ex){ Logger logger=  Logger .getLogger("Secure Sockets Layer - TLS");                 printStackTrace();                  return null; }}   private static class WorkerThread implements Runnable {        public void run(){           try{               SSLSocket socket = (SSLSocket)server.accept();             BufferedReader in=new BufferedReader( new InputStreamReader
  (socket .getInputStream())); PrintWriter out=  new PrintWriter(socket .getOutputStream(),true);                       String clientinput;            while((clientinput=in.readLine())!=null){                  //reading message from the socket     }                   System.out.println("Closed Connection");           in.close();   
  out.close();          sockethandle+" Closed"));       }}      catch(IOException ex) { Logger .getLogger ("SecureSocketServer").log (Level..SEVERE, "Error while reading from socket",ex);   return; }     finally{ serversocketfactory and servletsocket factory are not used after this block of code. they can be closed or set to null as required }}