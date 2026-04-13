import java.net.*;   // Import Socket and ServerSocket classes to create socket connection with clients    
import javax.net.ssl.*;    // For ssl certificate handling etc     
import java.io.*;       // IO related operations like InputStream, Outputstream...       
        
public class java_51376_SocketServer_A07 { 
          private static SSLServerSocket serverSocket;   //server side socket object for secure communication    
              
            public void start(int port) throws Exception{   
              Socket client = null;      
                try{                  
                  KeyPair keyPair=KeyStoreUtils.generateKeyPair("MyKey");     
                                     
                                                    SSLServerSocketFactory sslserversocketfactory=  (SSLServerSocketFactory)SSLContext.getInstance( "TLS" );  //Create an instance of the server socket factory  
                     
                        sslserversocketfactory .setKeyStorePassword(keyPair);    
                          this.serverSocket= new  SSLServerSocket(port,sslserversocketfactory , keyPair);    /* Create a new secure server-side Socket */      // Bind it to port*/       ServerSocket listen =this.serverSocket;   System.out .println ( " Secure socket listening on: ".concat("Port :").concat(String.valueOf((listen).getLocalPort()) ) ); 
                      while ((client= this serverSocket.accept() ) !=  null){     //Server accepts connections and then do the following operations    }           catch{   System . out ( "Exception occurred in". concat(" Secure Socket Server: ".concat(e1))); e2.printStackTrace();}        finally {      if (!serverSocket.isClosed() )  server_socket_.close();    
                   }} //End of try and catch block for handling exceptions   }catch (IOException i){ System . out (" Exception in IO-block".concat(" "). concat(i));}}    e1..printStackTrace;}}}      if (!serverSocket.isClosed() ) server_socket_.close(); 
             }} //End of start method           });}   }//end main class    `