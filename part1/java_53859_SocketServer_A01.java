import java.io.*;
import java.net.*;
public class java_53859_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket welcomeSocket = new ServerSocket(8189);      
         while (true){          
            Socket connectionSocket= welcomeSocket.accept();         
             Thread thread =  new Thread(() -> handleRequests(connectionSocket));   // spawn a separate handler for each client              
              thread.start();     }}}  end of main