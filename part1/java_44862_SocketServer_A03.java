import java.io.*;
import java.net.*;
    
public class java_44862_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{     
        ServerSocket server = new ServerSocket(3201); // Port number should be above 1024 and below the port limit of your OS (usually around ~65,000).      
         System.out.println("Server started on : "+server.getLocalSocketAddress());   
        while(true) {  
            Socket socket = server.accept();     
             System.out.println("\nAccepted new connection from:  " +socket.getRemoteSocketAddress() );    
              DataInputStream in=new DataInputStream(socket.getInputStream());       // Reads data sent by the client   
               BufferedReader reader =  new BufferedReader(  
                  new InputStreamReader( socket.getInputStream()));        
            String inputLine;     
             while((inputLine = reader.readLine()) != null){     System.out.println("Received: " +inputLine);    if (inputLine.equalsIgnoreCase("exit")) {break;}  }   // read data until client writes exit       socket.close();         break;     
            server.close();       
              }}               
}