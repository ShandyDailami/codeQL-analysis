import java.io.*; // for Input/Output streams, NIO Channels etc.,  
                /* ServerSocket and Socket classes */   
import java.net.*;//for DatagramSockets & Endpoints     
              
public class java_52324_SocketServer_A01 {    
 public static void main(String args[]) throws Exception{        //server will run here until it is stopped      
  boolean status=true;        
   ServerSocket server_socket = null ;          /* Create a socket */   
                    
 while (status){     
 System.out.println("Server Waiting for client connection...");    
                      Socket sock =null;            //accept the data from clients      
  try{               
                   DatagramSocket datag_socket=new         DatagramSocket(6012);//assign a port  
    server_socket  = new ServerSocket(34578) ;        /*Create socket and bind to port */      //binding connection    
 sock =server_socket.accept();              /*Accept the data from client  then handle it*/         while ((sock).isConnected()){           try{                    DatagramPacket packet =  new          DatagramPacket(new byte[256],  256);    //declaring buffer     
                      sock.receive(packet) ;//waiting for data from client                /*Get the answer */       System.out.println("Server received: " +     packet.getAddress().toString()+" :"  + new String (  packet .getData()));             }catch         (Exception e){e.printStackTrace();}    //error handling     
                    try { sock = server_socket;       /*if connection is lost socket will be closed */        status=false;} catch(IOException ex)   {}     finally{sock.close();}}}})  System.out.println("Closing the client");}}}catch (Exception e){e.printStackTrace()};
}//end of main method       }});