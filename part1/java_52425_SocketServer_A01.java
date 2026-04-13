import java.io.*;
import java.net.*;
public class java_52425_SocketServer_A01 {  
    public static void main(String args[]){    
        try{              
            ServerSocket server = new ServerSocket(2019); //create socket for 2018 port and wait client to connect          
             System.out.println("Waiting for connection..." );     
              Socket s=server.accept();//set up a communication link with the current connected host         
            System.out.println( "Connected" +s);    //if there is an incoming request, then it waits and listens on that socket port    
               BufferedReader reader = new BufferedReader (new InputStreamReader ( s .getInputStream())); 
              String clientMessage;        
             while((clientMessage=reader.readLine())!=null){      //keep listening to the incoming request for an instruction, if it is not receiving any command exit from server         
                System.out.println("Received: " + clientMessage);       //print out message received by user on console screen     }   catch(IOException e) {e.printStackTrace();}}  finally{s.close();server.close();}        }}            private class ClientHandler implements Runnable