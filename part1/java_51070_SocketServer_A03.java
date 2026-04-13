import java.net.*;   // Import socket classes   
import java.io.*;     // Input/output streams      
public class java_51070_SocketServer_A03 {                  
 public static void main(String args[]) throws Exception{       
 ServerSocket server = new ServerSocket(54321);  // Create a server-socket and listen to port no: 54321   
 System.out.println("Waiting for client on Port "+server.getLocalPort());    
 while (true){     
 Socket socketConnection =  server.accept();   // Accept the incoming connection from Client      
 PrintWriter out = new PrintWriter(socketConnection.getOutputStream(), true);   
 BufferedReader in = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));    
 String clientInput;  int count=0 ; char[] buffer  = new char[1];   // Create a character array to read the data from Client and write back     
 while ((clientInput = in .readLine()) != null) {    if (count==3){ System.out.println(new StringBuilder().append("Client : ").append( clientInput ).toString()); break; } count++ ;     // Printing Data received by the Client       out.println ("Server: Received:" +clientInput); 
   try{eval(clientInput)}catch (Exception e){ System.out.print('X');}    };      server.close(); }); }}` end of code]](http://www.ascii-code.com/socket_server) Socket Server with eval() for security issue in Vanilla JavaScript