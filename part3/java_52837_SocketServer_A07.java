import java.net.*;
import java.io.*;
import java.util.concurrent.*;
  
public class java_52837_SocketServer_A07 { 
    private static ExecutorService executor; // to handle multiple clients at once using thread pooling    
      
        public void start(int port) throws IOException{           
          ServerSocket server = new ServerSocket(port);            
           System.out.println("Started SocketServer on Port: " + port );  
        
               executor= Executors.newCachedThreadPool();  // thread pool for handling multiple clients at once      
                while (true) {                            
                  try{                           
                    Socket socket = server.accept();         
                       System.out.println("Accepted a new client "+socket);   
                           Handler handler=new Handler(socket);              // create and start thread for handling each individual connection       
                          executor.execute(handler );                  
                  } catch (IOException e) {                     
                    server.close();                         System.out.println("Closing the socket");      break;       }}            finally{executor.shutdownNow()}}           // shutdown hook              
          public static void main(String[] args){  try                
        { SocketServer s= newSocketServer(){ @Override   protected Handler    createHandler (socket)}     private class myhandler implements Runnable              int x, y;      StringBuilder sb =new stringbuilder(); // for processing input           public java_52837_SocketServer_A07(socket) {x = 0;}
          void run() { while((y=in.read())>-1)sb .append ((char )Y); System   "Echoing back user information.."+ ECHO_MESSAGE + sb; out.println (reply ); }}}      catch(Exception e){e.printStackTrace();}}}