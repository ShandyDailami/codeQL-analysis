import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_47724_SocketServer_A03 {
    private static final String SSL_PROTOCOL = "SSL"; // Name of ssl protocol for our server and client certificates are required to be used when creating a new socket connection (i.e., ServerSocket, Socket) 
    
   public void start(int port){        
        try {            
            TrustManagerFactory trustMgrFact = new X509TrustManagerFactory(); // Create an instance of the manager factory         
          
              SSLServerSocket serverSockSSLServ=new SSLServerSocket(port,null); 
               ServerSocket socketServeur =  (SSLServerSocket)serverSockSSLServ;        
                  socketServeur.setNeedClientAuth(true); // Set the need for client authentication to true                
            serverSockSSLServ .setTrustManagerFactory(trustMgrFact ); 
               System.out.println("Starting Server on port: "+port +" with protocol :SSL");         
              Socket s=null;           while((s = socketServeur.accept()) !=  null){                 try{                  SSLSocket clientSSLSock =  (SSLSocket)s.getShared( );               HOST_NAME hostname  =   ((SSHTransportSocketConnection)clientSSLSock).getSession().getHost();
              System.out.println("Got Connection from : " +hostname);                   BufferedReader inFromClient =new BufferedReader ( new InputStreamReader  ( clientSSLSock . getInputStream () ) ); String serverMessage;           while((serverMessage=inFromClient.readLine())!= null){
              System.out.println("Received : " +   serverMessage);                      DataOutputStream outToClient =new DataOutputStream(clientSSLSock.getOutputStream());  // Get the output stream of socket and send a message to client                  }    if (s !=  null) { s . close();}
        System.out.println("Closed Connection");         }} catch (SSLException ex){             Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE,"Error : " +ex,  ex); }                  finally{                   if ((s !=  null) && s .isConnected() ) {    try {  
           // Close the connection here because it will be closed by server             } catch (IOException e1){ Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE,"Error in Closing Connection : " +e,  e); }}                  System.out.println("Closed");}}