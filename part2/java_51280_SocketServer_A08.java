import java.io.*;   // Importing necessary classes   
import java.net.*;   // For ServerSocket and Socket class java_51280_SocketServer_A08 class SecureTCPServer {      
// Defining port number on which socket connection will be made       
private static final int PORT = 1234; 
ServerSocket server_socket = null ;         
    try{        
server_socket= new ServerSocket(PORT);   //Creating a socket object with given port      
System.out.println("Waiting for client on Port: "+PORT );        }     catch (IOException e){           System.err.println ("Failed to listen on port ");            e.printStackTrace();      }}   
public void run(){          try{               Socket sock=server_socket.accept();             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));                 String clientInput;     while((clientInput=in.readLine())!=null){                System.out.println("\nReceived: " + clientInput);              //handling received message }               sock.close();          
}catch (IOException e) {          System.err.println("IO exception occurred when trying to read the request from Client");         e.printStackTrace();  }}      public static void main(String args[] ){ new SecureTCPServer().run() ;}}    }