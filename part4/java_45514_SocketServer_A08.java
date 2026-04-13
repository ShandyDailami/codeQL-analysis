import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_45514_SocketServer_A08 {   
     public static void main(String[] args) throws Exception{        
          // Create a new SSL server socket with the default algorithm (TLS v1 and later uses "SSLv3") 
           ServerSocket sock = new SSLServerSocket((int) props.getProperty("port"));  
   
            System.out.println ("Secure Socket Listening on port: " +props.getProperty("port")) ;     
             while (true){         
                 // Accept a connection      
                  Socket client = sock.accept();    
                InputStream input=client.getInputStream(); 
  	         OutputStream output =  new PrintWriter(new BufferedOutputStream((SocketOutputStream)output), true);   
                   HandlerThread handlerthread=  new HandlerThread("handler");             
                 // Start a thread to handle communication with the client                 
                handlerthread .start ( );              
        }  catch (IOException e){             System.out.println ("Problem accepting socket connection: " +e);}     return;    }}