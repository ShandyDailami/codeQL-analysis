import java.io.*;  // Import necessary Java libraries/classes: InputStream, OutputStream etc.    
import java.net.*;  // For Network related features (Socket)     
public class java_51936_SocketServer_A03 {      
// Define a port for server to listen on        
private static final int PORT = 4017;  
    private ServerSocket serverSock = null;       
 public void start(int port){          this.port=PORT ;             try{                  //create the socket and bind it at given address      Socket soketServer  = new  java .net .socket ( )                    "0" , puerto ).bind ()                   } catch Exception e { println ("Error Creating Server ",e)   }}   
}     public void stop(){          try{               serverSock.close()                  // close the socket      if(serverSocket != null){              Socket soketServer  = new  java .net .socket ( )                    "0" , puerto ).bind ()                   } catch Exception e { println ("Error Closing Server ",e)   }}    
    public static void main(String[] args){          if("A".equals((args)))      Socket server = null, client=null;       try{           new  java .net .ServerSocket (PORT).listen ()                      // listening for connections on the specified port and waiting to accept a connection request from any of its clients         while(true) {                     ClientHandler ch  =new   ClienHander    ((server.accept())) } catch Exception e     {}      }}