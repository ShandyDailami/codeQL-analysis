import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_49201_SocketServer_A01 {
    private static final String PASSWORD = "password"; // Change this to your real password hash if needed, or leave it blank for no access control mechanism: e.g., `null` 
    
    public static void main(String[] args) throws IOException{      
        SSLServerSocket sslServerSocket;     
        
        try {                 
            // Create a server socket using the port specified on your local machine and use it to accept client connections                  
             SslServerSocketFactory sslSf = (SslServerSocketFactory)SSLServerSocketFactory.getDefault(); 
              sslServerSocket=( SSLServerSocket )sslSf.createServerSocket(1234);          
        } catch (IOException e){            System.out.println("Could not listen on port: " + 1234 +".\n");             return;     }}     
  try {   // Accepting connections from clients    while((client=sslServerSocket.accept()) != null ){       Socket client = sslServerSocket.accept();                  System.out.println("Connected with Client: "+client.getRemoteSocketAddress());              BufferedReader inFromClient = new BufferedReader(new InputStreamReader (     
    // Here, we read from the socket to receive username and password which are sent by client     then       if ((PASSWORD != null) &&  (!authenticateUser())) {                  System.out .println("Access Denied");              continue; }                   DataOutputStream outToClient = new DataOutputStream (client.getOutputStream());                    
    // Here, we write to the socket from our server for communication with client        if(PASSWORD != null)      try{                    ServerHelloServerKeySpec keyspec  =new   ServerHelloServerKeySpec("SSLv3");             KeyManagerFactory kmf =       K
  ( "Sun-EC", new File("/etc/ssl/certs/Sun-EC.pem"),null,keyTypes);              cipherSuites=CipherSuiteList.forNames(new String[]{"TLS_SSLv3","TLSv1"},true).get("");                  //set up the client session object and initialize it with server's certificate       SocketImplFactory sf = (SocketImplFactory) SSLSocketFactory.getDefault();              socket = 
  ((SSLSocket)sf .createSocket(client, "localhost",4321));                     socket  =  new BufferedWriter     DataOutputStream outToClient  =new PrintWriter((socket).getOutputStream(),true);                  //set up the client session object and initialize it with server's certificate       SslContext ssc = 
  (SslContext) SSLContext.getInstance("TLSv1_2");              ssc .init(kmf, new   SCertificate[] { trustedCert },null );             outToClient      //write to the socket from our        client for communication with server          DataOutputStream     writer =      
  (DataOutputStream)(ssc).wrap((socket.getOutputStream()));                  inFromServer=new BufferedReader(         if ((PASSWORD !=  null) && (!authenticateUser())) {                   System .out .println ("Access Denied"); return;}             while    //loop until client says bye                
  (System out, "client :" + reader.readLine()+", ");   } catch       ...}}}}}                  socket.close(); writer.. close; sslServerSocket._socket           ((SSLServerSocket) null).accept());}          e .printStackTrace     }}              //closing everything down