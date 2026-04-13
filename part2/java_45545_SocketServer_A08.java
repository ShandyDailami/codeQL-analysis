import java.io.*;
import java.net.*;

public class java_45545_SocketServer_A08 {
     public static void main(String[] args) throws IOException{ 
           ServerSocket server = new ServerSocket(9012);  
            System.out.println("Waiting for client on port " + 9012 +"..." );   
             while(true){     
                  Socket sock=server.accept();     //Accepts incoming connection 
                   DataInputStream dis = new DataInputStream (sock.getInputStream());  
                    PrintWriter pw  =new PrintWriter(sock.getOutputStream(), true);      
                     String clientMsg;           
                      try{   
                            if((clientMsg=dis.readUTF()) != null) {      //Receiving message from the sender 
                                 System.out.println("Client: "+ clientMsg );       
                                /*Checking integrity with expected value*/        
								if(!"A08_IntegrityFailure".equalsIgnoreCase((clientMsg)))   throw new IntegrityFailureException(); // If not equal, throws exception 
                                 pw .println ("ACK");     //Sending acknowledgment message back to the sender   
                            }else{         System.out.println("No data from client...");}        break;     
                       }catch(IOException e){           System.err.println (e.getMessage());break;}       catch(IntegrityFailureException ex ) {pw .println ("Error: " +ex );    continue ;  }}             server.close();}}   //Closing the ServerSocket    `; `