import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_52888_SocketServer_A03 {  
    private static final String SERVER_KEYSTORE = "/path/to/your/keystore"; // replace with your keystore path 
    
    public static void main(String[] args) throws Exception{        
        SSLServerSocket serverSocket=null;
       try {            
            KeyStore keyStore = KeyStore.getInstance("JKS");          
			InputStream inputStream =  new FileInputStream (SERVER_KEYSTORE);  // replace with your keystore file path  
			    
          /*Load the private key and certificate into a KeyStore */   
             keyStore.load(inputStream, "password".toCharArray());      
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault(); 
               serverSocket= (SSLServerSocket)sslServerSocketFactory .createServerSocket(8125 , keyStore);     // bind to port, and keystore  	           	 		     			   	   	     									      	        }catch (IOException e){e.printStackTrace()}finally{inputStream.close();}} 
          /*Create a secure socket*/          
             Socket clientSocket= serverSocket .accept();        
              System.out.println("Accepted new connection from : " +clientSocket);      	  				    		   					            //Handling Client request: echo back the message     			        BufferedReader inBuff =  null; 	  try {inBuff =new BufferedReader(          (InputStreamReader) clientSocket .getInputStream());         String inputMessage="";
              while((inputMessage = inBuff.readLine()) !=null){  					    		   	 System.out.println("Client : " +      			       	  request);             }clientSocket..close();}} catch (Exception e) {e . printStackTrace()}  finally{serverSocket.close();}}}