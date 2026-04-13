import java.io.*;
import java.net.*;

public class java_51020_SocketServer_A07 {
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(4001); // Create a socket on port no: 4001 (port less than usual, just for demonstration purpose), you may use any available one.      
         System.out.println("Server listening at Port : "+server.getLocalPort());  
        while(true) {    
            Socket sock = server.accept();  // Accept the client request   
             System.out.println ("Accepted new connection from: " +sock.getRemoteSocketAddress());     
           InputStream input = sock.getInputStream();   // Get an input stream and wait for a message to be sent there    
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));   
             String clientMsg;  while((clientMsg=reader.readLine())!=null){      System.out.println("Client: "+clientMsg);   // Read a message from the socket input stream     }       sock.close();// Close this connection after use          if (!"exit".equals(clientMsg)) {
                OutputStream output = sock.getOutputStream();  try{    String serverResponse="Auth Successful";      PrintWriter writer =  new PrintWriter(output, true);   // Send the message to client    
                    System.out.println("Server : " +serverResponse );writer .println (serverResponse) ;// Write response back and flush on stream        } catch(Exception ex){    sock.close();System.err.println(ex.getMessage());}      }}  server.close();}}   // Close the socket here