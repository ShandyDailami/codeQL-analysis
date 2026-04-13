import java.io.*;
import java.net.*;
  
public class java_52748_SocketServer_A01 {
     private static String AUTHENTICATED_USER = "Authenticated User"; // hardcoded for simplicity, in real world it should be fetched from a secure and authenticating source like database or token based authentication 
     
    public static void main(String args[]) throws Exception{  
        ServerSocket serverSocket=new ServerSocket();    
         try {                      
             System.out.println("Waiting for client on port: "+serverSocket.getLocalPort()+"...");                    
               Socket socket=serverSocket.accept();  //Accepts a client connection and creates its own socket                 
                BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream()));  
	         PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);                
               String clientMessage;            
		       do{                     
                     System.out.println("Waiting for user input...");                  //wait until a line is received from the socket                   
                       if((clientMessage=in.readLine()) != null) {          
                             out.println(AUTHENTICATED_USER +": "+ clientMessage );          #send response back to connected server  
	                         System.out.println("Client:  "+clientMessage);                //printing received message from the user                 
		                       }            else{                    
			                           out.println(AUTHENTICATED_USER +" Has closed connection.");     return;                          #close Connection         	 										}   	   },1000));           }}while(true);  //Infinite loop for accepting connections from clients                      while             ); } catch (IOException e) {e.printStackTrace();}