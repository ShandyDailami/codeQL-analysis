import java.net.*;
import javax.net.ssl.*;

public class java_45636_SocketServer_A08 {  
    private static final String CLIENT_IDENTIFIER = "CLIENT-ID"; // Client identifier to check for integrity failure mode
    
    public void start() throws Exception 
    {       
	    SSLServerSocket serverSocket=null;         
	        
	        try{            
		       KeyStore keyStore =  KeyStore.getInstance(KeyStore.getDefaultType());     
			   char[] password = "password".toCharArray();     //set your own strong password here 
				   	 	   
                serverSocket= (SSLServerSocket) new SSLServerSocket(12345, keyStore , password);            	        		       
                  System.out.println("Waiting for client on port: "+serverSocket.getLocalPort());      	       			     	     					            }catch 	   	(SSLServerSocketException e){   				   printStackTrace(e) ;} catch (IOException ex ) {printStackTrace(ex);}}	
         finally{             if (! serverSocket .isClosed())          		       
                serverSocket.close();}}}              ServerSocket sock = null;  try     	{sock=new     SSLServerSocket((12345),null,password) ;   System.out.println("Waiting for client on port: "+serverSocket .getLocalPort());}catch(SSLServerSocketException ex){printStackTrace (ex); } catch   		(IOException e ){ printStackTrace  (e );}}
         finally {        if (!sock.isClosed()   )     sock.close();}}}                 									                ServerThread st=null; try     	{st = new SSLServerSocket(serverSocket,CLIENT_IDENTIFIER); }catch   		(SSLPeerException ex){ printStackTrace (ex );} catch 	   		      
          ((IOException e) {printStackTrace   (e )})}}                  									                while((new     ClientHandlerThread(st.getSocket())).connect());}}}                     }}