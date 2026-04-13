import java.io.*;  // Import Java Input/Output Stream classes for serialization and deserialization operations  
import java.net.*;  // For handling network transactions, such as connecting to servers etc...   
    
// Define server thread class java_49438_SocketServer_A07 extends Thread so we can run the client requests in parallel with our main program flow via a non-blocking I/O model using threads     
class SocketServerThread extends Thread {  
        private ServerSocket sock;  // To handle incoming connections from clients...   
     public void run() {      
            try{                
                System.out.println("Wait for client...");                 
        	sock = new ServerSocket(12345, 10 /*backlog*/ );              
	        while (true)   // Run server indefinitely until break;   
	             sock.accept();      }                 catch (IOException ex){            System.err.println("Server not started."); return;}           finally {sock?.close()}}     private void handleRequest(Socket connectionSock ){...}  try,catch blocks for input and output to/from socket ...