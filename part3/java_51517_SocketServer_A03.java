import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_51517_SocketServer_A03 {
    private static SSLServerSocket sslServerSocket = null;  //SSL Server socket for secure communications  
    
    public void start(int port) throws IOException{     
        try {            
            trustAllCertificates();             
                      
            System.out.println("Starting server on port " +port);          
                               sslServerSocket = (SSLServerSocket) new SSLServerSocket(port,null , 1024 );   // create an instance of the socket with specified parameters       
             while(true){               
                 Socket clientSocket=sslServerSocket.accept();          System.out.println("Accepting connection from "+clientSocket);            if (clientSocket != null) {           try{                                                    SSLSession sslSession = clientSocket .getSSLSession() ;                     HandshakeCompleteListener hcl  = new MyHandShake(sslSession );                   SSLServerConnection serverConn  =  ((SSLServerConnection)  clienSock.accept(hClone, (SSLParameters)null));                 }catch (IOException e){e.printStackTrace();}                finally {if (!clientSocket .isClosed()) clientSocket= null;}}            
        }} catch (Exception ex){              System.out.println("Server Exception : " +ex);   if( sslServerSocket !=  null)  sslServerSocket.close(); }     retry ;    printStackTrace())}          //catch block for handling exceptions           };         while (!Thread .interrupted () ) { try{ start (12345 );} catch (IOException ex){ System..println("Start Server Exception: " +ex);}} }}