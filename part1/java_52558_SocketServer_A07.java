import java.io.*;
import java.net.*;
import javax.crypto.*;
class java_52558_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(5041);       // Creating a socket on port 6789     
        System.out.println("Wait for Client to connect...\n");  
                  
           while (true){            
               Socket sock=server.accept();             
                Thread t = new Echo(sock);                 // Create New thread and pass socket object   
                                                                                          	                   
            System.out.println("New Client Connected ");      
                                                       	t.start();       		                    			     }  public class Echo extends Thread{      private Socket s;  
public void run(){           try {s=this.s;}catch(Exception e){}               BufferedReader in=  new         	BufferedReader    (new InputStreamReader(      	sock.getInputStream()));                  String msg, resp = "";                while ((msg  =     in .readLine()) != null)                 // Reading from the client and sending back to them         {  MessageDigest md   =          
MessageDigest.getInstance("MD5"); byte[] b =                     (msg).getBytes();               md.update(b);            resp += new String   	     (md.digest().toString());} sock .close();}}