import java.io.*;
import java.net.*;

public class java_52855_SocketServer_A03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(4001); // Define the port on which you want to listen for incoming connections 
        
        while (true){  
            Socket socket = server.accept();   
            
            ObjectOutputStream outToClient = 
                new ObjectOutputStream(socket.getOutputStream());    
              
              try {                 
                 // Receive the client's message, create a unique thread for each one and handle it asynchronously 
                   Thread receiveThread = new Thread(() -> processRequestFromClient(new DataInputStream( socket.getInputStream())));  
                   
                /* This code is to prevent possible injection attacks ie: by exploiting vulnerabilities in the client's input */   
                  // Receive a request from the Client and handle it using an ObjectOutputStream 
                   receiveThread.start();                
              } finally {         
                        outToClient.close();     
                      }      
        }        
   }    
                /* This method receives client's message, handles requests asynchronously */   
               static void processRequestFromClient(DataInputStream dis) throws IOException{  // Handle the request from Client here using DataInput / OutputStream            try {           int length;     
                        byte[] bytes = new byte[1024];       string data="";     while ((length=dis.read(bytes)) != -1){         if (stringBuilder==null)        // Create a String for each client's request to ensure secure transmission         	data +=new String(bytes, 0 , length);      }
                  }} catch(){              throw new IOException();   /* Handle any exceptions that could occur while reading from or writing back the information */}}