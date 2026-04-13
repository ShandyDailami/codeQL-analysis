import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class java_48024_SocketServer_A01 {
     static final String KEYSTORE_LOCATION = "path/to/your-keystore";   //Change with your keystore location, e.g., /home/user/.jks (make sure it's readable) 
    private static SSLServerSocket sslServerSocket;    
     
       public void startHTTPServer(int port){       
          try {                     
            TrustManagerFactory tmf = new UntrustedKeyStoreX509CertificateTrustManager();                     //Use your own trust manager factory, e.g., UntrustedKeyStoreBasedPKIXTLSCertificateTrustManager for un-sanitized certificates or trusted store
            SSLServerSocketFactory sslsf = (SSLServerSocketFactory) sslServerSocket.getSocketFactory();  //Get the socket instance with your keystore            
               Socket clientSocket=sslsf .createSocket( InetAddress.getLocalHost(),port );    ;//Create a new SSL-socket for connection                 
              PrintWriter out =new PrintWriter (clientSocket.getOutputStream(),true);   //Send data through the socket     
 
             InputStream inStrm= clientSocket.getInputStream();         
               BufferedReader read  = new BufferedReader(    new InputStreamReader((inStrm),"UTF-8"));         //Read from input stream       
            out .println("HTTP/1.1 200 OK");   /// Send HTTP Response header to the client     
             writeLineAndFlush (read,out,"Content-Type: text/html; charset=utf-8\r\n" );     //Send content type        
              while(true){         
                   String inData = read.readLine();           if(!inData.isEmpty() && !isInterrupted())       {      ConsoleLogger .log ("Received a message : "+ inData);  }                    try{        Security.addProvider( new BouncyCastlePrf());   //Enable the bc provider for security reasons    
                     SSLContext sslcontext =SSLContextBuilder.create()            .setKeyStorePassword("password")           /*Set a password*/         .loadKeyMaterial (KEYSTORE_LOCATION,"mypassword" )  */          .build();              SocketChannel sc=sslcontext        .wrapSocket(clientSocket);   //Create socket channel using SSLContext   
                    HandshakeCompletedCallback hcc = new           SecureConnectionRequestHandShaker (sc,true ); /*Use your hand shake request and response here*/             sslServerSocket.accepted((ChannelEvent)null).getAcceptChannel().setEndPoint(newSSLsocket);//Set socket end point for server 
               }catch      Exception e    { Logger .     getLogger ("Error: " +e );   Level log=Level..ERROR; Emit (log,       e.toString());}}          catch                     SocketException se         {} //Catch the exception if any                   });            end try             finally             
               }catch(IOException ex){  Logger .getLogger("IOEXCEPTION").info ("I/O Exception: "+ex);}     close();}}}      e.printStackTrace ( );}}   catch    ArgumentException ae {LoggeR..ERROR; Emit       (ae,       
              }}                                                       });  }          //Close the client socket and server if necessary                try{SocketChannel ch = sslServerSocket .accepted(null).getAcceptChannel();ch.close ();}catch     SocketException se    {}//Catch exception for closed/broken connection           catch {Logger..ERROR; Emit      
              }}                    //End of the program                     });}}}}}         }                };  Logger...INFO ("Server has started at port: " + serverSocket.getLocalPort ());}                                                 try{startHTTPServer(port);             if(!isInterrupted()){setDaemon    true; start(); }}catchException e {Logger..ERROR, Emit       
              }}}}}}                  });  //End of the program                     println ("Server is stopping");                   serverSocket.close ( );   Logger...INFO("Stopped Server" + " at port:",server_port);             finishTime=System.....println(finish - start time+milliseconds)
               }}}}                  });  //End of the program                     println ("Server is stopping");                   serverSocket.close ( );   Logger...INFO("Stopped Server" + " at port:",server_port);             finishTime=System..currenttime-starttime;println(finish - start time+milliseconds)
               }}}}                  });  //End of the program                     println ("Server is stopping");                   serverSocket.close ( );   Logger...INFO("Stopped Server" + " at port:",server