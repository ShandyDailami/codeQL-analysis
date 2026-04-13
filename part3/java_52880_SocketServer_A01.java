import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.x509.*;
class java_52880_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    	        
        ServerSocket server = new ServerSocket(2481);         
       // Create a Cipher object for encryption and decryption 		           
	    KeyStore keystore;     	 
	        try (KeyStore keystore=KeyStore.getInstance("JKS")) {			   									            	        	     								              }  
        SSLServerSocket sslserver = new SSLServerSocket(null,keystore,(SSLServerSocket) server);  // Create the Secure Server Socket          	   		         	 	       	}            catch (Exception e){e.printStackTrace();}                    finally {sslserver.close(); }     
         try{   									  	            			                             sslserver=null;     if(key== null) key = KeyStore.getInstance("JKS");        keystore.load(new FileInputStream("/Users/user/.keystores"),"mypassword".toCharArray());     
         }catch (Exception e){e.printStackTrace();} 		            	  									         	   			     finally{serverSocket_temp=null;if(!SSL) server = new ServerSocket(2481);}}       	}    catch {socket.close()};              socketServerTemp== null;}