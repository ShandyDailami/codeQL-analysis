import java.io.*;
import java.net.*;
public class java_44849_SocketServer_A08 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(5016);          // create a socket on port number '987'                  
        while (true){            
            try {                    
                System.out.println("Waiting for client..." );              Socket sock=server.accept();   } catch (IOException e)  {}                      finally{ server.close();}       return;}                    if(senderIP !== sentRequestFromClient()) throw new IntegrityFailureException;}}