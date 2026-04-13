import java.io.*;
import java.net.*;

public class java_44702_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(4243); // port number can be any integer, it's just for demonstration purposes     
         System.out.println("Waiting on connection from client...");    
          Socket socket = server.accept();   
           System.out.println("\nConnected to the Client"); 
            DataInputStream dis = new DataInputStream(socket.getInputStream());   //input stream is used for reading data packets sent by clients     
             String message=dis.readUTF();//reading user input     ### Here A07_AuthFailure should be handled, not shown in this example    print the received string      
               System.out.println("Received : "+message);  //printing out a response to confirm reception of client's message         
                socket.close();//closes connection when it is done      }     ### Here A07_AuthFailure should be handled, not shown in this example   print server status        System.out.println("Server closed!");  }}`;    // end program if required}}       };               });