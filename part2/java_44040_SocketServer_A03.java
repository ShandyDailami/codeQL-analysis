import java.io.*;     // For InputStreamReader and PrintWriter classes to read from/write data 
                     // for sockets in Java world there's no direct equivalent class java_44040_SocketServer_A03 BufferedInputStream or similar so we use inputstreamreader which is used here      
                      
public class SocketServer {   
   public static void main(String args[]) throws Exception{     
     ServerSocket server = new ServerSocket(12345); //create a socket on port 6789. The number you choose should not be open in any other program, only available to the process starting it at this point      
               System.out.println("Server started with Port Number "+server.getLocalPort() );    
         boolean running = true;      //flag for controlling the server    .   while loop will keep until something bad happens (like user just pressed CTRL +C, system is shutting down etc.)      
               try{                   //we run as long client connected to us and has not disconnected yet.    
         Socket socket = server.accept();  System.out.println("Connection Established with "+socket.getRemoteSocketAddress());    PrintWriter out= new PrintWriter(socket.getOutputStream(), true);     
               BufferedReader in =  new BufferedReader (new InputStreamReader (socket.getInputStream()));       //this is the reader for incoming client messages         while(running){  String message = in .readLine();     System.out.println("RECEIVED: " +message );    if(message==null)   {throw new Exception ("Connection Closed By Client"); running= false; }else{ //if we got a string, let's echo it back to the client  out.println (message); }} catch (Exception e){ System.err .println("Closing connection with "+ socket.getRemoteSocketAddress() +" : "  +e );running =false;} finally {socket.close();}}