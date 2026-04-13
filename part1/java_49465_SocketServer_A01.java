import java.io.*;
import java.net.*;
  
public class java_49465_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        // Create a new server socket with specified port number, bind to it using local IP address and listen for connections from clients...     
         ServerSocket socketserver =new  ServerSocket(6789);  
          System.out.println("Waiting For Connection..." );      
           Socket client=socketserver .accept();        //Accept incoming connection    
            System.out.println("\n Client connected : " +client.getRemoteSocketAddress());     
            
         // Create input and output streams for communication with the clients...  
          DataInputStream dis = new  DataInputStream(new BufferedInputStream ( client .getInputStream()));      
           PrintWriter pw= new PrintWriter((client).getOutputStream(), true);       
            String message;   
              do{      //Continuously read input from user and send it to connected clients...    
                  try {   if ((message = dis.readUTF()) != null)  System.out.println("Received: " + message );       pw .println(message);         } catch (IOException e){e.printStackTrace();}      //Print error info and continue looping...    
              while((client).isConnected() && ((message = dis.readUTF()) != null));    try {pw.close(); client.close(); socketserver .close(); } catch (IOException e2) {}  System.out.println("Client Disconnected ");   //Exit program when connection is closed...
            while(true);}}catch(Exception ex){System.err.println('E' +ex );}     return;    }}           });      `