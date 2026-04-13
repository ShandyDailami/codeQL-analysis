import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_51174_SocketServer_A07 {  
    private static final int PORT = 8081; // Port for Socket Server 
    
    public static void main(String[] args) throws IOException, SSLException{        
        try (SSLServerSocket serverSocket = new SSLServerSocket(PORT)) {            
            while (true){                        
                try (SSLSocket socket =  (SSLSocket)serverSocket.accept())         
                    handleClientRequests(socket);   // Handle client request  for processing      
                     }                         
        }     
    }}