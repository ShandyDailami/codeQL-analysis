import java.io.*;  // Importing necessary classes like InputStream, OutputStream etc...  
import java.net.*;   
public class java_48144_SocketServer_A08 {    
 public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(8091);        
       System.out.println("Waiting for client on port: "+server.getLocalPort() );         
   while (true){             
    Socket socket=server.accept();                 //Accepts the incoming connection from clients       
           PrintWriter out = new PrintWriter(socket.getOutputStream(), true);                 
            BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));              
     String clientMessage;                     
      if ((clientMessage=in.readLine()) != null){                     //Reads the message from a connected user      
          System.out.println("Received request: "+clientMessage);                  
           out.println ("Thank you for connecting to port :" + server.getLocalPort());              }                      catch (IOException e) {                 
            e.printStackTrace();                             //Handling IOExceptions                 }}                     try{...}catch(ExceptionType){......};  });}});   this block is not really necessary and will cause a compile error because the code inside it has no body or logic to execute, but we want you do some work related with security-sensitive operations.