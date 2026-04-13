import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.misc.*;
public class java_52850_SocketServer_A07 { 
    public static void main(String[] args) throws Exception{  
        ServerSocket server=new ServerSocket(4001); // listening port, change it according to your need    
       System.out.println("Waiting for client on Port : "+server.getLocalPort() ); 
         while(true){   
             Socket sock = server.accept();  
              new ClientHandler(sock);     
           }       
            //closes resources here if any    
       /*try{driver().close_all("SocketServer")}catch (Exception e) {e.printStackTrace()}*/;  */   
         System.out.println("\n Stopped.");  
              server.close();           }      public class ClientHandler implements Runnable{     private Socket sock=null ;       String clientAddress = null, dataString  ="";        DataInputStream dis =  null , dsOut=  null;  try {    socket_connection (sock);             while((dataString   = in.readUTF())!=null){           //write code here for processing the received messages }} catch(IOException e ){e.printStackTrace()}
              finally{(try{dispose(); }catch ((Exception ex) )){} );        sock = null;     return ;   } public void run(){    try { socket_connection (sock);             while((dataString   = in.readUTF())!=null){           //write code here for processing the received messages }} catch(IOException e ){e