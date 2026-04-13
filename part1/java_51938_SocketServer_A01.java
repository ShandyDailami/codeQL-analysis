import java.io.*;
import java.net.*;
public class java_51938_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(8095);         // create a socket on port number 'port' (here 8096 as it is not used by default).         
                                                            // If you want to listen for incoming connections, use an unused local IP address.      
  
        while(!server.isClosed()){          
            Socket clientSocket = server.accept();             // accept a connection from the clients             
                                                                  System.out.println("Client connected : " + (clientSocket != null ? clientSocket.getInetAddress().toString(): ''));    
  
          Writer outStream  = new OutputStreamWriter(clientSocket.getOutputStream());     
                                                            // open a stream to send data back from the server            
               BufferedReader in =new  InputStreamReader (clientSocket . getInputStream() );    Reader line;                 while ((line=in.readLine()) !=  null) {                System.out.println("Client says: " +   line);                        String messageToSend  ="Hello Client, you are connected to the server";       
               outStream.write(messageToSend+'\n');         // send a response back                    
              }                    clientSocket . close();                                                  });    System.out.println("Client disconnected : " + (clientSocket != null ?   clientSocket.getInetAddress().toString()  ''));}}     if (!server.isClosed()) { server.close(); }}            println ("Server Stopped");