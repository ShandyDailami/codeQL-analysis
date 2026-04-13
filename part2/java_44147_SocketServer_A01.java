import java.io.*; // for InputStream, OutputStream classes and IOException class java_44147_SocketServer_A01 java.net.*;//for ServerSocket and Socket类
    
public class SecureTcpEchoServer {   
      public static void main(String[] args) throws Exception{       
          int port = 8095; // default server's local address, which is used for client-server communication. 
          
          ServerSocket serverSock = new ServerSocket();        
          try {            
              System.out.println("Server waiting on localhost " +port);               
              
              Socket sock= serverSock .accept ( ); // waits until a connection is made, then returns an object representing the connected socket and binds it to port 8095 of local machine's IP address     
                  System.out.println("Connected from " +   sock.getRemoteSocketAddress());        
                 DataInputStream in = new    DataInputStream(new BufferedInputStream (socket .getInputStream()));          // read the incoming data           
                   String message=null;  while((message =  in.readUTF()) !=  null){              System.out.println("Received: " +   message );                  try {                     OutputStream out = new DataOutputStream(sock.getOutputStream());                 } catch (IOException e) {}             // send the received data back to client         
                   sock .close();         return;  }}        finally{ serverSock.close() ;}}    public class Main