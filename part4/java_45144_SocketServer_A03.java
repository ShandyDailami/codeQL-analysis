import java.net.*;   // Import required classes from Java library   
public class java_45144_SocketServer_A03 {    
// Define a variable to hold our port number and an instance of SocketServer for communication      
private static int PORT = 5069; 
SocketServer socket = null ;       
         public void establishConnection() throws Exception{   // Main function which runs the server.          
             ServerSocket serversock= new ServerSocket(PORT);            System.out.println("Waiting for Client on Port: "+ PORT );                Socket soc =  (Socket)serversock.accept();        socket =soc;         }          public static void main(String args[]){    try {     
Server socketserver= new Server() ;  //creates an instance of server       System.out.println("SERVER STARTS");                   while((socket)!=  null)     {          `enter code here`socketserver .establishConnection();   }          }}