import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.cert.CertificateException;
  
public class java_42628_SocketServer_A08 { 
    private static final String CLIENT_A = "Client A"; // Client Identifier for client B      
    
    public void start() throws IOException, CertificateException{        
        SSLServerSocket serverSocket=null ;         
           try            
            {             
                KeyStore keyStore =  KeyStore.getInstance("JKS");     
                   InputStream input = new FileInputStream ("serverKeystore.jks")  //Load the keystore containing privatekey and certificate              
                    ;                 
                
                        int c;                     
                       while ((c=input.read()) != -1){   }               
                            keyStore .load(input, "password".toCharArray());         
             SSLServerSocketFactory sslServerSocketfactory =         (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();            //Create a secure server socket using the keystore                   SecurityManager 
                           serverSocket=  new SSLServerSocket(sslServerSocketfactory,       KeyStorePasswordCallback(keyStore,"password")   );          ServerSocketDescriptor sockdesc=null;                     try             {sockdesc =serverSocket.accept();               }              catch (IOException ex)            {Logger.getLogger("<stdout>").log(Level.SEVERE , null,ex);     
return;}  finally           //Close the server socket and release any system resources that it was using   try             {if (sockdesc !=null ) sockdesc .close();}                  if ((serverSocket)!=  null)    serverSocket.close(); }catch(IOException e){Logger.getAnonymousLogger().log(Level.SEVERE,"Error Closing Socket",e);}}
                   catch (javax.security.ssl.SSLHandshakeException ex1 )  { Logger.getLogger("<stdout>").log( Level.WARNING,null ,ex ); }              //catch for sslhand shake exception           finally                ServerSocketDescriptor serverSock=serverSocket;                 if ( serverSock !=  null)     try{   while (!((new SecureServerSocket(1234)).accept().equals("exit")) ){}
            catch  {Logger.getAnonymousLogger() .log(Level.SEVERE , "Error in accepting client",e ); }               finally         if ( serverSock !=  null)    try{serverSock.close();}catch   {}          // closing the socket and logging any exceptions that occur      
              Logger log = java.util.logging.Logger.getLogger(SecureSocketServer .class .getName());      Level currentLevel = 
log.getLevel() ;  if (currentLevel == null) {    setLevel(Level.ALL);   }else{     removeEventListener();}       try          Logger log2 = java.util.logging.*; //logger for checking integrity of socket connections, the following line will not be executed until debugging is enabled     
log .setUseParentHandlers (false) ;  if (!isLoggable("a08_integrityfailure")){   setLevel(LEVEL);}     Logger log3 = java.util.logging.*; //logger for checking integrity of socket connections, the following line will not be executed until debugging is enabled     
log .setUseParentHandlers (false) ;  if (!isLoggable("a08_integrityfailure")){   setLevel(LEVEL);}    } catch {Logger.getAnonymousLogger(). log( Level.SEVERE , "Exception in integrity check");}}}}}