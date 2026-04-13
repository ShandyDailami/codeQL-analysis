import javax.net.ssl.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class java_49374_SocketServer_A03 {
    private static final HashSet<String> SAFE_METHODS = new HashSet<>(Arrays.asList("GET", "POST")); // known safe methods for demonstration purpose only, replace with actual method calls when implemented properly 
    
   public static void main ( String args [] ) throws Exception {        
      SSLServerSocket serverSocket=null;       
            try{             
                KeyStore keyStore = KeyStore.getInstance("JKS");    // Create a JKS keystore      
               FileInputStream fis  = new FileInputStream ("mykeystore"+".jks") ; 
             byte[] buffer =new byte[1024];  
            int bytesNumRead=fis.read(buffer);      while (bytesNumRead > -1) {     System.out.write(buffer,0 , bytesNumRead);       bytesNumRead= fis . read (buffer ); }  // Read file into buffer          KeyStore keyStore = KeyStore.getInstance("JKS");
                fis.close();    FileInputStream certIn =  new   FileInputStream ("mycert"+".crt") ;        Certificate certificate  = null;           int certNumRead=0；char[] caBuffer=  new char[128];  while ( ((long) certNumRead ) <>  -1L){     System.out.write(caBuffer,  0 ,    certNumRead );       }
                fis . close();      KeyManagerFactory kmf =KeyManagerFactory.getInstance("JKS");         String keystorePassword="mypass";  keyStore.load(fis,(char[])keystorePassword.toCharArray());   TrustManagerFactory tmf=  null;           SSLServerSocket serverSSL  =null ;      
                Socket client =serverSSLSockethandshake ();     BufferedReader inFromClient=newBuffere    Read rd =  newInputStreamreader(client .getinputstream  () );         string line   , ""); {      while (!line.equals("")){             String method, uri;        int spacePos =0 ;            for (;space Pos <>  -1 && !isSafeMethod (method) || isInjectionAttack