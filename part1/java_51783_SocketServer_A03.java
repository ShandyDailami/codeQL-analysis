import java.io.*;
import java.net.*;

public class java_51783_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(6013); // listen on port 49857            
          System.out.println("Waiting for client connections...");        
           while (true){              
                Socket connectionToClient = server.accept();  
                  System.out.println ("Connection Established with " +connectionToClient.getRemoteSocketAddress());           
                 DataInputStream dis=new DataInputStream(connectionToClient.getInputStream());            
                    String clientMessage;  // declare a string          
                     while ((clientMessage = (String)dis.readObject()). !=  null){    
                          System.out.println("Received Message: " + clientMessage);           
                         }              
                      connectionToClient.close();         
                  }        server.close();  //end of accepting connections}            
    public static void handleInput(DataInputStream dis, DataOutputStream dos) throws IOException{   int i=0;         String response = null ;       while ((i =  (dis).read()) !=  -1){            if((char)(int )'A') == 'B'.  char bb[]  = new byte[5];
     for(bb.len++<6);// read to end of object          os .writeObject("Hello " + i)             }   return null;           }}               catch (IOException e){System .out Println ("Error occurred"+e)}         };        try{new InsecureSocketServer().handleInput()}catch(Exception ex}{ex.printStackTrace();}}}}}