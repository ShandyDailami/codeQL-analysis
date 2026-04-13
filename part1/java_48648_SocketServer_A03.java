import java.io.*;  // Import necessary Java classes/libraries   
     import java.net.*;      // Including socket related class java_48648_SocketServer_A03 interface for network programming in a multicast environment, such as LAN or WAN connections on different systems (localhost is used here)       
  
public class SocketServer {         
       private static final int PORT = 80;    // Assigning port number          
  public static void main(String[] args){    
      try{        
            ServerSocket server = new ServerSocket();            
              System.out.println("Wait for client on Port: " +PORT);      
              
          while (true) {                 
                Socket socketConnection =  server.accept();        // Accept the incoming connection from a Client          
                     DataInputStream dis=new DataInputStream(socketConnection.getInputStream());   // Input stream to read message sent by client   
                       String data =dis.readUTF();  // Reading string received     echoing all inbound messages        
             System.out.println("Received: " +data);              
                  }            server.close();        break;             
                case ServerSocket.InUseByOtherProcess :   throw new SocketException(socketConnection, InUseByOtherProcess) ;  // Throw exception if port is already in use by another process     finally { socketConnection . close() };    catch (IOException e){ System.out.println("Error: " +e); }}}