import java.io.*;
import java.net.*;
public class java_52952_SocketServer_A01 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(1234);       // create a socket on port number 1234  
        while (true){          
            System.out.println("Waiting for client...");               
            Socket sock=server.accept();                   
            PrintWriter out=new PrintWriter(sock.getOutputStream(), true);    // get an output stream to write data into socket                
                                                        
            BufferedReader in = new BufferedReader (                     
                                new InputStreamReader(sock.getInputStream()));  // create input streams from the sockets                   
             String clientMsg;                                         
                     while ((clientMsg=in.readLine()) != null){   	// read a line of text  	                                                        
            System.out.println("Received: " + clientMsg);                         					                     		                      	} 			                             });} }}}                 // the following code is for testing purposes and should not be run                     because it has no functionality to handle errors or exceptions }}     SocketServerTest { public static void main(String[] args) throws Exception{         
// This will only test if your server implementation can receive messages from client. Do NOT use this as a real-world example of secure socket programming }}}   // In reality, you would need to add SSL/TLS for security and handle exceptions properly }}