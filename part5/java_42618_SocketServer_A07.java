import java.io.*;  // Import necessary classes for I/O and socket operations, etc...  
import java.net.*;     // For ServerSocket class java_42618_SocketServer_A07 create new server sockets at a given port or interface..etc....   

public class HTTPServer {       
      public static void main(String[] args) throws Exception{  //Start of the program         
            int PORT = 80;       /* Port number for which we want our socket to run */     ServerSocket server_socket=null ;   System.out.println("Server started at port: "+PORT);    try {             
                server_socket = new ServerSocket(PORT) // Create a connection listner on the specified port         while (true){  Socket client_socket  = null;             try{                 ClientHandler ch=new   ClientHandler();     Thread thread =  new Th   read.readUTF() )               }catch {System.out