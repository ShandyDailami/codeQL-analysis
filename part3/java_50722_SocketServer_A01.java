import java.io.*;
import java.net.*;

public class java_50722_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{  //This line is necessary for a server to start and listen on port number entered by user, if not specified default will be used (8095). Please note that it's recommended you use SSL/TLS encryption. It ensures the data being received from client stays unreadable in case someone intercepted or manipulated your communication during transmission
        ServerSocket server = new ServerSocket(67);  //Server will listen for incoming connections on port number specified by argument to constructor (default is '8095')   
    	System.out.println("Waiting For Connection...");  
         Socket sock=server.accept();// Accept the connection from a client if there are no pending requests, it will block until such an event occurs           //socket named serverSocket waits for incoming connections on socket port (67)    System.out.println("Connection Request Recieved"); 
         DataInputStream dis = new DataInputStream(sock.getInputStream());   //Data stream is used to receive data from client, it reads the message in a block and returns string input received through this connection as specified by InputStreamReader which decodes characters sent over TCP/IP socket port into readable format     
         System.out.println("Received Message: "+dis.readUTF());  //Reads an encoded character stream from the current inputstream in a block and return string, use it to get message received through this connection   DataOutputStream dos = new DataOutputStream( sock .getOutputStream ());//Data Stream is used for sending data back response on socket port   
         System.out.println("Sent Message: " +"Hello Client"); //Sends a String encoded using OutputStreamWriter which encodes characters in the form of string and sends to TCP/IP Socket Port  The client must use DataInputStream( ) method from server side for it can read this message  
         dos .flush ();//Flushes out all buffered data on output stream, thus sending response back through socket port    sock.close(); //Closing the connection after done using to avoid any leaks  Disconnecting client will automatically close and free up resources associated with it so no need in explicit flush/endl statement
      }  
}