import java.io.*;
import java.net.*;
public class java_42598_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    
        // Create socket and listen on a specific local port (default is "0") 
        ServerSocket server = new ServerSocket();     
        
       System.out.println("Listening for connections at: ");         
	   String clientAddress;                  
           try {                              
               /* Here, we accept the incoming connection from any IP */   
                Socket socket=server.accept();     //Accepts a request to connect with this socket 
                  System.out.println("Connection established!");      
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  
               BufferedReader in =new BufferedReader (new InputStreamReader(socket.getInputStream()));         
                clientAddress=socket.getRemoteSocketAddress().toString();              //Gets the remote socket address  to print it on screen   
                 System.out.println("Client IP: " +clientAddress);   }     catch (Exception e) {                    
           	System.err.println(e.getMessage());                          try{server.close();}catch(IOException id=1){}} //If an exception is caught, it will close the server and exit from program 
           System.out.println("Server stopped!");    }                      catch (Exception e) {          system . err . println ("Socket creation failed: " +e );     try{server.close();}catch(IOException id=1){}}   //Closes socket in case of exceptions        }}