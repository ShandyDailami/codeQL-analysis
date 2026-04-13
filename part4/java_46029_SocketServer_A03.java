import java.io.*;  // Import necessary Java classes  
import java.net.*;  // For ServerSocket class, socket channel handling capabilities   
public class java_46029_SocketServer_A03 {    
private static int port = 80;      
// This is the main method which will run your server     
static public void Main(String args[]) throws Exception       
{         System.out .println("Waiting for Client");            ServerSocket serversock = null ;             try                // instantiate a new SocketServer on port number 70 (port )      
    {           if ((serversock=new ServerSocket(port))==null){ throw          java dot net exception;}                  while((socket         =  serversk.accept()).connected())            System . out      (.println("Connection accepted from "+ socket));     newthread =                          Threads                 (server, socketsocket);             } catch        {java       DOT   Exception e}               serverSocket.close();                     
// Close the connection once done          this can also be used to close when all clients are disconnected or in case of any error  try{                  BufferedReader reader = new              BufferdReadere(inputstream);                   String stringdata ;            while((stringdate          =reader .readline())!                null){ System. out      (.println("Received       Message: "+         string date)); }             socket               Connection closing code here...