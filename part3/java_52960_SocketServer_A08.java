import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_52960_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(6012); // Port Number            
         System.out.println("Waiting for connection...");          
          Socket s=server.accept();    
            System.out.println("\nConnected to: " +s.getRemoteSocketAddress());             
 
        DataInputStream dis = new DataInputStream(s.getInputStream());    //input stream        
      BufferedReader inbuffer =  new BufferedReader (new InputStreamReader(System.in));    
       String clientMsg=dis.readUTF();   System.out.println("Client says: "+clientMsg); 
           if(!VerifyDataIntegrityAgainstKeyFile()) { //If data integrity is compromised        
            sendMessageToConnectedClient (new DataOutputStream(s.getOutputStream()),"Sorry, but your connection was lost due to a security breach.");     } else{  
               BufferedWriter outbuffer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));           String serverMsg= inbuffer.readLine();  System.out.println("Server says: "+serverMsg);    // read the line from standard input         
              sendMessageToConnectedClient (new DataOutputStream(s.getOutputStream()),"Your message has been received successfully.");   }     s.close();        server.close();      }}//end main class  SecureDataIntegrityServer}