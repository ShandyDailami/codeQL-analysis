import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
  
public class java_52248_SocketServer_A03 {   
     private static SSLServerSocket serverSocket = null;  //server socket for accepting client connections over ssl     
      
     public void start(int port){        
        ExecutorService executor=null;         
           try{           
                System.out.println("Starting Socket Server");            
                      
                 int poolSize = 10;  //define the threadpool size to handle multiple requests  
                     
                  executor = Executors.newFixedThreadPool(poolSize);   
                        serverSocket= (SSLServerSocket) new SSLServerSocket(port, null ,executor );    
                       while(true){              
                            try{                          
                                Socket socketConnection=  serverSocket.accept();   //listen to client request      
                               System.out.println("Client Connected");     
                                   executor.execute(new ClientHandler(socketConnection));          
                                  }                    catch (Exception e) {        
                                              if(!serverSocket.isClosed()){        serverSocket.close();}   //handle any exceptions and stop the socketServer    println("Error in client Handler"+e);            }}          finally{                  executor.shutdown();}}           }catch(Exception e ) { System.out.println (" Server failed to start: " + e ); 
     try {if (serverSocket != null) serverSocket.close();} catch (IOException e1){System . out . println("Error in closing the listener"+e);}}   }          public static void main(String[] args ){ new SocketServer().start(5002 ); }}