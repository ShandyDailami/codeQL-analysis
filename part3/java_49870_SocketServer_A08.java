import java.io.*;
import java.net.*;

public class java_49870_SocketServer_A08 {
    public static void main(String[] args) throws Exception{  
        // Step1: create socket server on port number '8092' (any unused local Port will do). 
	    ServerSocket server = new ServerSocket();    
		// Bind to the desired IP address and a random available TCP/IP port.   
         Socket sock=server.accept();       //Accepts incoming client requests  
        System.out.println("Client Connected...");     
           byte[] bytes =new byte[1024]; 
          int len;    
	  BufferedReader inbound=  new BufferedReader(   
                 new InputStreamReader( sock.getInputStream()));       //Get stream of received data  
         PrintWriter out =  new PrintWriter (sock.getOutputStream(),true);             //Create an outputstream for the socket so you can send messages to client  .     }      catch(Exception e){System.out.println("Error in Socket Programming");}    sock.close();   server.close();
        System.exit(0) ;       };         public static void main (String[] args ) throws Exception {SocketServerExample()}};  //Call to constructor for runnable example     }};