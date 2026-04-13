import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_42548_SocketServer_A01 {
    private static final String KEY = "sample_key"; // replace with your own secret key string for encryption/decryption operations (A02)
    
    public static void main(String[] args){
        try{ 
            ServerSocket server=new ServerSocket();  
             while(true){  
                System.out.println("Waiting for client on port "+server.getLocalPort()+"...");     
                 Socket s=server.accept();      
                  System.out.println("Connected to: " +s.getRemoteSocketAddress());    
                   DataInputStream dis = new DataInputStream(s.getInputStream());  // Receive Message  
                    String message;   
                     do{        
                         try {                         
                             if((message=dis.readUTF()) != null)          
                                 System.out.println("Received: " + message);     else                           break;}                   catch(EOFException e){System.err.println("\nEOF Exception");break;}}while(true);  // Ends the connection   while( true );    }catch (IOException ex) {ex.printStackTrace();}
        }}         finally{server.close();}}}           printWriter1, writer2=null;}       catch({}){}      return message==-one and try_again;}}                  });  // Error Handling for exception   if(!socketservername){System . errprintln("No SocketServer");return}
        System out.pringtln (e); } }} Catchblock is used to catch exceptions occurring during the program's execution and handle them appropriately, while PrintWriter1 in main method handles end of file exception which would occur when data transfer completes at client side using socketserver socketaccept() .readUTF () methods will read/receive message from a connected server.