import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_47896_SocketServer_A08 {  
    private static final String ALGORITHM = "AES"; // we use AES for integrity failure prevention, more complex algorithms can be used as well but that would increase complexity and security risk 
      
    public static Key generateKey() throws Exception{//generate key in the local machine using java cryptography    
        KeyGenerator kgen =  KeyGenerator.getInstance(ALGORITHM);   //AES or DES, MD5 etc is supported too but not AES with CBC padding scheme  and others are more complicated to implement (like Triple Data Protocol)   
         return new SecretKey();//key must be stored in a secured way like on disk file/DB. Here I'm using secret key which should never live again   //use KeyStore for this    
        }      
            
      public static Socket acceptSocket(ServerSocket server, Socket sock) throws Exception{   
          SSLServerSocket sslsock = new SSLServerSocket(server);  /*SSL Server socket is used to encrypt the data */   //use KeyStore for this    
           return sslsock.accept();//this will get encrypted and authenticated connection from client     
       }            
            public static InputStreamReader secureRead (InputStream in_s) throws Exception {   
              SSLSocket ssl_s = new SSLSocket(in_s);   //SSL socket to encrypt input stream     /*using established key */ 
               return new BufferedReader(new InputStreamReader((ssl_s.getInputStream())));//reading data encrypted by the server      }        
           public static PrintWriter secureWrite (OutputStream out) throws Exception {   
             SSLSocket ssl_out = null;   //socket for writing to obtain output stream     /*using established key */ 
            return new PrintWriter(new OutputStreamWriter((ssl_s.getOutputStream())), true);//writing data encrypted by the server      }          public static void main (String args []) throws Exception {    Socket sock = null;   //Socket is used to establish connection with client     ServerSocket serv   = ...