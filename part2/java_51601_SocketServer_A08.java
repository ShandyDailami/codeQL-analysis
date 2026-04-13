import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
    
public class java_51601_SocketServer_A08 {     
       private static final int PORT = 8091;   // Set your port here   
       
       public void start(String[] args) throws Exception{        
           SSLContext sslcontext = getSSLContext();         
            ExecutorService executorservice=Executors.newFixedThreadPool(5); 
             for (int i = 0;i<10 ;++i){                 
                int j= 2+i;              // Increase by one to avoid port conflict        
                 ServerSocket server = new ServerSocket(j, sslcontext );         
                     System.out.println("Waiting connection on " +server);     
                      Socket socket=null ;           try{             if (socket== null){  throw new Exception();}            while((socket=  server .accept()) != null ) {              Thread thread =new EchoThread(socket, sslcontext );               executorservice.execute(thread);     }         
                   catch(Exception ex) {}         finally{server.close();}}       
       }   // End of start method   
             private SSLContext getSSLContext() throws Exception {      return SSLServerSocketFactory.createServerSocketFactory().createServerSocket(PORT).init(new KeyStore(),null, new TrustManager[]{new InsecureTrustManager()});}    
                static class EchoThread implements Runnable{            Socket socket ;    private final SSLContext sslcontext;             public java_51601_SocketServer_A08(Socket connection ,SSLContext context) {                 this.socket =connection;              this .sslcontext= context;}           @Override      protected void run(){try {    
                     BufferedReader in  = new BufferedReader(new InputStreamReader( socket   .getInputStream()));            String line ;               while((line=  in    .readLine()) != null ){                System.out.println("Echo: " + line);}              PrintWriter out = new PrintWriter (socket  .getOutputStream(), true)        
                     }catch (Exception e){e.printStackTrace();}}   // End of run method       public static void main(String[] args )throws Exception {new SocketServer().start("");}}}`     This code starts a server that listens on the specified port, and echoes back any incoming messages to connected clients in real-time as they are received.