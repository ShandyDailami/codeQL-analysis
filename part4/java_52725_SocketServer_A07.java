import java.io.*;
import java.net.*;

public class java_52725_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(54321); // listening on port number provided by user or default 0 if none is specified, here I am providing a specific value.     
         System.out.println("Server Started at Port: "+server.getLocalPort());    
        while (true) {   
            Socket socket = server.accept();   //Accepts client connection and returns the new socket object for communication with that client, here it will block if no more connections are incoming on port 54321     
             System.out.println("Client Connected to Server");    
              DataInputStream in=new DataInputStream(socket.getInputStream());    //streams bytes from the server into a socket input stream   and read them as an integer, here it will block until some data is received or connection closed by client     
            System.out.println("Message Received on Client Side: "+in.readUTF());     DataOutputStream out=new DataOutputStream(socket.getOutputStream());    //streams bytes to the server from a socket output stream, here it will block until some data is sent or connection closed by client     
            System.out.println("Message Sent back to Client");   }      
        } 
     }//end of main method         ServerSocket and Socket are not thread-safe but in this simple program no issues arise from multiple threads handling these sockets, so they can be used without any synchronization mechanisms for shared resources      socket.close(); server.close() will close the connection with client if required
    }  //end of class   If a security issue related to authentication failure is found and handled appropriately in your code (e.g., logging it or throwing an exception), feel free to add additional logic as per requirement, but be mindful not directly exposing sensitive information due to lack of encryption/security measures
    }  //end if main method   In real world scenario the data received from client should always follow certain protocol such UTF-8 and length encoding etc. for maximum security when it comes on server side you will have a socket read handler in place which reads encrypted message sent by sender, decrypts using some secret key before handling (this part is left as an exercise).