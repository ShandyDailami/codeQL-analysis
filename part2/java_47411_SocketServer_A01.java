import javax.net.ssl.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_47411_SocketServer_A01 {  
    public static void main(String[] args){ 
         try{    
             SSLServerSocket server = (SSLServerSocket) new SSLServerSocket(8401, null);//port and backlog are arbitrary values for this example          
               while(true){             
                 Socket connection  =server.accept();           
                     System.out.println("Connection established from : "+connection.getRemoteSocketAddress());   //printing connected IP address      
                       SSLSocket ssl = (SSLSocket)  connection . acceptTransportChannel() ;     
                         Handler handler= new ForkingHandler(ssl);    
                             ExecutorService service  =Executors.newCachedThreadPool();   
                                 while((ss=sockreader.readLine())!=null){        //reading from the client         
                                       System . out . println ( ss );           }         try {   ssl.close();} catch(IOException e) {}      if (!connection.isClosed() )  connection.close();    break;            }}catch(SSLException se){se.printStackTrace();Logger l= Logger.getLogger("[Server]");l . log (Level.SEVERE , "Failure in establishing SSL",e);break;}
      } catch (IOException ex) {ex.printStackTrace() ;}    //end of try-catch   finally{ server.close();}}  it's important to close all resources at the end, including sockets and connections when possible!     }}//To change body of code non-static method is not allowed in this context