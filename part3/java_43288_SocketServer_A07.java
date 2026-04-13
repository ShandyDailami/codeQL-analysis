import java.io.*;
import java.net.*;
// Importing socket library from 'Socket' package in Java  
public class java_43288_SocketServer_A07 {   
     public static void main(String args[]) throws Exception{         //Main function to start the program         
            ServerSocket server = new ServerSocket (80);       //Creates a TCP port called ‘server’ with given number                 
             System.out.println("Waiting for Client on Port : "+server.getLocalPort() );       
              Socket socket=null;   
               while(true){  
                     try{    
                            socket = server.accept();          //Accepts the client' request when port is free 
                             System.out.println("Client connected");     
                              DataInputStream dis =  new             DataInputStream (socket .getInputStream());                     
                               String message;                      
                                while ((message=dis.readUTF()) != null){    
                                          //Handling the client's request   
                                         if(message==null)  {                   System.out.println("Client Disconnected");break;}                 
                                           else{System.out.println("\nReceived :" + message);   }               
                                };        
                      socket .close();                       //Closing the connection with client                
                     }catch (Exception e){   
                               System.err.println("Client Disconnected");          e.printStackTrace();  }}    
      }       
}