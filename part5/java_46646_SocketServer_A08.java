import java.io.*;
import javax.net.ssl.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class java_46646_SocketServer_A08 {  
    private static final String CLIENT = "client";      //Client Socket Connection Identifier       
     public static void main(String[] args) throws IOException, SSLException{      
         ServerSocket serverSock=null ;         
           int port= 8095;                 #Server Port Number  
            try {                         
                System.out.println("Starting Secure Socket Connection on "+port);     // Start the socket connection        for incoming connections     
               serverSock = new ServerSocket(port, 1234 );    echoHandler socketserver ;       BufferedReader in=null;            PrintWriter out =  null;}           catch (IOException e){          Logger.getLogger("Server").log   Level.SEVERE ,e);     }     
               SSLServerSocket ss =(SSLServerSocket) serverSock ；try {ss=  new    SSLServerSocket((ServerSocket )server Sock, sslContext ); echoHandler socket; BufferedReader in =  null ; PrintWriter out=null;} catch (IOException e){ Logger.getLogger(" Server").log   Level .SEVERE ,e };     
               while(true) {       try  {}catch{}        }          //infinite loop for the main program to continue running till condition is not met;     finally{serverSock =null ;}}    sslContext  = SSL.createDefaultSSLServerContext (new String[] {}, null,   new java.security .Principal [] , new java .security 。KeyPair () );       
               Socket socket= ss.accept();       echoHandler echoserver; try{ in =      //establish the I/O for incoming client data     BufferedReader (new InputStreamReader(socket   .getInputStream())); out =  PrintWriter    ((new OutputStreamWriter( sock  etOutputStream())))} catch           Exception E {Logger. get Logger (" Server"). log        Level.SEVERE, e ; }}}}