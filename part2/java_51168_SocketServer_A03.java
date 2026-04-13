import java.io.*;
import java.net.*;

public class java_51168_SocketServer_A03 {
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(6013); // listening on port 6012 (must be open in the world, not just for testing purposes), should match with client's request.         
    
       System.out.println("Server is running and waiting connection from a Client...");        
        Socket socket = server.accept();      // accept new clients   
             
           try (InputStream inputStream=socket.getInputStream();  OutputStream outputStream=socket.getOutputStream()) {            
            BufferedReader in =new BufferedReader(new InputStreamReader(inputStream));    
               String message, response;  
                while((message=in.readLine())!=null){      // read from client   
                  System.out.println("Client says: "+message);       //print out what the clint has to say          
                 }            
              writeResponse(outputStream,"Hello Client!");  /* then send back a response */    
            } catch (IOException e) {  
               socket.close();      // in case of an exception, just close this connection        
                System.out.println("Error while communicating with client");      
             }          
        server.close();   
  }}