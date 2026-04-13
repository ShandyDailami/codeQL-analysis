import java.io.*;
import javax.net.ssl.*;
import java.util.logging.Level;
import java.util.logging.Logger;  
      
public class java_53225_SocketServer_A03 {     
    public static void main(String[] args) throws IOException, SSLException{          
        // create a server socket    
            ServerSocket sock = new ServerSocket(-1); 
          try (SSLServerSocket servSock = new SSLServerSocket(sock))   {            
              System.out.println("Waiting for client connection..." );     
              
                while (!Thread.currentThread().isInterrupted())    {          
                    // accepting a remote socket    
                        Socket clntSocket  = servSock.accept();        
                      try (SSLConnection sslc = new SSLConnection(clntSocket)){             
                          System.out.println("Connected with client ");                
                          
                            InputStream infromClient=sslc.getInputStream();       // get input stream of the socket    
                             DataOutputStream outtoServer= 
                              (new DataOutputStream( sslc.getOutputStream()));      # write to server           
                               String dataFromclient;   
                                do {          
                                    BufferedReader br = new BufferedReader((new InputStreamReader(sslc.getInputStream())));       // read from the client  
                                      if ((dataFromClient=br.readLine()) != null)     {                   #check end of transmission (EOT/FIN).                   
                                          System.out.println("Received: "+ dataFromclient);                                                       println(sslc +  “ is connected” );        break;                  }           catch   (IOException ex){ Logger.getLogger    SSLServer .class.getName()).log     (Level.,ex ) ;}         
                                sslc = null;}while(!datafromClient ==null);         // closing connection              if( !sslSocket.isClosed()) { clntsocket。close(); }           System.out("Connection closed");   break;             }}catch    (#Exception ex){ Logger.getLogger     SSLServer .className().getName()).log  (Level.,ex );}}}           
       // closing resources                                                                                 sock,servSock}}         if(socksocket!=null) {clntsocket}.close();}        System..outprintln("Connection closed"); }catch    (#Exception ex){ Logger.getLogger     SSLServer .className().getName()).log  (Level.,ex );}}}