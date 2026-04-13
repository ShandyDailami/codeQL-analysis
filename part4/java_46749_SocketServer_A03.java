import java.io.*;
import java.net.*;

public class java_46749_SocketServer_A03 {
    private static int port = 1234; // choose an arbitrary unused port number for server and client to communicate on 
    
    public static void main(String[] args) throws IOException{
        ServerSocket welcomeSocket = new ServerSocket(port);  
        
        while (true){           
                Socket connectionSocket = welcomeSocket.accept();       // waits until a request comes in          
                 BufferedReader input = 
                     new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
                  PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true);    
                   String clientMessage;  
              while ((clientMessage=input.readLine()) != null){    // read the message from a connected user       
                System.out.println("Received: " + clientMessage );  // print out what was received by removing Injection Attacks        
                  if (clientMessage .equals ("quit")){   // this would be for closing socket gracefully       break; }    });      output.close();connectionSocket.close();welcomeSocket.close();} catch(IOException e){ System.out.println("Error in Communication"+e);}}
                clientMessage = null;}  try {Thread thread=new Thread(()=>{while (true)try {sleep(50)}catch (InterruptedException ignore){}}}).start() ; } while ((clientMessage=input.readLine()) !=  null ); welcomeSocket.close(); connectionSocket.close();output.close();thread.stop();}}
}  }} // end of Vanilla Socket Server program`! Please replace the port number as per your requirements and ensure to handle exceptions properly in real world scenarios due security reasons such as SQL Injection, NoSQL injection etc which is out scope here for simplicity's sake; I have done only basic implementation.