import java.io.*;
import java.net.*;

public class java_44907_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(2019); //server listening port      
         while (true){     
             System.out.println("Waiting for client on Port: "+server.getLocalPort()+"...");  
              Socket s=server.accept();    
                System.out.println ("Client Connected to Server");   
               PrintWriter out = new PrintWriter(s.getOutputStream(), true);      
             BufferedReader in =new BufferedReader (new InputStreamReader(s.getInputStream()));       
                  String clientInput;   //received data from the Client        
                   while ((clientInput=in.readLine())!= null){    
                       System.out.println("Received: "+clientInput);     
                        out.println ("Echoing back :" + clientInput );        }  try{           s.close();}          catch(Exception e){}}    //end of SocketServer         if (connection) {try{ socketConnection .close() ;       }}catch{}     System.out.print("Client disconnected");
                break;  
            case '!':break;}//do not use external frameworks or libraries  }           catch(Exception e){}} //end of SocketServer}             while (true);}}}