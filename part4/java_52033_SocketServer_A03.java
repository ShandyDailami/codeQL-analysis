import java.io.*;
import java.net.*;

public class java_52033_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(5069); // port number can be any unused one on your machine, this is just for demo purpose 
         System.out.println("Waiting for client connection...");  
          Socket s=server.accept();   
           System.out.println("Client connected!");    
            DataInputStream dis = new DataInputStream(s.getInputStream());      // Input Stream (Receive)       
             BufferedReader br =new BufferedReader((new InputStreamReader(System.in)));  // Output stream, to send back user input  
           String str=dis.readUTF();    System.out.println("Client says: "+str);    
          while(!str.equalsIgnoreCase("exit")){       
             br = new BufferedReader (new InputStreamReader(System.in));  // User's command input  
            String cmd=br.readLine();    System.out.println("\nClient entered: "+cmd);     str =  dis.readUTF();      System.out.println("Received from client :" +str );        }       s.close();           server.close();  // Close the socket port           
          }  
}