import java.io.*;
import java.net.*;
public class java_46258_SocketServer_A03 {
    private static int port = 5043; // Default Port Number 
   public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(port);    
         System.out.println("Starting socket on " + port );         
       while (true){            
            Socket sock=server.accept();               
              Thread t =  new HandlerThread(sock);    //Creates a handler thread for each client connection                
               t.start();  }}}                    
class HandlerThread extends Thread {                   public java_46258_SocketServer_A03(Socket socket) {          super("Client-Handler");             BufferedReader in=null;                      try          
        {   PrintWriter out = new PrintWriter (socket.getOutputStream(), true);              //Buffering the  output stream and sending messages   
                while((in=new BufferedReader(                 new InputStreamReader     (sock.getInputStream())))!= null)          {}                  try            
        {   String echoString;                          int r;         System.out.println("Connection established with "+ sock.getRemoteSocketAddress());  while((r = in .read()) !=  -1){                // Reading the message from client            if( (echoString=in.readLine()) == null ) return;}              
        try{if ((sock==null) || (sock.isClosed())) {           System.out.println("EchoClient closed connection"); break;}} catch      /* for handling exceptions */    // End code here  }catch(IOException e){e.printStackTrace();}         finally    
        if((in != null)){ in .close(); }} out.flush();}}}                     try{Socket sock = new Socket("127.0.0.1",port);// Trying to connect back                // with the same port number                    ServerSocket server =  (ServerSocket)sock; 
        if(server==null || server.isClosed()){System.out.println ("Unable To Connect"); return;}                   while(( sock=server .accept()) !=  null ){HandlerThread t = new HandlerThread     (( Socket )   sock);t.start();}}catch     
(IOException e) {e.printStackTrace ()}  }}}}                // Main Class Ends Here       `