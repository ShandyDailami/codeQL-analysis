import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class java_51132_SocketServer_A03 {   // Server side implementation starts here (line A1)
    private final ExecutorService exec = Executors.newCachedThreadPool(); 
    
        public static void main(String[] args){      // Main method for testing the program start from this line up to end of code block below ends at Line:A24  
         try {                                   
              SSLServerSocket serverSocket=null;    /* Server side socket starts here (line A3) */ 
             int port =8091 ;                     // Setting default value for the above variable. The actual one can be any number and should match with client's connection attempt from same place which is specified in line:A4  
              SSLServerSocketFactory sslserversocketfactory;    /* Sockets factory start here (line A5) */ 
               //Setting up key store, truststore for server     ((lines B1-B2))
                KeyStore ks = KeyStore.getInstance("JKS");         
                 InputStream is= SecureServer.class.getResourceAsStream("/clientkeystore.jks") ;       /* Assuming client keystore file */  //Assumed the path to be correct (lines B3-B5)  
                ks .load(is, "mypassword".toCharArray() );    //Load key store and pass phrase     ((line C1))     
                 KeyManagerFactory kmf = KeyManagerFactory.newInstance(ks, "mypassword".toCharArray());  /*Assuming same password for keystore */   //Key manager factory to get private keys from truststore    (lines D-E)         
             TrustManagerFactory tmf=TrustManagerFactory .getInstance("SunX509");     /* Set up the Trus Manager Factory starts here*/              ((line F1)) 
                sslserversocketfactory =(SSLServerSocketFactory )tmf.getServerSocketFactory();   // Create a Server Socket factory using Trust manager (lines G-H)    */     
             serverSocket=sslserversocketfactory .createServerSocket(port);       /* Setup the port for socket listener and starts here  ((line I1))*/    
               SSLSocket client =null;                /* Client side connection setup starting from this line up to end of code block below ends at Line:I6   */    // (lines J-K)       
             while(true){           
                 try{                   
                     BufferedReader in=new BufferedReader((InputStreamReader(serverSocket.getInputStream())));       /* Read the incoming client data from here  ((line L1))*/    
                      String str,user_text;    // Variable declaration starts here (lines M-N)   (* Assuming user input is string type and this part will be replaced by actual code in real program.*)     
                     while((str=in .readLine())!=null){        /* Main loop for reading client's message from the socket  ((line O1))*/    // (lines P-Q)          
                         user_text = new String(str);   (*Assuming string type and this part will be replaced by actual code in real program.*)    
                          System .out .println("Server received:"+user_Text );      /* Server receives the message from client  ((line R1))*/    // (lines S-T)          
                     }                  
                 catch(Exception e){               (* Catch block for exception handling in real program.*)     void xyz;   if((xyz=0)/e .equals("XYZ")){      return;}         else {throw new Exception ("exception"+x);}    // (lines U-V) */
                  }  finally{}                (* This block will always get executed no matter the catch or not.*)     while(true){}};   /*This infinite loop is for preventing any client from closing connection without warning and also prevent other code execution to this point which may be located anywhere within main method (line Z1).*/