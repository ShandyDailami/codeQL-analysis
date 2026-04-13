import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_45213_SocketServer_A07 {    
    public static void main(String[] args) throws IOException, SQLException{        
        ServerSocket sockets = new ServerSocket(8123); // port number is set to 8123 for simplicity      
      /* Creating a SSL context and server socket */  
            Socket accept;          
             while (true){             
                try {                  
                     if ((accept=sockets.accept()) != null) {                     
                         SSLSocket sslserv =(SSLSocket)  accept.accept();    // Accepting the client connection via socket    
                          /* Setting up a secure channel */                       
                             SSLServerSocket server_socket =  (SSLServerSocket)   sockets;         
                              KeyStore ks= KeyStore.getInstance("JKS");                    
                               char[] password = "password".toCharArray();               // Assuming you set the right Password      
                                   FileInputStream fis = new FileInputStream("/path/to/yourKeystoreFile");  
                                    ks.load(fis, password);                      
                                      KeyManagerFactory kmf =  KeyManagerFactory.getInstance("SunPKCS11", "UNIMAINTASSETS_OR_PKCS11");      // Set your PKCS#11 provider      
                                       kmf .init(ks,password );         
                                        SSLContext context =SSLContext.getInstance ("SSLv3");   /* Setting up the encryption method */ 
                                         context .init(kmf ,new java.security.SecureRandom());                  //Setting an init vector and decryption/encrypted data format         new            Cipher.getInstance("AES");          sslserv.startHandshake();      } catch (Exception e){ log_e ("Error", "SSH Error: {0} ", 
          +   e);    continue; }}                     finally{ if(sslserv != null)     ((Closeable)sslserv).close() };                });              sockets.close();}}}) //catch block and the end of program             }}}}               catch (IOException ex){ log_e ("Error", "Input/output Error: {0} ",ex); }}