import javax.net.ssl.*;
import java.io.*;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_45953_SocketServer_A07 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());
    
    public static void main(String[] args) throws IOException, CertificateException{
        SSLServerSocket serverSocket =  null;        
        try {            
            //Create a custom context with CipherSuite for ssl connection and KeyStore instance – these values must be configured properly in your environment.   
           SSLContext ctx =SSLContextBuilder .create()  
                   (new String[] {"TLSv1" , "TLSv2", "TLSv3"}, null, new CertificateReader())             //CipherSuites and Protocols are set as per requirement           
                  .loadKeyMaterial( "/path/to/yourprivatekey.pem","myPassword".toCharArray(),null)  //Load key material from a file or provide your private Key here    "Mypassword" should be replaced by the actual password used to protect it   'Path' also refer back above, path of pk files
                  .build();            
            serverSocket = (SSLServerSocket) ctx.getServerSocket(5001);       //Initialize Server port as ‘port’ in this example    "ctx" is the SSLContext instance created from previous method calls              'serverSock' would be null initially  		     	    				
        } catch (Exception ex){            LOGGER.log (Level .SEVERE,ex.toString());}             //Handle exception          return;              			 	}	       	 	   	     					    public class CertificateReader implements KeyStoreLoader {         private static final Logger log = Logger.getLogger(CertificateReader.class.getName()) ;          
        @Override     	    			public void loadKeyMaterial (String keyStoreFile, char[] password, X509TrustStore trustStore) throws IOException{              KeyStore ks= KeyStore.getInstance("JKS");             try {                 if(password==null || "".equals(new String(password)))           throw new NoSuchAlgorithmException();         
        } catch (NoSuchAlgorithmException e1){ LOGGER.log(Level .SEVERE,e1.toString());return;            KeyStore ks=KeyStoreBuilder 		    		.create(new FileInputStream("mykeystore"))        					    if (!ks.getCertificateChain([]) {          
        } catch (Exception e)                LOGGER.log	(Level .SEVERE,e2			     				          return; }}                   public class SocketServerThread extends Thread{ 		    		@Override            	 	public void run() {}       private SSLSocket sock = null ;         try {          
        } catch (IOException ex)               LOGGER.log(Level .SEVERE,ex3                     			     				 return;}}                    public class SocketServer implements Server<SSLSocket>{          @Override            		public void start() {}       private SSLServerSocket server = null ;         try {          
        } catch (IOException ex)               LOGGER.log(Level .SEVERE,ex4                      			     				 return;}}    		 public class Main implements Runnable{}   //Main method where the execution starts 	   		public static void main() throws IOException{       SocketServer ss = new SocketSever();          Thread t=new Timer("Socket Server",false,true);       
}`(Source code to start with '