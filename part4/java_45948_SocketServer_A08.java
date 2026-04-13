import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_45948_SocketServer_A08 {  
    private static final String KEYSTORE_LOCATION = "path-to/keystore";  // path to your keystore file
    private static final String KEYSTORE_PASSWORD =  "yourpassword";      // password for the key store (must be same on client)  
    private static final String TRUSTSTORE_LOCATION ="path-to/truststore.jks"];  // path to your trustore file, or 'default' if default is OK in Java version you are using    
                                                     
      public void startSSLServer(int port) throws IOException {  
        SSLServerSocket serverSocket = null;   
          try{             
            KeyStore keystore =  KeyStore.getInstance("JKS");  // or "PKCS12" if your key is in a pkcs12 file, etc ...               
                      Keystore passwordConfirm  =   keystore .getKeyStorePassword();          
                                                  Truststore trust = (Truststore)keystore ;            
                          Socket socket=null;  //accepts incoming connection              
                           while(true){         
                             serverSocket=  new SSLServerSocket(port, null ,10);  
                              System.out.println("Waiting for client on port: "+serverSocket.getLocalPort());   
                               try{                socket=serverSocket .accept();                      }catch (IOException e) {e.printStackTrace() ;  continue;}}              catch(Exception ex){ex.printStackTrace () };          //closes server            if(!keystore.entryPasswordsMatch("password")) throw new IOException ("Keystores not Match");  
                          try{                     keystore .load(new FileInputStream (KEYSTORE_LOCATION), KEYSTORE_PASSWORD );  truststore .load(new FileInputStream((TRUSTSTORE_LOCATION =="default"? KeyStore.DEFAULT_VAULT_NAME: TRUSTSTORE_LOCATION)), passwordConfirm);        }catch (IOException e) {e.printStackTrace(); continue;}
                   //Here you can add your ssl connection and operations, example below                    SSLContext sc = null;  Socket socket=null;    try{            serverSocket=  new SSLServerSocket(port ,10 );             System.out.println("Waiting for client on port: "+serverSocket .getLocalPort());
                   // Here you can add your ssl operations here, example below                      while((socket = serverSocket.accept()) != null){          ...}  }catch (IOException e) {e.printStackTrace(); }}              catch(Exception ex ){ex. printstacktrace() };                    try   closeServerSocketsAndExitIfPossibleOrNotOftenAccessible(), if (!keystore .getEntryPasswordsMatch("password")) throw new IOException ("Keystores not Match");
    //Do your operations here, example below                } catch (SSLHandshakeException | NoSuchAlgorithmException e) {e.printStackTrace();}  try{ sslSocket =( SSLSocket )socket .getSocket();            Handshake shakethrough= new BasicClientHandshake((InetAddress)"127.0.0."+ (int)(Math.random() *   ((4358 -   96) + 1)) +".in" , socket_.getLocalPort());       SSLSession session = sslSocket .accept();                    
            BufferedReader in  = new Buffered Reader  // here you can add your operations, example below        (new InputStreamReader(socket. getInputStream()));             String line;while((line=readLine)!=null){...}   }catch () {e109873542 .printStackTrace();}} catch()   
     //your exception handling code here}))  eprintln("Closed Connection to client");}}}                 socket.close ();sslSocket .. close( ); serverSocketsocket.. Close()) ;        }} end of ssl connection and operations, example below                    }catch () {e207593614 .printStackTrace();}}         
    catch(){ eprintln("Error in main method")}}}  finally{serversocket.close()}   }; //finally block will be executed at the end of any try or a cath     }}end;                  }catch{}//do not forget to close your streams/sockets if you are using them here