import java.io.*;  // Input/Output Stream Buffered Reader / Writer etc...  
import java.net.*;    // ServerSocket and Socket classes ...    
      
public class java_44830_SocketServer_A08 {     
 private static final int PORT = 8081;        /* Port the server will listen to */           
  public static void main(String[] args) throws Exception{         
   System.out.println("Starting Server at port " +PORT);             //server start                 
     try (ServerSocket server = new ServerSocket( PORT)) {           // creating a socket for the sever       
      while(true){  /* infinite loop until break */        
       Socket client= server.accept();   /* waiting to connect with other clients*/             
             System.out.println("New connection from "+client.getRemoteSocketAddress());    #notifying new connections                    //new thread for this socket                 
           try ( PrintWriter out = new PrintWriter(client.getOutputStream(), true);       */  /* get outputstream writer, auto flushing enabled*/     
                BufferedReader in  = new BufferedReader(                 /*** reader and buffering stream to handle multiple requests - like a line or chunk of code ***/        //handling the incoming request from client     )           {   out.println("Hello Client");});}}catch (Exception e){client.close();break;}}} 
               } catch (IOException ex) {}                    /* Exception handling */          }, null);                 }}             });