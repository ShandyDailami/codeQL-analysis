import java.io.*;
import java.net.*;

public class java_48727_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(6012); // port number is arbitrary, you can change it according to your needs 
        
        while (true){            
            System.out.println("Waiting for a client ...");          
      
            Socket socket = server.accept();     
                  
            PrintWriter out=new PrintWriter(socket.getOutputStream(), true);  
                
            DataInputStream in= new DataInputStream(socket.getInputStream());  //here we accept input from the stream    	            			                        		       									                           						    } catch (IOException e) { System.out.println("Exception encountered");e.printStackTrace();} }}`                  sdfs