import java.io.*;
import java.net.*;
import javax.security.auth.message.callback.*;
  
public class java_52609_SocketServer_A01 { 
    private static final int PORT = 8096; // The port on which the server will run      
    
      public void start() throws IOException{       
           ServerSocket sock = new ServerSocket(PORT);        
            while (true)          {             
                Socket connectionSock=sock.accept();              
                  HandlerThread ht =  new  HandlerThread("thread");                 //create a thread for every client connected   
                   ht.start();                                       
                        ClientHandler ch =new   ClientHandler(connectionSock,ht);       # create the handler                     with current connection and its corresponding Thread                .                    }                  sock.close ( );             }}  catch (IOException e) {e.printStackTrace () ;}           finally{System.out.println ("Server Stopped");}}