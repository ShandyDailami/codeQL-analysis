import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_51307_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    
   public final int port = 40967 ; // you can change the value according to your requirements, 123 is a default one and should not be used for real usage because it's already in use. (Too many open TCP ports on most systems) This might cause an error if tried with another available Port
    
    public static void main(String[] args){  
        try{      
            SocketServer server = new SocketServer();  //Creating a Server instance          
             }//end of inner class         
         catch (Exception e) {e.printStackTrace();}     
                   System.out.println("The SSL Server is starting up on port: " +port );    
              try{    serverSocket =(SSLServerSocket )server.listenPortSetupWithKeyAndCertificate(40967);  //Setting the listen Port and providing a keyStore for client authentication      }catch (Exception e) {e . printStackTrace();}           System.out.println("The SSL Server is started successfully");       
         while((serverSocket)!=null){    try{   Socket socket = serverSocket.accept( );       if ((socket !- null))     runClientWorkerThread ( new Object[]{  network . getProperty ("host.address"),network , port});      }catch({Exception e) {e printStackTrace();}
                    }}//end of while loop    System outprintln("Server is waiting for client connections");   //The Server waits until a Client connection, then start running threads        public void runClientWorkerThread(Object[] threadInfo){     new ThreadHandler (thread Info).Start.  }public class Socketserver {}}