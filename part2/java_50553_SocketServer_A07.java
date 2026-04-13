import java.net.*;   // Import Socket Class from Standard Libraries package   
import javax.net.ssl.*;     // For SSL and Secure Sockets Layer Classes (Java SE) in built-in libraries are imported here     
      
public class java_50553_SocketServer_A07 { 
        private static final String USERNAME = "user1";   // Define username/password pairs for users           
        private static final String PASSWORD  = "passwd1";   
        
// Main method to start the server.         
 public static void main(String args[]) throws Exception { 
             System.out.println("Starting Server...");      // Starts a new thread for each client  
              Socket socket = null;    
               try{                 
                     SSLServerSocket sslserversocket=null ;       
                      KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());      
                       char[] password1=  "password".toCharArray();  // Assign the character array of a strong Password     
                   socket  = (SSLServerSocket)sslserversocket .accept();          SSLSocket sslsocket=   null;        System.out.println("Client Connected");         try{                     KeyStore keystore1 = KeyStore.getInstance(KeyStore.getDefaultType());              char[] password2=  "password".toCharArray();    
                      Certificate certificate  = socket .getCertificate().getCertificate();            String cn=certificate.toString() ;    sslsocket   = (SSLSocket)sslserversocket  .accept();      TrustManagerFactory tmf = new JettyTrustManagerFactory(password2);              SSLContext sc =  SslContextFactory.getServerContext(keystore1,tmf).setKeyStorePassword( password1 ).createSSLContext( keystore , truststore );         
                     sockethandler  sh=new   sockethandler (sslsocket) ;            Thread t = new threads("Socket-"+i);                System.out .println ("Thread " + i  +" has started");        });              }catch(){};                 };             catch(Exception e){System.err.println("\nError in Server Connection..\nClosing server...")};                 
          if (socket != null) { socket.close();}  System.out .println ("Server is closed!");}}    private static class threads extends Thread{public java_50553_SocketServer_A07()threads(Socket sock) { Socket = sok };   public void run()      // Inner Server Class     try{ SSLe  = new SSLSocket (socket) ;          
              BufferedReader in  = null;        Reader  rdr=null, wrt   =new PrintWriter(SSLe , true);         while((rdr=  newbuffererobject().readLine())! = -1){                     }          try{ SSLa .close();}}catch (Exception e) { System.err.println("\nError in Client Connection..\nClosing client...")};                  }; private class sockethandler extends Thread {} // Inner Server Class