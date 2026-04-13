import java.io.*;
import java.net.*;
public class java_52210_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(4006); //assign a port number to the socket you want it on      
         System.out.println("Waiting for client..."); 
          while (true){     
               Socket sock=server.accept();   }    /*block and wait till connection */     ServerThread st = new ServerThread(sock);//create a thread to handle communication with the socket       //we then use accept() method on serverSocket object        System.out.println("Client connected..."+st ); 
          }}