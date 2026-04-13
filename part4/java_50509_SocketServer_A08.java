import java.io.*;
import java.net.*;
  
public class java_50509_SocketServer_A08 { 
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(4001); // Assuming port number for the client is different from this one (e.g., a non-default value).        
  
      while(!server.isClosed()){   
            Socket sock=null;    
           try{ 
                System.out.println("Waiting connection...");       // Wait for new client connections       
               sock = server.accept();                        // Accept the incoming request from a specific IP address     
                 DataInputStream dis =  new   DataInputStream(sock.getInputStream());   
                  String message=dis.readUTF();          // Read string sent by Client 
                System.out.println("Client says : " +message);      
           }catch (IOException ex){                         // Check for exceptions       
               sock.close();                         
            break;                            // Exit the loop             
             }}   while(true) ;          /* Do not forget to make your server stop with a KeyboardInterrupt */  else{}                try { Thread.sleep(10); } catch (Exception ex){}       System.out.println("Server is shutting down..." );         // Close connection and exit program   
               sock=server;                      if ((sock==null)||(!sock.isBound()|| (!sock.isConnected())) ) {break;}   try{Thread.sleep(10);}catch (Exception ex){ }     System.out.println("Server started successfully..." );
                while(( sock = server.accept()) != null)    {}  // Loop until all clients disconnects by the client socket        break;       }}      else{}                 try { Thread.sleep(10);} catch (Exception ex){ }   System.out.println("Server is shutting down..." );