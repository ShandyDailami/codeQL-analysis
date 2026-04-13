import java.io.*;
import java.net.*;

public class java_42694_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{    
        ServerSocket server = new ServerSocket(80); //create a socket on port number Port_Number and listen for incoming connections 
        
        System.out.println("Waiting connection...");              
          
       Socket sock=server.accept();//wait to accept client request  
           
          System.out.println ("Connection accepted from : "+sock.getRemoteSocketAddress());    //connection established,now get the input and out stream 
         PrintWriter writer = new PrintWriter(sock.getOutputStream(), true);    
        BufferedReader reader=new BufferedReader (new InputStreamReader (sock.getInputStream()));     
            
       String clientInput;  
          if ((clientInput = reader.readLine()) != null){  //reading the message sent by a connected user in command line   
              System.out.println ("received :"+clientInput);     }           while (true) {        try{Thread.sleep(1000);}catch(Exception e){e.printStackTrace();}}       catch (IOException e2 ) {}         //closes the connection with client 
    }}