import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_51201_SocketServer_A01 {    
    private static final int PORT = 8443; // you can change this port to a free one, e.g., 1235 or any other higher number (e.g.:7096) if needed by your system/network configuration and security requirements  
      
     public static void main(String[] args){       
         ExecutorService executor = null;          // we use an thread pool for better performance          
             try{   
                 SSLServerSocket serverSocket  =null ; 
                  Socket clientSocket           = null;     
                         int count = 0, limit= 15;    
                          while(limit>count){              
                                   serverSocket = (SSLServerSocket) newSSLServerSocket((PORT), "localhost", executor);          //create a secure socket and bind it to the port       
                                  try{   
                                      System.out.println("Waiting for client on port :"+serverSocket.getLocalPort() + "\n");     }            catch(IOException e){System.err.println ("Failed or can't acquire port: "  + serverSocket.getLocalPort()); return;}              while((clientSocket = (SSLServerSocket).accept()) != null ){
                                               count++;  // we have got one client connected   Connection con  =newConnection(server, sslClient);           SocketReader rdr =  new Reader();          try {rdr.readDataFromStream()} catch (IOException e1) {}         }              System.out.println("Closing down the listener ...");  serverSocket .close();
                                          // closing all connections       if(server !=null ){        for (int i = 0;i < poolSize ; ++i){          try {connections[i].closeConnection()} catch {} }     ServerThread.stopServerExecution("main");   System.out.println ("Main thread Stopped.");
                                           return;}      // End main method         if(server !=null ){        for (int i = 0;i < poolSize ; ++i){          try {connections[i].closeConnection()} catch {} }     ServerThread.stopServerExecution("main");   System.out.println ("Main thread Stopped.");
                                          return;}  // End main method   
                                      };                   if(serverSocket != null ){ serverSocket .close();}}catch (IOException e){System.err.print("\n\tFailed or can't acquire port: " + PORT+ "\n");} finally {if(executor !=  executorService)   try 
                                        // Cleaner way to close the Executors    if (!ServerThread .stop_server ("main")) System..println("Main thread has been stopped.");}};}}}                  catch (Exception e){System.out.print("\n\tFailed or can't acquire port: " + PORT+ "\n");}  finally {
                                        // If we were able to close the serverSocket, then stop everything!               if(server != null ){   for (;;) try     ServerThread .stop_Server ("main")    catch (Exception e){ }}};}}}                  return;}        };};});}));// End main method