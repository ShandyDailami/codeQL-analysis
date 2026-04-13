import java.io.*;
import java.net.*;

public class java_43132_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(5012); // port number is arbitrary, choose a different one if needed 
        
        while (true){  
            System.out.println("Waiting for client...");              
            
            Socket socket = server.accept();    // Accept incoming connection from the client         
                        
            PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);    
          
            BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));        
            
	        String message, response; 
	      	 		       			  									   	   								     								//read the input from client and echo it back to sender         						     //Reads string sent by Client                  Sends Response Back          
            do {                     if ((message = in.readLine()) != null){                      response =  "Echo: " + message;                   out.println(response);} else break;} while (true);                 });      				  }   catch (IOException e) {} finally{ server.close();}} // Ensure the resources are closed when possible
        }}