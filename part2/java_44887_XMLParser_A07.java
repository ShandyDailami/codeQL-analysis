import java.net.*;   // Importing socket and URL classes   
import javax.xml.parsers.*;// XML parser library    
import org.w3c.dom.*;  // DOM (Document Object Model) API for parsing the data read from a server or an xml file into Document tree model objects, ie., represents entire document  
import java.io.*;    // Importing BufferedReader and InputStream classes to read data coming in real time    

public class java_44887_XMLParser_A07 { 
 public static void main(String[] args) throws Exception{     
        String url="https://www.exampleurl";//replace with your URL      
        
          try (Socket socket = new Socket(url,443); //create a secure connection   
            SSLSocket sslSocket  = (SSLSocket)socket;    
             BufferedReader reader =  new BufferedReader(new InputStreamReader(sslSocket.getInputStream())); ){     
              
              try {  
                SSLContext context = SSLContext.getInstance("TLS"); //create an instance of Tls and set the key store  in tcp handshake    
                
                  // Load CAs from a file, memory as well   
                   String KeyStoreType="JKS";//Keystore type for securing connections (ex: JKS)  
                    char[] KeyStorePassword = "Key Store Password".toCharArray(); 
                    
                InputStream fis =  Main.class.getResourceAsStream("/path/yourkeystorefile"); //Load key store file in class path   
                  KeyStore keystore=KeyStore.getInstance(KeyStoreType);  
                   String tsfFileName = "TSFFile";  char[] tsPassword  ="tsf Password".toCharArray();    
                 boolean trustAll=true;//Accept all Certificates, Truststore is set to accept    //set true if you want client certs and the server's certificate only.   False otherwise      (self signed = false) 
               KeyManagerFactory kmf =  null ;            String CipherSuites  = "SSL_RSA_WITH_AES_128_CBC";    //set your ciphersuite here, e.g., TLS_RSA_WITH_RC4_128 
                KeyStore key =null;   trustAll=trustAll ;//Accept all Certificates (self-signed) and the server's certificate only if set true    //set false otherwise      (must use --keyCertChainOption for client cert auth).     null to accept both      
               kmf =  new KeyManagerFactory.getDefaultAlgorithm(KeyStoreType, keystore , tsPassword );  CipherSuite = "SSL_RSA_WITH_AES_128_CBC" .split(":");   //set your ciphersuite here (e.g., TLS_DHE_RSA_WITH_3DES_EDE, etc.)   
              KeyStore Truststore=null; trustAll = true ;//Accept all Certificates and the server's certificate if set false     null to accept both       //set your keytrust store in .jar file here  (self-signed)   use keystorepasswd for pass,keypass or password as needed
              TrustManagerFactory tmf = new X509TrustManagerFactory() ;//factory method      if server's certificate is not self signed. Else set this to null    //set false otherwise     (must provide client cert auth)   eithr use keystorepasswd for pass,keypass or password as needed
                sslSocket .setUseClientMode(true);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setNeedClientAuth(true);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setNeedServerAuth(true);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setReadOnly(true);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setEnabledProtocols(new String[]{"SSLv3","TLSv1","TLSv2","TLSv3", "SSLv4_Server"});//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setEnableSessionCache(true);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setSessionCacheTimeout(30);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setCipherSuites( CipherSuite );//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setKeyManager( kmf );//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setTrustManager( tmf );//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setRequestedProtocols(new String[]{"SSLv3","TLSv1","TLSv2", "SSLv4_Server"});//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               sslSocket .setEnabledCipherSuites(true);//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
                sslSocket .startHandshake();//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
               System.out .println("Handshake Completed");//use only if your want server's certificate in truststore. Else set this to null  //false means that you have both client and servers certificates   (self-signed)    false otherwise     eithr use keystorepasswd for pass,keypass or password as needed
             }catch(Exception E){System . out . println ("Error Occurred: "+E);}  //to handle exceptions. if any exception occurs in the code then it will be caught and printed to console    catch block  
           }}//end of sslSocket initialization     finally{}finally ensures that even after catching or handling, clean up operations can happen regardless whether an error is encountered during execution      for example: close streams , free memory etc.  Finally part in the code ends with a semicolon(;). In this case it will not print anything if there are no errors and only then actual output gets printed to console  
        }catch (Exception e){System . out .println ("Error Occurred : "+e);}    //Main method exception handling end//  Exception Handling Ends in Java. A try-catch block is used here for error detection which handles exceptions within the code it contains and also catches those that occur inside main() methods or any other functions called from this function such as System . out ,print ln, new etc..
        } //end of Main method 
    }}//End Of Class. Minimalist Style Ends in Java Code   This Program is not for use on server side applications only its a client-side application and it'll be running inside the browser to see if you are using SSL security protocols or Not, Its just printing out XML data received from an https URL