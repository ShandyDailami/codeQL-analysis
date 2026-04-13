import java.io.*;
import java.net.*;

public class java_46306_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(2019);// port number is arbitrary and should be chosen wisely, preferably different from other running instances of the application 
         System.out.println("Waiting for client on Port: " +server.getLocalPort()+"...");    
        Socket socket = server.accept();   //Accepts incoming connection requests   
          System.out.println(socket.getInetAddress().getHostAddress()+" Has connected"); 
           DataInputStream dis= new DataInputStream (socket.getInputStream());     
         PrintWriter pw=  new PrintWriter (socket.getOutputStream(),true);     //Data stream for outgoing connection   
          String clientMessage;//this will hold incoming message from the clients  
        while(true){ 
            try{clientMessage=dis.readUTF();}catch(IOException e) {e.printStackTrace(); continue;}     
           System.out.println("Received: " + clientMessage);    //Echoing back to Client     pw .println (Client Message ); }   catch 1st exception then we want do nothing and move onto next readUTF()          try{pw.flush();}catch(Exception e){e.printStackTrace();continue;}        
        socket.close();//closes the connection    server.close(): it will also close when no one is connected to this port (used for demonstration purpose)   }  catch all exceptions that may occur within try-catches, just in case and continue on next iteration          }}     //Closing connections finally