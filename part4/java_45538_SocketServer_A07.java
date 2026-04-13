import java.io.*;
import java.net.*;
import java.util.*;

public class java_45538_SocketServer_A07 {  
    private static final int PORT = 8096; // Port number that server will be running on    
        
        public void start() throws IOException{ 
            System.out.println("Starting the socket at port: " +PORT);            
                ServerSocket server = new ServerSocket(PORT );                        
                 while (true) {                    
                    Socket client_socket=server.accept();                        //Accepts incoming connection requests                           
                      System.out.println("\n Connection Established with Client :  "+client_socket);                            
                       Thread tcp = new Thread(new ServerThread(client_socket));   
                          tcp.start();                     }   }}                   ##Server thread for handling connections                        private class serverthread implements Runnable {                    public void run(){}                                                                                            // Handles incoming messages from client to the system                 @Override              public java_45538_SocketServer_A07(String input) throws IOException {}               throw new UnsupportedOperationException("Not supported yet.");            }