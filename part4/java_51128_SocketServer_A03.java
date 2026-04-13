import java.io.*;
import java.net.*;
import java.util.concurrent.*;   //for thread pooling and time unit management etc...   
    
public class java_51128_SocketServer_A03 {     
          
private static ExecutorService executor;      
         
 public static void main(String[] args) throws IOException, InterruptedException  {        
        ServerSocket server = new ServerSocket(6042);   //creating a socket with port number 'port'    
            System.out.println("Server started at Port: "+server.getLocalPort());   
           executor= Executors.newFixedThreadPool(15) ;  /* Creates thread pool */         
        while (true){             //Infinite loop to keep server running        
                Socket socket = server.accept();     //Accepts connection from a client  
                 System.out.println("Client connected: "+socket.getRemoteSocketAddress());      
                  executor.execute(new ClientHandlerThread(socket));  /* Executes task in thread pool */         
        }   
}          
         public static void shutDown(){            //Method to shutdown the server and close connections    
                System.out.println("Server is going down now");  
                  executor.shutdown();      //Shutting all threads inside Executors      
                   try{          /* Try block for catching exceptions */          
                        if(!server.isClosed()){        //Check server wasn't closed        
                             server.close();  }    }}                catch(IOException e) {   System.out.println("Error in closing the Server!");     closeConnection(socket)};}}      private static void closeConnection (Socket socket ){       if (!socket.isClosed())        try{            //Close connection        
                     SocketAddress remote = ((ServerSocket)server).getRemoteSocketAddress();   /* gets Remote server's IP */          System.out.println("Just closed down the connection with "+remote);           socket .close(); }catch(IOException e){  }}                  catch (Exception ex ) {ex.printStackTrace()};}}