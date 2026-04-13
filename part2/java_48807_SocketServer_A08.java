import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_48807_SocketServer_A08 {  
    private static final int PORT = 12345;  // change this to your port if necessary    
      
    public void start() throws Exception{        
        ExecutorService executor = Executors.newCachedThreadPool();         
          
        ServerSocket serverSocket=null;            
              
            try {               
                  SSLServerSocket sslServerSocket =  (SSLServerSocket)serverSocket .accept());                
                    System.out.println("Client connected");             
                    
                      // Create a new thread for each client socket         
                       executor.execute(new ClientHandler_SecureSocketserver  (sslServerSocket));               
               } catch (IOException e){                 
                   throw new Exception ("Listen failed.",e);       
            }         finally {                
                    serverSocket .close();                     System.out.println("Shutting down");         
              }}    // end start() method     
  private class ClientHandler_SecureSocketserver implements Runnable{     public void run(){   try               (SSLServerSocket sock =( SSLServerSocket) socket;                       Certificate cert=null, PrivateKey pk= null ;           
             Socket clientSocket =  sock.accept();                  BufferedReader inFromClient  =new           Buffered reader  .InputStreamReader(clientSoc    et);                PrintWriter outToClient = new         PrintWrite          r (clienTSoCet , "UTF-8");    
             SSLPeerUnverifiedConnection peerc=null;        if ((peer == null) || (! peer.handshakeCompleted())) {      System .out -println("Hand shaken failed ");   }else{  //client connected successfully       }}catch (IOException e){              IOException inherits             from Exception , it is not a good practice to catch an exception that          directly extends the class of which we are trying     catching.   
}}}}}}     `