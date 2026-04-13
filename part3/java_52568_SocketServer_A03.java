import java.io.*;
import java.net.*;
import javax.net.ssl.*;
    
public class java_52568_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{        
        SSLServerSocket serverSocket = null;            
          
            try 
                {                
                    // Create an SSL Server socket with a specific port                  
                     System.setProperty("javax.net.ssl.keyStore", "serverkeystore");   
                      System.setProperty("javax.net.ssl.keyStorePassword","password123");         
                       serverSocket = (SSLServerSocket) new SSLServerSocket(5408, null);                    
                  }  // End of Try                
                catch (IOException e){            
                    if (!serverSocket.isClosed())                      {                           System.out.println("Failed to create socket on port " + serverSocket .getLocalPort() +  "\n"+e );}                         try   {    closeServer(serverSocket); }catch  (Exception ex) {}                                                        e= null;                    
                }} // End of Catch                      catch ((SSLHandshakeException | IOException ) c){ System.out.println("Error during SSL handshaking " + "\n"+c );}                          finally { serverServerServe =null ; }    return;}       void close(Closeable  cl)  
                  try{if (cl!= null)      // Close the socket if it's not closed yet.        System.out.println("Closing Socket");     ((Socket)(((TelnetSocketImpl))serverServe).getChannel()).close(); }catch(Exception ex){System .err; println ("Error in closing " + serverServerServ+ e);}}      // Return null
                  return (null );   }}  /* Closes the Server */    void closeSSLSSLSocket() {     try{if ((serverSocket!= false)) System.out.println("Closing SSL Socket");         if (!(sslSock ! = sslServer).isClosed())     
                  // Close socket and shutdown Httpserver – this will also shut down the listener    }catch (Exception ex) {System .err; println ("Error in closing " + serverSocket+ e);}}}*/ return null;}     /* Closes SSL Socket */   void closeServer(SSLServerSocket sock){      try{if ((sock != false)) System.out.println("Closing Server");         if (!((TelnetSocketImpl)serverServe).isClosed())    // Close socket and shutdown Httpserver – this will also shut down the listener     }catch (Exception ex){System .err; println ("Error in closing " + serverServerServ+ e);}} return null;}
   /* Closes Server */}