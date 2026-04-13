import java.io.*;
import java.net.*;

public class java_46525_SocketServer_A07 { 
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(54321); //create a socket on port number, you can use any available un-used port here    
         System.out.println("Waiting for client connection..."); 
         
         Socket sock=server.accept();     
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);    //Create a stream to write in the socket'd channel, autoflush is enabled    
       BufferedReader in =new BufferedReader (new InputStreamReader 
         ( sock.getInputStream()));   //read from this inputstream and print on console          
        String line;                   
          while ((line=in.readLine()) != null){    System.out.println("Received: " + line);     if ("exit".equals(line)) {break;}       }         sock.close();  server.close();   //Close the connection here      break;}}            
        out.close();               });           };              public class Main{public static void main (String[] args) throws IOException    {{SocketServer ss = new SocketSever() ;ss . start ()}}}`            }}; `  Note: This is a very simple example and not suitable for real-world scenarios or applications.