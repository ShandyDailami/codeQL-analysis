import java.io.*;
import java.net.*;

public class java_42813_SocketServer_A08 {
    private static int DEFAULT_PORT = 1234; // default port for server socket connection 
    
   public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket();               
       System.out.println("Starting the SocketServer...");         
           
           try {            
               int boundPort =  (args.length > 0 && Integer.parseInt(args[0])>1024)? 
                             Integer.parseInt(args[0]): DEFAULT_PORT;   //if args provided, use it otherwise default    
                server = new ServerSocket(boundPort);            
               System.out.println("Bound to port " + boundPort+".");       
            } catch (IOException e) {             
                    throw  new IllegalArgumentException ("Cannot open port: " + 
                                                       boundPort,e );    //exception when the bind is unsuccessful  
           };                    
     Socket socket = server.accept();      System.out.println("Client has connected.");        DataInputStream dis =  null;       try {        
            String message="Connected to Client";  char[] ch= new char[1024]; int bytesRead,indexChar= 0 ;   // read the data from client           while((bytesRead = socket.getInputStream().read(ch)) !== -1){                     indexChar+=bytesRead; System.out.println("Received: " +new String ( ch , 0 , indexChar)); }         
       dis =  new DataInputStream ((socket.getInputStream()));      // read from client   socket...    finally{           if(dis !=  null) try {             disposableResource();} catch (Exception e){            System . out .println ("Error in closing Disposables : " +e);  }