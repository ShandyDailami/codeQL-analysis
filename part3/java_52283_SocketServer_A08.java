import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_52283_SocketServer_A08 {   
     private static ExecutorService executor; // for thread pooling      
         
      public void start(int port) throws IOException{ 
        ServerSocket server = new ServerSocket(port);               
           while (true){             
             try{                       
                 Socket client_socket =  server.accept();              
                  System.out.println("Accepted New Connection from : "+client_socket );                    
                   executor.execute(new ClientHandlerThread(client_socket));  //thread per connection                            
                }    catch (Exception e){                   
                 ServerSocket srv=null;                      
                         try {                     
                            if((srv = server as ServerSocket)!= null)         
                                srv.close();                         
                        }     finally{             
                           System.out.println(e);                              //handle the exception                            
                                                    }}  catch (IOException e1){        
                                                                    try {if ((ServerSocket)server).isClosed() == false )       server = new ServerSocket(port,240*65 ); }          finally{ System.out.println("Could not listen on port "+port +". Attempting with alternate port.");}}  //try to use a different random available TCP Port                     
        });                                                                   };     executor= Executors .newCachedThreadPool();    }}                       })};                  } catch (Exception ex) { System.out.println("Error in establishing connection... "); if(server !=  null){ server.close() ;}};  try{ ThreadServer t = new ThreadServer () ;t.start ("localhost",23456)}catch (IOException e1 ){}