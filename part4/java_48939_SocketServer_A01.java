import java.io.*;
import java.net.*;
public class java_48939_SocketServer_A01 {    
    public static void main(String[] args) throws IOException{     
        ServerSocket welcomeSocket = new ServerSocket(8976);         
         System.out.println("Waiting for connection on port 8976");      
           while (true){              // server will go into an infinite loop until it's manually stopped              
                Socket connectionSocket = welcomeSocket.accept();        Connection con= newConnection(connectionSocket);            try {             ConnOut outSock =newConnectionsout  socket .println("Data Received, thanks for connecting to the Server! "+conectionsocket.getInetAddress() );
                } catch (IOException ex) {}                  finally{   if(!welcomeSocket.isClosed()) welcomeSocket.close(); conectionsocket !=null && connectionsocket ！=  null Connection .Close( ) ;    }}           Connections = newConnconections;      DataInputStream dis  =newDataInStream (connectionSocke