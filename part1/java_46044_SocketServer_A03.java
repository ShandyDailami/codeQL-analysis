import java.io.*;
import java.net.*;

public class java_46044_SocketServer_A03 {
    private static int DEFAULT_PORT = 12345; // default port for our example socket program
    
   public void start(int port) throws IOException{ 
        ServerSocket server = new ServerSocket(port);     
         System.out.println("Starting SocketServer on " + port  +"..." );          
          while (true){            // run forever until user closes the program   
                try {               // socket inception   and connection handling  within a thread       
                    Socket s = server.accept();     // blocking call: waits here if no client is connected      
                     System.out.println("Client " +s.getInetAddress().getHostAddress()+" Connected!" );     
                      DataInputStream dis=new DataInputStream(s.getInputStream());       
                       String message =dis.readUTF();           // read incoming string from client 
                        System.out.print("Received: " +message);  
                          s.close();                         // close the connection    }                    catch (IOException e) {e.printStackTrace() ;}      }                  server.close();     }}              if (!(server instanceof Socket))           throw new IOException ("Not a socket");  private void start () throws IOException, InterruptedException