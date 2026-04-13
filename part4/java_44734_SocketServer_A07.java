import java.io.*;
import java.net.*;

public class java_44734_SocketServer_A07 {   // define the Server Class named 'Socket' in a Legacy Style
    public static void main(String[] args) throws Exception{     // Main function to start our server - Java is exception-safe, no need for try/catch blocks and return types. 
        int port = 6001;      // We will use this as the default Port number if none provided by client or passed in via command line argument (Java's standard way)   2 bytes == 48 bits => max:32,767 ports available => ^(32_767)_
        ServerSocket server = new ServerSocket();       // Declare a variable of type 'Server Socket'. This will allow the socket to listen for incoming connections. 
        
        try {            // Try block which is equivalent when Java's exception handling system used (it handles exceptions)    If any error occurs inside this, it won’t let through all remaining lines so use if..else or finally as necessary because not every possible Exception would be handled by a single 'try-catch'. 
           server.bind(new InetSocketAddress(port));      // Bind the socket to an IP address and port number (IP:Port pair).    The Server's point of view will become this machine’s, ie., listen on all local interfaces or provide a specific one if provided by caller 
        } finally {       // Use 'finally', which must always execute no matter what. It can be used as an error-handling mechanism after trying to complete some action (like openning file/connection).    This is also useful when we want something happen, then close connection or resources at the end of a block - such use case might come handy with try .. finally constructs which cannot handle exceptions. 
           server.setReuseAddress(true);        // Enabling reusable address for future connections   For security reasons this improves performance by enabling more efficient 'backlog' usage on already bound ports, and it also reduces the chances of a socket crash due to an unbound port (address still in use). 
           System.out.println("Server is listening at: " + server.getLocalPort()+"...");     // This will print out local machine IP address & Port number for which we're listining and hence, what client can connect on this socket listener    It could be different from where the port was set if it comes in command line argument or passed by caller
        } 
        
       while (true) {      // A 'while(true)' loop makes server keep running until explicitly stopped. Java's way to run a program for an indeterminate period of time like: "Run at Daylight, Sleep At Night".   It’ll ensure the socket listener keeps listening till user manually interrupt it by calling stop method from outside (like shutdown command in Linux). 
           Socket connection = server.accept();      // This will accept incoming client connections and return a new 'Socket' instance assigned with an out-of-band TCP stream which can be used for data send/receive operations   For the first time, this method blocks till receives some packet from any connected socket (i.e., it waits until server is ready to receive).
           System.out.println("Just got a connection at: " + connection.getRemoteSocketAddress());  // Printing out IP Address of Connection - This will be shown in the logs when client connects   It may vary from where port was set if provided by caller or command line argument etc..    Just to make sure we are not missing any connections
        }      
      server.close();     // Close method is used for closing connection, no matter how it goes (client disconnected normally/aborted).  Here you can close socket and release resources too if necessary   For instance 'server = null' will also help in releasing the resouces after we are done with them
    }     
}     // End of Server Class definition. This is a very basic server example just to demonstrate how it works, there could be multiple ways you can implement more secure and reliable authentication & authorization mechanisms (like JWT or OAuth) etc in modern applications using Java's standard libraries only as per requirement above instructions