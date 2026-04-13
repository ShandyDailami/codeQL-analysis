import java.io.*;
import javax.net.ssl.*;
 
public class java_52959_SocketServer_A08 {  
    private static final String KEYSTORE_LOCATION = "/path/to/yourKeystore"; // replace with your keystore location and filename (without .jks) or alias name in Java KeyStore using command keytool -list -keystore <FILE>.p12 on Windows
    private static final String KEYSTORE_PASSWORD = "passwordOfYourKeystoreFile";  // replace with your keystore password  
    
    public static void main(String[] args) throws Exception {        
        SSLServerSocket sslServerSocket  = (SSLServerSocket) new SSLServerSocketBuilder(843).build();          
              
       KeyStore keyStore = KeyStore.getInstance("JKS");  // or use javax.net.ssl.KeyStore instead if you are using JDK's own keystore  
        try {           
          InputStream inputstream =  new FileInputStream(KEYSTORE_LOCATION);        
           char[] passwordArray = KEYSTORE_PASSWORD .toCharArray();   
             keyStore.load(inputstream,passwordArray );  // provide your keystore's alias if it is not default    
        }catch (Exception e){  
            System.out.println("Error loading the Key Store");        
           return;      
      }         
                      SSLServerSocket sslServer = new SSLServerSocket(sslServerSocket, keyStore , PasswordArgumentHandler);    // you need to provide password argument handler in case of Java keystore  
        while (true) {    
            Socket connection =  null ; 
                try{            	connection= sslServer.accept();              System.out.println("New Client Connected");               }catch(Exception e){System.err.println("#ERR " +e);continue;}}           if ((connection)!=  null ) {          BufferedReader in = new BufferedReader (new InputStreamReader 
     ( connection .getInputStream () ,4*1024));       String clientInputLine="";         try{ while( (!((clientInputLine  =in.readLine()))) );} catch   (IOException e) {connection .close(); }           sslServerSocket.close();}}   
     // end of main method  and use the code below for a basic SSL Server socket creation example:          return;}}}         private static class PasswordArgumentHandler implements Handler{        public String getPassword() throws IOException, KeyStoreException {return PASSWORD;}   }};