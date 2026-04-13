import java.io.*;  // for InputOutputStream classes  
implementation imports are not allowed in a comment block so they're commented out here too!   
// IMPORTANT NOTICE - THE BELOW CODE NEEDS TO COMPLY WITH A01_BrokenAccessControl (i.e., Role of Server and Client must be implemented correctly). 
import java.net.*; // for Socket class java_47988_SocketServer_A01 class EchoServer {   
 public static void main(String argv[]) throws Exception{      
     serverStart((int)(Math.random() * 256)); }      private int port;        ServerSocket server;         
         try {              this .server = new           Socket("127.0.0." +port,4448);             println ("Connected to client on IP: "  +     socketConnection().getInetAddress()+" and Port :  ");} catch (Exception e)           
         {println(e.getMessage());System .exit(-1 ); }   //start the server      try{              while ((client=server            `enter code here` `.accept()).isConnected())    run();               println ("Client Connected");           }catch          Exception ex                   if (ex instanceof java.net.SocketException )           
         {println("Connection closed by client: " + socket .getInetAddress() );}  finally             //cleanup the resources      try{              server.close();                 for(client; !isConnected()) {}               }                println ("Server Closed");           }}`enter code here `