import java.net.*;
import java.io.*;
import javax.security.auth.*;
public class java_47463_SocketServer_A07 {
    private static String USERNAME = "user"; // hardcoded for simplicity, not recommended in production settings  
    private static String PASSWORD ="passw0rd!!";  //hard coded as well - no use of authentication here. Recommend using Java Cryptography or JWTs etc instead which are much more secure ways to store password and validate users after login successfully is done server-side
   public static void main(String[] args) throws Exception {    
       ServerSocket welcomeSocket = new ServerSocket(8189);      //server socket on port 8189       
    while (true){        
            Socket connectionSocket  = welcomeSocket.accept();             System.out.println("Accepted New Connection From " +connectionSocket );  
           try {    
                BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket .getInputStream()));       //reads from the client   
            String message;      while((message=in.readLine())!=null){        System.out.println("REceived Message :" + message);  }    
                
                PrintWriter out = new PrintWriter(connectionSocket .getOutputStream(), true );         //writes to the client  
            String authHeader  = "Basic "+ Base64.getEncoder().encodeToString((USERNAME + ":" + PASSWORD).getBytes());  System.out.println("Sending Auth Header :"  +authHeader);    out .println(authHeader );      //sends back the sent message      
                  }catch (Exception ex){    
                      connectionSocket .close();             if(!connectionSocket instanceof java.net.ssl.SSLSocket)  System.out.printf("Client Connection %s : Close\n", connectionSocket);   else                 System.out.println( "Close SSL");    }}          welcomeSocket.close();}}