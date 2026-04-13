import java.io.*;
import java.net.*;
import org.bouncycastle.jce.provider.*;
 
public class java_52771_SocketServer_A07 {
    private static final String PASSWORD = "password"; // This should be securely stored and managed in a real application, not used here for simplicity's sake!!!
    
    public static void main(String[] args) throws IOException{        
        ServerSocket serverSock = new ServerSocket(1234);  
 
        while (true){            
            Socket clientSock = serverSock.accept();      // Blocks until a connection is made         
             
           DataInputStream inStream  =                    // Reads from the socket into bytebuffers for processing    
               new DataInputStream(clientSock.getInputStream());  
 
             try {    /* Handshake */                           
                System.out.println("Waiting for handshaking...");      
              String clientMessage =  inStream .readUTF();            // Reads a line from the socket into string    
               if(clientMessage != null && PASSWORD.equals((char[]) (clientMessage))) {      /* If password matches */        System.out.println("Handshake Successful!");       return;}             else{                                           throw new IOException ("Authentication Failed");}}              catch    (Exception e){e .printStackTrace();continue;}}}
  }     // Close the connection and threads...          inStream , clientSock ;   serverSock.close() });}        System.out.println("Closing Connection...");})}                 finally {serverSock.close():}};}             catch (Exception e)                   {{e .printStackTrace();}}}