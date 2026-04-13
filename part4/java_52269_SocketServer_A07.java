import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_52269_SocketServer_A07 {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSock = null;
        
		//Setting up SSL context and key manager factory 		  
	    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI");      			    					     				                  	 
	      DataStore ds= new FileDataStore(new File("/home/user/.keystore"));                						         							        	                   								          	        Context ctx =  TLSServerSocketChannel.init(serverSock,kmf);                    		             	    }        catch (Exception e) {                                       			                  
            // handle the exception here                  System.out .println("Error creating keymanager"); 				  	}    };       });     								    	 	             SocketConnection conn = ctx.accept(null));              					           try{        		                     if (! ((SSLHandshake) (conn)).getSession().getCertificate().toString()
                // .equals("CN=Client1")) {  throw new IOException ("Authentication failure"); }      else     System..println   	   "Successfully authenticated" ;      									             conn.close(); }} catch(Exception ex){                   			          		               if (serverSock !=  null) serverSocketChannel .close()}}