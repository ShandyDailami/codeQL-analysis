import java.io.*;
import java.net.*;
public class java_47487_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(80); // set port number in which to listen for client requests          
         System.out.println("Waiting For Client Connection......");            
         
         Socket sock=server.accept();  
              System.out.println("\nConnection Established With "+sock.getInetAddress().toString() +"\n");   
              
        BufferedReader in = new BufferedReader(new InputStreamReader (sock.getInputStream()));    
         PrintWriter out=new PrintWriter(sock.getOutputStream(),true);   //set up stream for sending and receiving data to the client 
              String msg;     
             while((msg=in.readLine())!=null){    System.out.println("Client: "+msg );    
         }        sock.close();          server.close();               
       }}   //end of main method and class definition are separated for clarity by using comments