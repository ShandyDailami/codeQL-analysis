import java.io.*;     // for InputStream and OutputStream classes            
import javax.net.ssl.*;    //for SSLServerSocket, SSLEngine, KeyManagers class java_52281_SocketServer_A07 Socket_Security {       
 private static final String KEYSTORE = "keystore";  
  public static void main(String[] args) throws Exception{    
       ServerSocket serverSocket=null;    //declaration of SSLServerSocket object         
 try {        
           KeyStore keyStore =  KeyStore.getInstance("JKS");        //load keystore file and get instance               
            char[] password = "password".toCharArray();             //set the required pass phrase while loading keys                     
      keyStore .load(new FileInputStream (KEYSTORE),password);    //loading of a Keystone with given input stream 
           KeyManagerFactory kmf =  KeyManagerFactory.getInstance("SunKSAPI");     //getting instance       
            kmf .init(keyStore, password );                        //Initializing the key manager factory and getting an in-memory keys store        
          SSLServerSocket serverSSLSocket = null;              	//declaration of SSLEngine object  	            		 
           try {      	       									    			   
            KeyManager[] keyManagers= kmf.getKeyManagers();                //Getting the manager details                       	 
        if (args != 0) serverSSLSocket = new SSLServerSocket(Integer.parseInt( args[0]), null, 12345, true );   	    		     	       									              else                     	   	     			   } catch (IOException e){ System . out .println (" Unable to create the Server Socket "); return ;}                                                   
         ssl_setup serverSSL = new ssl_setup(serverSSLSocket);                                        //Setup SSL on port 12345                           	            		     	 			   } catch (IOException e){ System.out .println (" Unable to setup the Server Socket "); return ;}                      									                 
       while ((clientSocket = serverSSL.accept()) != null) {                     	// Accept client connection until no more available                         	   	       							    	           try 			     	 		   } catch (IOException e){ System . out .println (" Unable to accept the Client Connection "); return ;}                           									           
    }}catch(Exception ex ){System.out.print("Error: " +ex);};                           //Catch block for handling exceptions    	         	}}}}                 	       	//Calling main method 		     	 			   }}};              	};       };        	    });       	});}}) ;             try { if (args != 0) sslSocket = new SSLServerSocket(Integer.parseInt((String[] args)), null,12345); else    	sslSocket=null;} catch