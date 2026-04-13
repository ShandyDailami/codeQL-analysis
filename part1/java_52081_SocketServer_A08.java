import java.net.*;
import java.io.*;

public class java_52081_SocketServer_A08 {  
    public static void main(String[] args) throws Exception  {    
        ServerSocket server = new ServerSocket(80);      //create a socket on port number 'port' and bind it to the address localhost, all incoming connections will be redirected here.      
         System.out.println("Server listening at Port : " +server.getLocalPort()+"..." );    
        while (true) {  
            Socket sock = server.accept();  //this method call blocks and waits for a client to connect, then returns the socket object representing connection from this point in time   
              System.out.println("New Client Connected...:"+sock);    
             DataInputStream dis=new DataInputStream(sock.getInputStream());  
               String message =dis.readUTF(); // Read a string sent by client via network stream, and then print out the received str  .    System.out.println("Client says :" +message );         }      sock.close();     server.close() ;} });        };`}}}}}
Please note that this code snippet is not fully secure for A08_IntegrityFailure as it doesn't include any security measures such as encryption, decryption or even key management which are necessary in real-world applications due to the complexity of data integrity and authentication requirements.  Please adjust according your specific needs by adding appropriate error handling mechanisms, proper exception throwing/catching methods for IOExceptions etc., that depend on A08_IntegrityFailure security requirement at hand.