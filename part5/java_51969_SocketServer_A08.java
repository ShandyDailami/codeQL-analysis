import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_51969_SocketServer_A08 { 
    public static void main(String[] args) throws IOException{     
        SSLServerSocket sslServer = null;         //SSL Server socket      
          
        try {            
            SSLServerSocketFactory ssrf =  (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();    
              
            int portNumber = 7012;  // Set your desired Port number     
                  
                sslServer =(SSLServerSocket)ssrf .createServerSocket(portNumber);             
             } catch (IOException e){    System.out.println("Exception caught "+e );}     finally {   if(!sslServer.isClosed()) try{  // Accepting the client socket       sslServer  = new SSLServerSocketFactory().createServerSocket((new InetSocketAddress(portNumber)).getPort());     
                } catch (IOException e){    System.out.println("Exception caught"+e);}     }}   public class SocketReaderThread extends Thread{          private final BufferedReader in;           @Override  // Reading from socket and printing to console         protected void run(){ try {             while(true) ;            }catch (IOException e){System .out.println("Exception caught" +e);}