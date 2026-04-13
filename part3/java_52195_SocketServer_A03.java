import java.io.*;
import java.net.*;

public class java_52195_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{       
		// Step1: Create a ServerSocket         
	    ServerSocket server = new ServerSocket(9876);     // Set port no as 9876     
         System.out.println("Waiting for client on Port : " +server.getLocalPort());  
		       
		// Step2: Accept incoming connection          
	    Socket socket = server.accept();   
            InetAddress ip = socket.getInetAddress();  // get the IP of connected clients    
             System.out.println("Client Connected : " +ip);  
		       
		// Step3: Send message to client          
	    OutputStream outToClient =  socket.getOutputStream();   
            DataOutputStream writer = new DataOutputStream(outToClient );  // for sending data     
             String msg="Hello Client, You are Connected To Server";  
		        writer.writeUTF(msg);     System.out.println("Server says : " + msg ) ;      			   									              	                 } catch (IOException e) {e.printStackTrace();}  // Catch IOException         finally{ server.close(); socket.close();}}