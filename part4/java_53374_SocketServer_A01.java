import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_53374_SocketServer_A01 {  
    private static final String CLIENT_IP = "192.0.34.76"; // Client IP to which the server will connect 
    
    public void start() throws IOException, SSLException{      
        ServerSocket socket = null;        
        try {            
            socket=new ServerSocket(8443);              System.out.println("Server started");          
              
          //Create an KeyStore and Load it into the key store 
                FileInputStream fis =  new FileInputStream("/path/to/yourkeystorefile" );  
                   SSLServerKeyStore serverKeyStore = new SSLServerKeyStore(fis, "password".toCharArray(), null);   
             //Create a KeyManagerFactory and provide the stored key store 
                KeyManagerFactory kmf =  KeyManagerFactory.getInstance("SunKSAPI");             
                    kmf .init(serverKeyStore ,"password".toCharArray());       System.out.println ("Initialised ");       
               SSLContext sslcontext =SSLContext.getInstance("TLSv1_2");             // Initialize the context with TLS protocol version 
                KeyStore truststore= serverKeyStore;              TrustManagerFactory tmf =  new   XPKIX15TrustManager();           System.out.println ("Initialized SSL Context ");       sslcontext .init(kmf,tmf ,null);      // Create a socket and bind to the port       
                while (true) {            Socket connectionSocket = socket.accept();              HANDLER:     for (;;)  try{   System.out.println ("Connection accepted");          SSLServerSocket sock=(SSLServerSocket )connectionSocket .getSocket();                  BufferedReader in  = newBuffere Reader (sock.getInputStream());
                             PrintWriter out =newPrint Writer ((S Ocket)`socket..getsocket()OutputStream()));    String clientMessage;             while((clientmessage==readline(in)))  {   if("exit".equalsIgnoreCase(ClientMessag e)) break HANDLER;}              sock.close();
        } catch (Exception ex){                     System .out ..println ("Server Accepting failed"+ex);          continue;     }}    finally{               socket.close();      }}  // Close the Socket Connection at last   if(socket!=null) try { socket..closethecket()}catch exception e {} }
        public static void main (String [] args){                     new SSLServer().start();       System . out .println ("Main method started");     }    }}  // Call the start function to initiate process            if(sock!=null) { try{ sockets.closeoncheck()}catch exception e {}