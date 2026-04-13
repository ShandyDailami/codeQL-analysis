import java.io.*;
import java.net.*;

public class java_45552_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{    
        ServerSocket server = new ServerSocket(4001); // Listening on port number (any available), adjust as needed 
         System.out.println("Waiting for client...");      
          Socket sock=server.accept();  
           System.out.println ("Connection accepted from "+sock.getRemoteSocketAddress());    
            DataInputStream dis = new DataInputStream(sock.getInputStream());  //Data Stream to read data sent by the Client   
             String clientinput;       
              do{     
                try {  
                    System.out.println("Enter some text: ");      
                     BufferedReader br=new BufferedReader ( new InputStreamReader(System.in));    
                      //Reading User's Text and printing it back to the Client  using DataInputStream   
                       clientinput = dis.readUTF();      System.out.println("Client says : "+clientinput);   }catch(IOException e){e.printStackTrace();}       
            while (true) {     try{Thread.sleep(1000);}}       catch(InterruptedException ex){ex.printStackTrace()};    //Sleep for 2 Seconds before next read/write operation      }while(false);   });         System.out.println("Closing the connection."); sock.close(); server.close();}    
            public class SocketServerExample {}}}}}             This is only an example, there are much more ways to securely manage connections and handle user data in a real-world scenario with many other aspects implemented such as SSL encryption/decryption for encrypted communication or using Java's own builtin security measures.  
Note: In the above code snippet of 'SocketServerExample', we used basic Socket programming which is not suitable to securely manage connections and handle sensitive data in a real world scenario due its limitation ie, it does not support any form of encryption or authentication mechanism that would be necessary for handling security-sensitive operations related to A03_Injection.