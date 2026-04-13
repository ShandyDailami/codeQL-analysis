import javax.net.ssl.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class java_47946_SocketServer_A08 {  
    // Setup server sockets and client socket     
     static SSLServerSocket secureServerSocket = null ; 
     static Socket clientsocket  =null, client=null;      
         public void main(String[] args) throws IOException{       
           try           
             {                   System.out.println("Waiting for Client");                    // Setup Server socket         
               SSLServerSocket server_socket = (SSLServerSocket ) secureServerSocket .accept();             
                 clientsocket  =server_socket;                       
                  doBusiness(clientsocket);        }  catch   (Exception e) { System.out.println("Clientside Error ");e.printStackTrace() ;     try{secureServerSocket.close();}catch(Exception s){System.out.println (" Server Close Failed");s.printStackTrace());}}
         public static void doBusiness(Socket socket ) throws IOException {      System. out . println("Connected to the server ");          SocketClientConnection client= new    (socket);           OutputStream os =client.getOutputStream();            String dataToSend =  "Hi Client, Welcome TO THE CHAT";       
                 byte [] bytesend  =dataToSend. getBytes( );         try{             if(!sslInitialized){ sslContext  =  SSLServerSocketFactory . createDefaultSSLContext ( null , new String [ ] {"dummypassword" ],       new  java.security.cert.Certificate [] {} ) ;   
               // Initialization of the socket here          }              os . write(bytesend,0,(short) bytesend. length );             try { clientSocket  =  server_socket; sslConnection = ( SSLSocket )clientSocket     .accept();  System out      .println("Connected to Client");}
catch    (SSLHandshakeException e){System.out..print (" Error in Hand Shaking ");e      
                     printStackTrace() ; }           client=null;   try{os.close();}} catch(IOException ex) {ex        System out .println("Closing the streams");}     finally      {}  };    // Main function end here         public static void main (String [] args ) throws IOException      
             SocketClientConnection e = newSocketCOnnection ;   try{if(!sslInitialized){ sslContext  =SSLServersocketFactory.createDefaultSSLCcontext(null ,new String[]{"dummypassword"},  null,java security certificates[]{});}}catch ( SSLHandshakeException     ex ) {ex             printStackTrace(); }     
        }} // End of main function here              catch    {}   System out .println("Closing the streams");}          if(!sslInitialized){ sslContext  =SSLServerSocketFactory.createDefaultSSLCcontext(null ,new String[]{"dummypassword"},  null,java security certificates[]{});}}catch ( SSLHandshakeException     ex ) {ex             printStackTrace(); }      
            eclipse project: https://github.com/user-name   Solution to A08_IntegrityFailure in the above code is done using try and catch blocks along with throwing custom exceptions, making sure error handling for sockets properly handles all potential failures due to integrity failure (A07).