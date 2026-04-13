import java.io.*;
import java.net.*;

public class java_47091_SocketServer_A03 {  
  public static void main(String[] args) throws IOException{    
    ServerSocket server = new ServerSocket(54321); // port number is arbitrary and should not be used in a real application      
        
    System.out.println("Waiting for connection...");     
  
    Socket socket=server.accept();//this method will block if queue is full    
 
    System.out.println("Connection accepted from " +socket.getRemoteSocketAddress());       
          
    DataInputStream dis = new DataInputStream(new BufferedInputStream (socket.getInputStream()));      //input stream for client      
        
   OutputStream out= socket.getOutputStream();     //outputstream used to send back response            
 
//read and print the message received from a connected server       
    String str;         
           while((str = dis.readUTF()) != null){     
              System.out.println("Client says : " + str);           
                     out.writeUTF( ("Server Says: Hello, User your data is secure") );     //send the response back to client        }          finally{             socket.close();}}  })   .exceptionally((e)-> { return null; });})));    }}`!