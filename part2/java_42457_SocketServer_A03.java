import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_42457_SocketServer_A03 {    
    public static void main(String[] args) throws Exception{        
        SSLServerSocket server = (SSLServerSocket) new SSLServerSocket((int)args[0]);            
          
        // Enable Server Immediately after binding to a port.           
        System.out.println("Starting Socket at Port : "+server.getLocalPort() +"\n");      
        
        server = (SSLServerSocket)(new SSLSocket()).init(server,null);          
         
        // create buffer for reading and writing  
        BufferedReader inFromClient;              
            byte[] bytes= new byte[1024];    
            
      while(true){               
              Socket connection = server.accept();        
                       System.out.println("Connection Accepted from " +connection.getRemoteSocketAddress());        //Accept the incoming Client Connection and create a socket object           
                  try{         
                        inFromClient= new BufferedReader(new InputStreamReader (connection.getInputStream()));                  
                         String clientMessage;    
                          while((clientMessage = inFromClient.readLine()) != null){             System.out.println("Received: " +clientMessage);}          
                       }catch(Exception e) {e.printStackTrace();    }} });  //Catch block for exceptions            catch (IOException e2 ){                  Logger log = LogManager .getLogger ("Server");         
        System.out.println("Closing Connection : " + connection);      try       {connection.close();}           }catch(Exception ex){ex.printStackTrace() ;}}}  //End of catch block for close method            e2.printStackTrace ( );}}    }}