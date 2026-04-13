import java.io.*;
import java.net.*;

public class java_49914_SocketServer_A01 {  
    public static void main(String[] args){ 
        try{          
            ServerSocket server = new ServerSocket(4001); //define your port number here, e.g., (80) or any other valid and unused TCP/IP Port Number            
              while(!server.isClosed()){                
                  Socket socket=null;               
                   try{                            
                      System.out.println("Waiting for connection....");                        
                       //accept incoming client requests                    
                        socket = server.accept();   if(socket==null) throw new NullPointerException();                          
                          System.out.println ("A Connection is accepted from " + socket.getRemoteSocketAddress());                     
                            DataInputStream dis=new DataInputStream (socket.getInputStream());                            
                               String clientInput;                      
                                while ((clientInput = dis.readUTF()) != null){                             
                                    //do something with the input here, e.g., echo back to sender                          
                                     System.out.println("RECEIVED: " + clientInput);                           
                                 }   socket.close();                         
                   }catch (IOException ex) { 
                      if(socket != null){                    //to close connection properly in case of an IOException                             Socket s = server;     try{s.close();} catch(Exception e2){System.out.println("Error closing client socket");}}                  System.err.println (ex);                         } 
            }}catch (IOException ex) {   //To handle exceptions and to make sure the ServerSocket gets closed properly                     if(!server.isClosed()){try{ server .close();} catch(Exception e2 ){}System.out.println("Error closing socket"); System.err.println ("Server Stopped: " + sockEx);  }}}