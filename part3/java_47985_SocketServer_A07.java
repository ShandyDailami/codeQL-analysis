import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;

public class java_47985_SocketServer_A07 {  
  public static void main(String[] args) throws Exception{    
    SSLServerSocket sslServer = (SSLServerSocket) new SSLServerSocketBuilder(8443).build();      
      System.out.println("Listening on port : " + 8443);              
        
          Socket socket=null;          
            try{                    
              //accept client request               
                      socket = sslServer.accept();                      
             }catch(IOException e){                   
                System.err.println("\nAccept failed: %s",e);   
                   System.exit(-1);                           
          }}  catch (Exception ex) {      									  			     		           	          	 	       	   	     						              };                    
                  // SSLHandshake            
                    try{              							     SslContext sslcontext=null;                      Context context = null;}                        if(socket==null){ return;-1 ; }                          else  socket.close();                            				  			   		      	        	 	   	     	};                					      };                         System.out.println("Closing the connection");if (sslServer != 0) { sslServer . close()};}};