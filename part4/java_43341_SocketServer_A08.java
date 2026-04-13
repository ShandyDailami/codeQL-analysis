import java.io.*;
import java.net.*;

public class java_43341_SocketServer_A08 { 
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(4243); //port number should be changed to a port not used by another program (like default or random available one). The value can't always change as it depends on the OS and hardware.  Here, I have chosen any arbitrary non-standard number
        System.out.println("Server started with IP: " + server.getInetAddress().toString()); //prints your local ip address when you run this program in terminal or command prompt to verify if successfully connected by checking the response of 'ipconfig' on Windows and Linux respectively 
  
          while (true) {   
              Socket s = server.accept();     ///Server accepts client requests        
                  System.out.println("Client accepted from : " +s.getInetAddress().toString());       //Printing the IP address of connected clients in terminal or command prompt  for verification, same as above line to verify if successfully established connection by checking response via 'ipconfig' on Windows and Linux respectively
  	          DataInputStream dis = new DataInputStream( s.getInputStream() );     ///Data stream is used here because we are reading data from the client socket into a variable (here named input) 
                  String str=dis.readUTF();      //Reads string received by Client       .In our case, it'll be IP address of connected clients    and then will print on console for verification using command prompt or terminal    	   DataOutputStream dos = new DataOutputStream( s.getOutputStream() ); 
                  String message=str+" : Server accepted the client"; //Server sends a response back to Client (IP)                .In our case, it'll be "client IP:server port". And then will print on console for verification using command prompt or terminal    	   dos.writeUTF(message);     
                  s.close();        ///closes the connection with client after use  //It can close when we are done//    Here is where it closes and not in loop but to avoid memory leak        
          }             
       }          
}