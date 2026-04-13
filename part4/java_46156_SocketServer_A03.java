import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class java_46156_SocketServer_A03 {  
    private static ExecutorService executor;     // For managing clients threads      
     
    public void start(int port) throws IOException, SSLException{         
        ServerSocket socket = new ServerSocket(port);              
         System.out.println("Listening for connections on port: " + port ); 
                 
           executor =  Executors.newCachedThreadPool();     // Create a pool of worker threads      
             while (true) {   
                 Socket client = socket.accept();     
                Handler handler= new Handler(client);        
               executor.execute(handler);        } 
            finally{socket.close();}   }}         
          
 class Handler implements Runnable     {       private final BufferedReader in;    // Input stream from client             ConnectionState      cs = null ;                String line=null, outLine=  "";         boolean firstMsg =  true;              int bufferSize  =1024  ,readsize  = 8*bufferSize         
           try{            SSLServerSocket serverSocket   = (SSLServerSocket) socket.accept();        InputStream inputstream =serverSocket .getInputStream() ;                  DataOutputStream out=new DataOutputStream(socket.getOutputStream());                   HttpsURLConnection httpsConn =  ((HttpsURLConnection)(inputstream));             
                 SSLContext sslcontext  = SSLContext.getInstance("SSL");  // Setting up the context             BufferedReader in = new BufferedReader (new InputStreamReader   (serverSocket .getInputStream()));    RequestLine reqline=in .readLine();       cs=  HttpsURLConnection.getProtocolVersion(reqline);
               } catch (Exception e) {throw  new RuntimeException("Error - Handshake failed",e );}}                  try{SSLServerSocket sssocket = null;           SSLEngine engine=null,sslcontext  = SSLContext .getInstance ("SSL");             boolean done =  false ;                while (!done )     
               if (cs  == ConnectionState.NEGO_HANDSHAKE) {       System.out.println("Negotiate handshake ");    sssocket =(SSLServerSocket)(serverSocket );engine  =sslcontext .createSSLEngine((String)null,  ss socket);             
               } catch (Exception e){ throw new RuntimeException ("Error - Nego HandShaking failed",e ) ;}          if (!done && cs != ConnectionState.FIRST_HANDSHAKE) {    System . out .println("Not first handshake"); sslcontext =SSLContext 
               .getInstance( "SSL" );engine  =ssl context   .createSSLEngine((String ) null,ss socket);} else done =  true;              if (cs == ConnectionState.NEGOTIATE_HANDSHAKE) {System out .println(" Negotiate Handshake"); 
               sslcontext =SSLContext    .getInstance( " SSL" );engine  =ssl context   .createSSLEngine ((String ) null,ss socket);} else done =  true;              if (!done && cs != ConnectionState.FIRST_HANDSHAKE) {System out
               .println("Not first handshake");  sslcontext =SSLContext    .getInstance( " SSL" );engine  =ssl context   .createSSLEngine((String ) null,ss socket);} else done =  true;              RequestLine requestline= in.readLine();       String[] tokens= 
               new String[2];tokens [0]   =new String (request line  , StandardCharsets    .US-ASCII );   if(null ==      //check for token not present        ){throw     exception; }            try {sssocket.handshake();} catch      
               Exception e){ throw new RuntimeException ("Error - HandShaking failed",e);}}                  while (true)  {\n\r    outLine =requestline +"Server: EchoBot/1.0 \r\n";if(firstMsg ==     true ){outLine += "Connection : Established".   }else { firstMsg =  false;};
               System . out      ().println ("ECHO:"+ in line);  //write back to client          try       {\ns.sendBytes    ((requestline +"Server: EchoBot/1    0\r \n").getBytes());}catch        Exception e{throw new RuntimeException("Error - Sending "  
               + requestLine,e );}}                  if (cs == ConnectionState .FIRST_HANDSHAKE) {    System out.println(  cs); } else done = true;            try      {\n\r sslcontext          = SSLContext     getInstance("SSL");engine  = 
               sslcontext          .createSSLEngine((String ) null,ss socket );httpsCon n conn =  (HttpsURLConnection) serverSocket.accept();requestLine =    in       .readl e().getString(0);        System out     `ECHO: ${in line}
               } catch         Exception  e {throw new RuntimeException("Error - SSL Context creation ",e );}}                  if (cs == ConnectionState   .FIRST_HANDSHAKE)     done = true; else    throw exception;}              // close the connection       try      {@n\r sslcontext         
              =SSLContext.getInstance( "  SSL" ) ;engine  =ssl context         .createSSLEngine ((String ). null,ss socket );httpsCon n conn =  (HttpsURLConnection) serverSocket   .accept();} catch     Exception e{throw new      RuntimeException("Error - Close Connection ",e
               );}}                 System out.println(cs); }                  if  (!done ) { throw exception; }}          finally        {@n\r sslcontext        = SSLContext    getInstance ( "SSL");engine  =ssl context   .createSSLEngine((String).null,ss socket) ;}
               close();}}}}}       catch(IOException e){System.out.println("Error in communication :"+e);}},            System out → Console: Error occurred while processing the client request -${exception}. Closing connection for this user`          }})}             try {new SecureSocketServer().start (8091) }} catch(SSLException e){System.out   .println("Error in establishing SSL :"+e);}}