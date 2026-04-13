import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_45990_SocketServer_A07 {  
    private static final String USERNAME = "username"; // replace with your actual username here for authentication purpose only, it should be a hardcoded value in real world scenarios 
    private static final String PASSWORD="password1234567890!";//replace same as above. It's just an example and not recommended to use plain text password due security concerns  
    
    public static void main(String[] args) throws Exception {  // Start of Main Method, all the code will start here from this point onwards is written below for brevity purposes only     
        SSLServerSocket sslserversocket = null;      
         try{                 
             KeyStore keystore=KeyStore.getInstance("JKS");    /*You can use JCE or any other */         
                 InputStream keystoreInputStream =  new FileInputStream("/path/to//yourkeystorefile") ;  //replace with your actual path and file name  
                     keystore.load(keystoreInputStream, "mypassword".toCharArray());    /*You can use any password*/     
                  KeyManagerFactory kmf = new JavaKeyStoreKeyManager(keystore,"mypassword".toCharArray() );  //Password to load the keystore and provide key manager factory  
                   TrustManagerFactory tmf=new UntrustedCertificateTrustManager();    /*You can use any trustmanagerfactory here. It's a placeholder for real world usage*/     
                      SSLServerSocketChannel sslch = new SSLServerSocketChannel(sslserversocket,kmf ,tmf);   //creating the server socket channel with your keystore and key manager factory   
                         Socket ss=sslch.accept();  /*Accepts a connection from client*/      
                             DataInputStream dis  =new DataInputStream (ss.getInputStream());    
                                 String str =dis .readUTF() ;        //Read the message sent by Client   */         PrintWriter pw =  new PrintWriter(ss.getOutputStream(),true);    try{  /*Allows us to write and read data from/to client*/          if (str != null) {
                                           System.out.println("Client says :"+ str );             //Reads the received message   */         } else {     pw .close();ss.close();break;  /*If no Message is provided, close both connection and exit from loop*/    }} catch (Exception e){System.err.println(e);}     
            sslch.close(); ss.close(); //closes all the opened resources */ }       finally{sslserversocket .close();}}   try { Thread thread = new NewThread() ;thread.start () ;}catch ( Exception fnf ) {}         catch ( Exception ex){ System.err.println(ex);}