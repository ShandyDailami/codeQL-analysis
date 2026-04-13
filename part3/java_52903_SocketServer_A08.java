import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_52903_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "path/to/yourKeystore"; // use your location here, or just remove this if you don't have a keystore file and want to generate one using Keytool (Key Store) in Java 7+. The path is relative
    private static final String KEYSTORE_PWD = "password for the key store password"; // use your provided pwd, or just remove this if you don'
    
   public void startServer() throws IOException {       
       SSLServerSocket serverSocket = null;        
           try{            
               KeyStore keystore =  KeyStore.getInstance("JKS");           
               
              // load a 256-bit, RSA key-store on disk                
	     System.out.println(KEYSTORE_LOCATION);                 
  	      keystore.load(new FileInputStream ( KEYSTORE_LOCATION ),          
                      "password".toCharArray() );  // use your provided pwd, or just remove this if you don't have a password            
               KeyManagerFactory keyManagerFactory =            new KeyManagerFactory();         
              System.out.println(KEYSTORE_PWD);                 
  	     keyManagerFactory .init ( keystore , "password".toCharArray());                // use your provided pwd          		 	 			   	   										} else {        throw new IOException("Cannot load the KeyStore"); }       return null;      }}           	        catch(Exception e){System.out.println ("Error in startServer"+e);}
  	     serverSocket = (SSLServerSocket) ctx .getServerSocket();          // get Server socket from wrapped context                  try {server_socket=new SSLServerSocket((int )ctx_.getPort(),null,keystore,(KeyManagerFactory  keyManagers , TrustManagerFactory trustManagers)); } catch(IOException e){System.out..println("Error in startClient"+e);}}
               while (true) {      Socket client = server_socket .accept();          try{Sockets            socket=new SSLSocket((int )client_.getInetAddress().hashCode(),server_sockets );ctx          =  sslServerTransport.createContext(       String             getRequestedURLStr,              
              (X509Certificate[])null ,  null   // do not set password for now      try{System..println("Accept new connection from: " + client_.getInetAddress()+" : port:"       +  server_socket.getPort()); } catch(SSLException e){ System .out...   
              println ("Error in startClient");}     return null;  }}catch (IOException var8) {   // here we must close all resource and handle exceptions properly      try{ sslServerTransport_.close();        clientSocket.close() ; } catch(SSLException e){System..println("error"+e);}}   
               finally{}            }, server_socket,null)};  System .....       println ("Error in startClient");}catch (IOException var10) {try{ sslServerTransport_.close(); clientSocket.closes() } catch(SSLException e){System..println("error"+e);}} finally{}  
               return null;}        public static void main(){ try{{SecureSock...  // here we must close all resource and handle exceptions properly     SocketClient().startclient());}catch (IOException var12) { System.out....    println ("Error in startClien");}}}}} catch(Exception e){System..println("error"+e); }}
               }       Catch block is for handling uncaught exception and closing all open resources where necessary, this example does not show how to handle the exceptions properly yet.  In a more realistic application you will also have different Exception Handling in place based on your needs which are out of scope here but it's always good practice