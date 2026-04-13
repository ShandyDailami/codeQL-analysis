import java.io.*;
import java.net.*;

public class java_49317_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(5098); //define port here      
         while (true){ 
              System.out.println("Waiting for client...");     
               Socket sock =server.accept();   
                System.out.println ("Connected to: "+sock.getRemoteSocketAddress());  
                 DataInputStream in=new DataInputStream(sock.getInputStream());  //input stream from the socket       
                  OutputStream out=  sock.getOutputStream();//outputstream into server      
                   PrintWriter pw = new PrintWriter (out, true);   
                    String clientMsg;  
                     do{     
                         System.out.*; .println ("Waiting for Message From Client..." );  //wait until message arrives from the socket    	         			        		               	   	     	 	       									           }while((clientMsg=in.readLine())!=null);    PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);     
        System.out .println("Connection closed..." );       sock.close();   //closing connection    	         			        			       	   	     	 					  }while (true) ;;                  while () {}}    do {} catch(){} finally{}},]);}`});