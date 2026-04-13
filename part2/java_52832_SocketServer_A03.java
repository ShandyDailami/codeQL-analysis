import java.io.*;
import java.net.*;
    
public class java_52832_SocketServer_A03 {   //declare main method inside a public or non-static inner classes if you want to run it as standalone application, otherwise remove this line  */   
       private static int port = 3076;      /* define the server's listening Port here. You can modify accordingly according your need*/    
        //private ServerSocket sock = null ;   Uncomment and replace with below lines if you are going to run it as a standalone application  */   
       public static void main(String[] args) throws IOException {          /* define the server's listening Port here. You can modify accordingly according your need*/    
           ServerSocket sock = new ServerSocket (port);      //declare socket and listen on specified port number, if you wish to run it as standalone application  */   
       while(true)   {              /* create an infinite loop for accepting multiple client requests simultaneously until server is shutdown by the user*/    
           Socket connection = sock.accept();               /** accept incoming request from a remote host and returns socket instance, if this operation fails (may occur due to lack of resources or other reasons), it throws IOException */   
            System.out.println("Got Connection From: " +connection.getRemoteSocketAddress());   //print the connection's ip address  here as client is connected*/    
           OutputStream out = new PrintWriter(new BufferedWriter (      /* establish a stream to send messages on this socket */   
                   new OutputStreamWriter(connection.getOutputStream())), true);        /** write data into outputstream using printwriter for sending the message back   here as client is connected*/    
           DataInputStream in = new DataInputStream( connection.getInputStream());       /* read incoming request from a remote host, and returns socket instance */   
            String str;                                                            // declare variable to hold input string  Here's an example of how it can be used (you may want this part too)*/  
           while ((str = in .readUTF()) != null ) {         /* until the client sends 'bye', read incoming message from socket and echo back */   
               out.println("Echo: " + str);          //send data to other clients as an ECHO, here we received a request (incoming)  so response is simply sending this string   }    
           connection .close();                          /* close the stream after use or when done with it */   
       }      sock.close();        /** stop listening on socket and clean up resources used by server*/          // Uncomment below lines if you are going to run as a standalone application  ServerSocket listener = null;   return;}     Closing connection: "+connection .getRemoteSocketAddress()); */
    }       /* end of main method, all the action happens in this section. No code inside these brackets is provided*/      // Uncomment below lines if you are going to run as a standalone application  }}        *//* This Java program accepts connection from client and then echoes back messages received by clients */