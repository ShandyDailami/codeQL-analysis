import java.io.*;    // For BufferedReader and PrintWriter    
import javax.net.ssl.*;      // Import SSLSocketFactory, SSLEngine      
import java.security.KeyManagementException; 
import java.security.NoSuchAlgorithmException;         
        
public class java_52905_SocketServer_A03 {  
    private final int port = 8090;    
          
// Create a thread for each client request     
private void startSSL() throws IOException, KeyManagementException{      
        SSLServerSocket serverSocket = null;            
            try  // To suppress warnings while initializing the certificate.                  
                {                   
                     System.out.println("Creating SSL Server");   
                     
// Create a new instance of SSLEngine with our key store, and use it to create an               socket for each request        SSLServerSocket      server = (SSLServerSocket)serverSocket;       // Get the port number from the sockaddr_in structure           int clientPort = ((SSLSocket)server.getRemoteSocket()).getLocalPort();                    
                    SSLContext context =  SSLContext.getInstance("TLS");          ServerSocket secureSock= new     SSLServerSocket(server,context);   // Bind to local port 8091      sslservsoc   =  (SSLServerSocket)new Ssl       SSLEngine[]...
                     BufferedReader in = null;             Writer out  =null ;        PrintWriter writer= new     PrintWriter(serverOutputStream,true);   // Create a buffering character input stream         serverInputStream =  sock.getInputStream();           System.out.println("Secure Socket Client connected with port number: "+clientPort );      
                     BufferedReader socketIn = null;                 DataOutputStream outToClient=null ;  PrintWriter writerOut  =new     PrintWriter(serverSocket,true);   // Create a character output stream for the client's view          SSLServerConnection conn =  (SSLServerConnection) server.accept();             connectionListener threadcon=  new    ConnectionThread((socketIn,out),conn , outToClient );
                     Thread mythread =new  threads(serverSocket= secureSock);            // Start up one listener per client     }catch{...}          while looping through the socket read from clients        try { server.close(); sslservsoc . close ();    System.out.println("Closed down");  
                }} catch  IOException e1)                     {}                   finally{}       //Finally block that releases resources if they were not released in a try-catch clause             }while(true){...}                    while running the code and trying to understand why it's failing, provide more information about what is going wrong.  
     public class threads extends Thread {    void run(){        ...  }}          // This method will handle one client at time           Socket socket = serverSocket;      try{socket connected();}catch(IOException e){e.printStackTrace()}}finally {}while (true) ;         }// Main loop to create new threads for each accepted connection