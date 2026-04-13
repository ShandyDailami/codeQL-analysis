import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_46850_SocketServer_A08 {    
    private static SSLServerSocket serverSocket;  
     
    public void start(int port) throws Exception{        
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory(); 
         
       // Create a new socket and bind it to the specified port    
           System.out.println("Starting Server on Port: " + port);  
            serverSocket =  ((SSLServerSocket) sslServerSocketFactory.createServerSocket(port));   
             
        ExecutorService executor = Executors.newFixedThreadPool(10);  //Creates a thread pool to handle multiple clients concurrently    
         while (true){     
             System.out.println("Waiting for client on port: " + serverSocket.getLocalPort() );  
                 final SSLSocket clientSocket = ((SSLServerSocket)serverSocket).accept();  //Accepts a new connection from the socket   
                  executor.execute(new Runnable(){     public void run(){      try{        
                    InputStream input=clientSocket.getInputStream();       System.out.println("Connection established");        BufferedReader bufferedReader =          new           BufferedReader   (new                 InputStreamReader  (input));    String clientQuery; while ((clientQuery  =bufferedReader .readLine()) !=  null){     //Read the incoming message from a client        
                    System.out.println("Client Query Received: " +       clientQuery); }      catch(Exception e) {System.out.print ("Error in reading ");   e.printStackTrace();}  finally{          try { if (clientSocket != null && clientSocket.isConnected()){    
                    System.out.println("Closing the Client Socket");        `clientSocket .close();      } else    //if socket is not connected close it       break;}}};   });} catch(Exception e) {System out println ("Error in accepting connection ");e           try{ serverSock          etch (true); 
                    System.out.println("Server Closed");}}}             finally{}            }});     }}              };    // Close the executor service after usage   if (!executorservice .isShutdown()) {      Executors       ServiceExecute        s tate = (ExecutorsService)         ServerSocket..get(); 
                    try{ serverSock etch.shutDown(true); } catch     Exception e){ System out println("Error in closing executor service ");e}};}}}`catch   }; //end of main method, it's a end point and will never be reached    if (run) { 
                    try{ SslServer s = new       SSL Server();         run.Sllserver(3091); } catch     Exception e){ System out println("Error in starting server ");e}};}}}`catch   }; //end of main method, it's a end point and will never be reached