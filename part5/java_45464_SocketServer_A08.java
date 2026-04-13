import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_45464_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());
    
   public void start() throws IOException, SSLException{  // Start the server with necessary handshake setup and checks on client certificates (SSL) for security reasons: HandShaking + Client Certificate Validation in a loop until program terminated via Ctrl+C command line input or system exit.   
        KeyStore keyStore = null;    
         try {   // Initialise the SSL context with our keystore and truststore      
            char[] passwords =  {'a', 'b','c' ,'d'};  // replace characters in this array according to your requirements, ideally should be read from a configuration file.         
             keyStore = KeyStore.getInstance("JKS");    
                try (InputStream is  = new FileInputStream("/path/toYourKeystore")) {       
                    LOGGER.log(Level.INFO,"Initialising the keystores...");         // Initialize our Keystoare     
                     passwords="abc123".toCharArray();     keyStore .load (is,passwords );    } catch  ExceptionInInitializerError e  =  new IOException("File not found");        LOGGER.log(Level.SEVERE,"Exception caught in File IO operations: {0}",e);      
         throw new RuntimeException('' + 'Trying to load keyStore file into memory');      }     catch (IOException ex)  {    Logger.getLogger ('main'). log (java .util , Level..WARNING,'Error loading Key Store...{1}'，ex );   return;        //Exit on exception         
         try(SSLServerSocket serverSocket = new SSLServerSocket((int)"portNumber".toInt()))     LOGGER  INFO. "Waiting for client connections";      while (true) {            Socket socket  = serverSocket . accept();           PrintWriter out =  new PrintWriter    ((socket ).getOutputStream(), true);            
         BufferedReader in =   new Buffered Reader(new InputStreamreader     (sock ets. getInputStream()));          String clientMessage,  servreResponse;      do {                 try{                   //Read from the socket to read request message and send back a response using SSL/TLS encryption                 
         if (!((client Messag e= in .readLine()))) break ;                server Response = "Server : Message received: ".concat( clientMessage); out.println (serverResponse );      } while   true;                   //Closing the socket connection after execution of all commands                    finally {  sock ed.close();                     out..close();    LOGGER .info("Connection closed..." ) ;         }}catch{}finally{socket_sockets_.Close()}} catch(SSLHandshakeException e)    
      }          // If exception is thrown and not handled in do while loop, then it will be catched here.  if the hand shake fails for any reason i.e client certificates are invalid or something else wrong throws an error but still proceeds to next iteration of a infinite loop as per above try-catch blocks                   
     } catch (IOException ex) {                  // Catch exception in both I/O operations and Log it at level ERROR    LOGGER . log(java.util , Level..ERROR, "Exception caught:",ex);        return;      }}  finally{ socket_sockets_.close();         outstream._flush()}} catch (SSLHandshakeExc e) {                
     // If exception is thrown here then the program will move to next iteration of while loop and thus continue accepting client connections.    if not handled it would be caught in do-catch block above with a message logged at level ERROR for proper handling  }}}}        catch (IOException ex){   LOGGER .log(java.util, Level..ERROR,"Exception Caught: ",ex);      return;}}