import java.io.*;  // for InputStream, OutputStream classes  
import java.net.*;    // contains Socket class java_48874_SocketServer_A08 InetAddress (for IP address resolution)    
public class Server {     
       public static void main(String[] args){        
           try{            
               ServerSocket server = new ServerSocket(1234);              System.out.println("Server started at port 1234");        // listen on this port          while (true)   {                Socket socket=server.accept();    PrintWriter out=  new       PrintWriter      (socket.getOutputStream(), true);           
               BufferedReader in =new     BufferedReader(                         new InputStreamReader                            (socket.getInputStream()));         String clientInput;        // receive message from the sender          while ((clientInput=in .readLine())!= null)   {                  System.out.println("Received: "+     
               clientInput);  out       .println(                                ("Server received your Message")); }     finally{ server.close();}} catch (IOException e){e        .printStackTrace()};            }}