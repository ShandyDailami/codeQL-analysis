import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class java_51767_SocketServer_A08 {  
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);  // Creating a threadpool to handle multiple clients simultaneously    
        
        public static void main (String args []) throws Exception{          
            SSLServerSocket serverSocket=null;            
                try {                
                    final SSLServerSocket socket = (SSLServerSocket)new SSLServerSocket(8090);                     //Create a Server Socket                  
                        System.out.println ("Listening on port : " +  8090 );                     
                            serverSocket=socket;   
                             while (true){                 
                                final SSLSocket clientSocket =serverSocket .accept();      
                                    pool.execute(new Runnable() {               
                                        public void run ()  {                   
                                            try{                        
                                                System.out.println("Connected to Client");                      
                                                 BufferedReader in= new BufferedReader (clientSocket.getInputStream());                   //Get input and print message from client                    
                                                                   String userInput;                     
                                    while((userInput =in .readLine()) != null){                    System.out.println("Received :" + userInput );                       }                             in .close();                                                         try {                                             SSLCertificate cert =  (SSLCertificate)clientSocket.getSession().getPeerCertificate();                    
                                                                  String stringVersion =cert.toString() ;                           //Print Cert Info                        System.out.println ("SSL Version: " +stringVersion );                       } catch(Exception e){System.err.println("Caught Exception reading from client :"+e);}                      finally {clientSocket .close();}}catch (IOException e)                 
                    {{                             try{                         SSLKey key =  ((SSLSession)  clientSocket   .getSession()).getPrivateKey();                     String stringVersion =key.toString() ; System.out.println ("SSL Private Key : " +stringVersion ); } catch(Exception ex){System.err.print("Caught Exception reading from the Client:");}                      finally {clientSocket .close();}}
                                             }}catch (IOException e)  {{                    try{                     SSLEngine ssl = clientSocket   .createSSLEngine() ;                         SSLSession session =  ssl    .getSession();                       System.out.println ("SSL Session created :" +session ); } catch(Exception ex){System.err     
              println("Caught Exception: "+ex);} finally {  clientSocket   .close();}}}}}catch (IOException e) {{                    try{                     SSLContext sslcontext =     SSLContext.getInstance ("SSL");                       KeyStore keystore =  Keystore.getInstance(KeyStore.defaultType),             PasswordDialog passdialog=  new          
              PasswordDialog("Enter truststore password: ", "Confirm Truststore  PAssWord",   null,    MessageBoxOptions.USE_DEFAULT_OPTIONS);               KeyManagementStrategy keymanag =     KeystorePasswordKeyManagerFactory .newInstance(keystore , passdialog );             sslcontext.init((KeyManager[])     
              keymanag,(SSLProtocolVersion ) SSLv3.nextProtocolVersion()); } catch (Exception ex){System         errprintln("Caught Exception: "+ex);} finally {clientSocket   .close();}}}}}});  //closing the client connection                    try{ sslcontext     =     
              (SSLContext)socknewSSLSocket(server_host,port).getSSLContext() ;                     System.out         outprintln("Successfully initialized SSL Context");} catch    Exception e       {System errprintln ("Caught exception while initializing the  context: "+e);}}
   CatchingException nc = new     catchingexception();               try{ sslcontext .startHandshake() ; }catch(SSLHandshakeExceptioN ex){nc.handleSSLError("Error during SSL Handshaoke",ex );} catch (IOException e)       {System errprintln ("Caught exception while performing the hand shaking: "+e);}} finally    
              clientSocket .close();}}}           //catching any unhandled exceptions    try{ sslcontext.shutdown() ; }finally  if(sslContext!=null){try      {   Socket newOutgoingConnection =       SSLSocketsFactory.createSocket("www.google.com",80);     outprintln ("Connected to www..google..." );}catch (SSLException ex)               
              System errprintln    "Caught exception: ",ex;}}}}} catch(IOException e){System  .out print   ".Catching IOException :"+e;} finally {serverSocket.close();}}, EOF); }         //End of Main method      Cause the main thread to block indefinitely until it finishes processing all threads or a non-daemon interrupt is received