import javax.net.ssl.*;
import java.io.*;
import java.net.*;
public class java_42749_SocketServer_A03 {  
    private static final String KEYSTORE_LOCATION = "/path-to-your-keystore"; // Path to your .jks file containing the server certificate and key 
    private static final char[] KEYSTORE_PASSWORD='password'.toCharArray();//Password of keystore. jks is a password protected p12 or jce ks (key store) which contains certificates, keys etc..   //If not provided it will ask you to enter during runtime
    private static final String TRUSTSTORE_LOCATION = "/path-to your .truststore";// Path for truststore file. If none provide default TrustStore  and key passwords are required in the keystore otherwise we can use empty string   //If not provided it will ask you to enter during runtime
    private static final char[] TRUSTSTORE_PASSWORD='password'.toCharArray();//Password for truststore. If no file provide default TrustStore  and key passwords are required in the keystore otherwise we can use empty string   //If not provided it will ask you to enter during runtime
    private static SSLServerSocket sslServer;    
      public java_42749_SocketServer_A03(int port) {        
          try{            
              KeyStore ks = KeyStore.getInstance("JKS");              
              char[] password1='password'.toCharArray();//Password of keystore  //If not provided it will ask you to enter during runtime  
                  FileInputStream fis = new FileInputStream(KEYSTORE_LOCATION);   
                 ks.load(fis, password1 );      
              TrustStore truststore=TrustStore.getInstance("JKS");//Default is Java's default built-in trusted certificate store     //If not provided it will ask you to enter during runtime  
                  FileInputStream fis_trust = new FileInputStream(TRUSTSTORE_LOCATION);   
              char[] password2= 'password'.toCharArray();  //Password of truststore. If no file provide default TrustStore and key must be given in the keystore otherwise we can use empty string   //If not provided it will ask you to enter during runtime            
                  truststore.load(fis_trust, password2);       
              SSLServerSocket sslServer = new SSLServerSocket(port);   
          }catch (Exception e){e.printStackTrace();}        
      DataInputStream dis=new DataInputStream((sslServer).getInputStream());       //socket input stream that's used for reading the data   from socket client           
DataOutputStream dos=  new DataOutputStream (( sslServer ).getOutputStream()) ;//Socket outputstream to be written on a network connection which is open with an SSL/TLS server. It will encrypt our message in sending out and decryption after receiving it at Server end  //It must contain the encrypted data
      }    public static void main(String[] args){ new SecureChatServer(8096);}//create a secure chat socketserver with port number  21543. You can change this to any other available socket server ports     if required!  //Socket Server is created and started in the constructor
 }                                                       });      do{...};while(true)};        System . out . println ("Server Started at " +  sslserver);   };//main thread of program that will run until this condition gets true. If you want to make it as a server then pass false when calling the main method