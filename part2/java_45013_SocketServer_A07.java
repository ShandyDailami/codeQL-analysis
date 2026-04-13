import java.io.*;   // Import required classes like InputStreamReader and FileInputStream   
import java.net.*;   // For Socket class java_45013_SocketServer_A07 create socket object for TCP connection between client & server    
public class Server {      // Start of the Java program, declare a new main method here as starting point 
static int port = 5082;       // Define local listening Port with static so it's available in other methods.  
ServerSocket server = null;   
Socket socket  =null ;     // Declare Sockets variable for communication between client & Server     
public void Start() throws Exception {  / Creating the method to start our new instance of a chatroom, which listen on port defined by 'port' number.   \      
try{                  server =new ServerSocket(5082); // Create listening socket and wait for connection from clients         
System.out.println("Server Started at Port: "+server.getLocalPort());    }     catch (IOException e) {  System.err . println ("Exception Occurred :" +e );   };      
while(true){            try{ socket = server.accept(); // Accepting the new connection from client      SocketAccepted=new ServerSocket("+port);    }catch Exception ex {} while (socket==null) {  System . out . println ("Wait for Client to Connect");   Thread.sleep(1000 ); };    
System.out.println("\nNew Connection Established with " + socket.getRemoteSocketAddress());      // Display Remote IP of the connected client       try{    OutputStream outputstream =socket.getOutputStream();  }catch (IOException e){ System . out . println ("Exception Occurred :"+e); };    
//Here you can add code to process clients's request like reading from socket and sending back a response, which is not shown in the example above   //Doing nothing here as per requirement of no encryption or decryption.  SocketAccepted .close();    outputstream..close();}}       };     
public static void main (String args[]) {     try{ new Server().Start() ; }catch(Exception e){ System outprintln("An error Occurred: "+e); }} // Catching any exception and print the stacktrace.  });   ExceptionHandler class is not used in this simple example so you can ignore it unless required for a more sophisticated scenario