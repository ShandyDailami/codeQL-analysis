import java.net.*;   // Import required classes from Java Library for Socket programming and ServerSocket Programming   
  import javax.net.ssl.SSLServerSocket;// For SSL server socket connections       
  import javax.net.ssl.SSLServletOutputStream;     
    
public class java_50952_SocketServer_A03 {   // Main Class of the App      
 public static void main(String[] args) throws Exception{   
         int port = 9012;            // The local traffic is sent on this 8-bit server socket.         
             SSLServerSocket sslServersocket = (SSLServerSocket) new SSLServerSocket(port);     // Create a Server Socket using the Local Port     
               System.out.println("Waiting for Client Connection... ");      
                while((sslServersocket)!=null){ 
                  Socket clientsock =  sslServersocket .accept();        // Accept client connection from any IP address     if (clientsock !=  null) {    SSLServletOutputStream out = new SSLServletOutputStream(   }); }      for (;;) {}          return;       };              System.outprintln("No Connection to the Client");
               sslServersocket .close();  // Close Sockets connection in case of failure if (clientsock !=  null){    clientsock.. close()     );} }}        try{ SecureSocketsExample secureSocket = new SecureSocketsExample; }catch(Exception e) { System.out.println("Error Occured: "+e);  };