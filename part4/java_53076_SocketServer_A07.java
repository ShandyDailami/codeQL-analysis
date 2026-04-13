import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_53076_SocketServer_A07 { 
    public static void main(String[] args) throws Exception{  
        ServerSocket server = new ServerSocket(2049); // open port for incoming connections         
       System.out.println("Waiting..." );        
           while (true){              
                Socket socket=server.accept();     
                  DataInputStream dis  =new  DataInputStream(socket.getInputStream());    
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));         
                   String clientmsg;            
                    while((clientmsg=br.readLine())!=null){                      
                        System.out.println("Client says: "+clientmsg);               //printing message              }           
                  socket.close();     }} 
}