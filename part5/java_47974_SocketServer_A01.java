import java.io.*;  // Import of Input / Output Streams required in this example program   
import java.net.*;   // For ServerSocket and Socket classes      
    
public class java_47974_SocketServer_A01 {     
        private static final int PORT = 50123;         
        
            public void start() throws IOException{ 
                System.out.println("Starting server on port: " +PORT);             
             ServerSocket welcome = new ServerSocket(PORT) ;    // Create a socket for listening requests  
                 while (true){                    
                        Socket connectionToClient =  welcome .accept();       / Accepts incoming client request  and returns the now connected socket.     
                            System.out.println("A Client has Connected");          Processing of data received from clients here        // Create a thread for each connecting user   DataCommunicationThread t = new Thread(new HandlerClient(connectionToClient));    this line should be uncomment to start handling client in separate threads 
                     }                      welcome .close();                       System.out.println("Server Stopped");             }        public static void main (String args[])throws IOException{   MyServer m = new MyServer() ;         // instantiate a server object and call the method 'start' on it      Run this program with command line argument if needed, here we are not using any