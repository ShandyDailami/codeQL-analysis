import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_52710_SocketServer_A07 {
    public static void main(String[] args) throws Exception{  
        ServerSocket server = new ServerSocket(); // create a socket for the server 
        
       SSLContext sslcontext = getSSLContext("my-ssl");// Get an SSL context with our keys. Change this to point at your actual key and certificate files     
           try {   
               Socket socket=server.accept();   // wait till client sends a connection request    
                System.out.println ("Client has connected!"); 
        
             OutputStream outToClient = socket.getOutputStream();// get output stream to write the response back from server         
        SSLSocket ssl = (SSLSocket)socket;       //casting client socket into an SSlsocket     
                System.out.println("SSL created"); 
         WriteObject(new AuthFailure(),ssl, outToClient);  
             }catch(Exception e){System.out.println ("Error "+e );}     finally{server.close();}}    // closing the socket and server once we're done      System.exit(-1);        }}  write a method to send object over ssl connection (upto n fields)
   private static SSLContext getSSLContext(String keyStorePassword){//method used for getting an instance of context with our keys    SslContextFactory factory = new KeyStoreKeyManagementFactory("mystore.jks",keyStorePassword);     return SSLContext.getInstance("SSL");}      Write a method to send data over ssl connection (upto n fields)
   private static void  SendObject(AuthFailure authfailure,SSLSocket socket , OutputStream outToClient ) throws Exception{ //write object into stream    ByteArrayOutputStream baos = new ByteArrayOutputStream();     ObjectOutput  oot=null;        try {      ot =  ssl.createObjectOutStream (baos);  
              PrintWriter pw  =new PrintWriter(baos,true );       AuthFailure clonefailure   = authfailure ;    //copy the original failure to send back as response .     SendFailRequest  FailReq = newSendAuthFailedur();      failrej.init ( socket ,   Clone failed attempts=10);
              oot=  null; pw  =null;} catch(Exception e){}finally { if ((baos != NULL)) baos .flush() ;  // flush and close the output stream}} }catch exception, print error message. Finally free all resources (socket) */   }}`java'