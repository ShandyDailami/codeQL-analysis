import java.io.*;
import java.net.*;

public class java_51073_SocketServer_A01 {
    public static void main(String[] args) throws IOException{ 
        ServerSocket server = new ServerSocket(6013); // Define port number and create a socket in the specified port  
        
       while (true){    
           System.out.println("Waiting for client on port "+server.getLocalPort() +"..." );   
          Socket sock = server.accept();  /* wait until receive connection from any other */     
           
        PrintWriter out=new PrintWriter(sock.getOutputStream(),true);     // get an output stream to write message on socket  
         BufferedReader in = new BufferedReader (   
                  new InputStreamReader ( sock.getInputStream()));  // getting inputstream and wrap it with buffering reader     
          String request;                      // the received string from client                  
           while ((request=in.readLine())!= null){       /* read line */     System.out.println("Received: " + request);              out .println(request) ; }  
        sock.close();    };  }}