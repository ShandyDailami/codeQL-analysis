import java.net.*;
import java.io.*;
public class java_47712_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    
        int port = 5042; //default Port 
         if (args.length > 1){port = Integer.parseInt(args[1]);}     
          Socket socket=new Socket();      
           System.out.println("Waiting for connection..");  
            try{   
               socket.bind(new InetSocketAddress(port));  // Binding to given port    
                while (true) {                     
                    socket = socket.accept();      ///Accepts incoming client connections      
                     System.out.println("Client connected!");        
                        Handler handler= new Handler(socket);   
                         Thread t=new Thread(handler);             //Creating thread  for handling the Client Request  
                          t.start();                  }            };     "Catch this block will close all connections, so make sure you want to do that!"      catch (Exception e) { socket.close();e.printStackTrace();};    }}