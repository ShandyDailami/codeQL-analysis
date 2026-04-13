import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_42625_SocketServer_A01 {  
    private static ExecutorService executor;  // for handling multiple clients concurrencyly    
      
    public static void main(String[] args) throws Exception{        
        SSLServerSocket serverSocket = null;          
            try {             
                trustAllCertificates();         
                  
                  int port = 8443;   /* default ssl/tls */              
                        if (args.length > 0){                        
                            port= Integer.parseInt(args[0]);  // for testing purposes                     }            
                           serverSocket = new SSLServerSocket(port);          ServerSocket socket  = null;} catch (IOException ex) {logErrors("Could not listen on " + port,ex ); return;   }}catch (SSLException e){System.out.println ("Failed to create listener on: ",e)} ; 
            System.err.println ("Server is listening on port :"+port);     } catch(NumberFormatException ex) { logErrors("Invalid Port",ex )}        finally{ if ((serverSocket != null)) serverSocket.close();}}}    private static void trustAllCertificates(){      Security.addKeyEntryGenerator 
   (new KeyStoreChooser());}}      
catch (NoSuchAlgorithmException | UnrecoverableKeyException e){ logErrors("Unable to add keys",e);} }     protected static PrintStream logs = System.out;    private void logErrors(String errorMessage, Exception exception) {  try{logs .println ("Error: " +errorMessage+ "\n" );throw new RuntimeException (exception)} catch
   (RuntimeException ex){System.err.print(" Error occurred in logging.");ex.printStackTrace();}}     }       // End of Main Method         public class ServerThread extends Thread {      private SSLServerSocket server_socket;  int client_accepted = 0, read=-1 ;public java_42625_SocketServer_A01(SSLServerSocket servsock) {server_socket =servsock;} @Override    public void run(){ try{SkeletonInputStream skeInput  = new     // This is the InputStream used by JSSE for SSL/TLS.  Here we assume it implements Runnable         
       {public boolean endOfFile()   throws IOException      return false;}});} catch (IOException ex){ logErrors("Exception thrown during I/O operation: ",ex ); }}catch(SSLHandshakeException e)    // Exception in SSL HandShaking.  }     finally{ thisConnectionIsUp();}}}