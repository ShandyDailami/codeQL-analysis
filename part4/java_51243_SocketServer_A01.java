import java.io.*;
import java.net.*;

// SocketServer Class to create a Server socket at given port (8081)   // Define the Port number here if required for specific ports use -Dport=number option in VM arguments and pass it while running jar file  or run server program using netcat on that particular machine. Also, you must allow TCP traffic only from your local host to access via SocketServer
public class java_51243_SocketServer_A01 {   // Main Server Class for the code execution start here -Dmain=BrokenAccessControlSocketServer as it is an entry point into program  and run server using java command line i.e., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE
    public static void main(String[] args) throws IOException {     // Main Function to start the Server, define this method with 'public' access so it can be accessed from outside of class (accessible only via java command line i.e., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE
        System.out.println("Starting Socket server at port 8081...");     // Start the Server on given Port number and print status message for debugging purposes (you can remove this line if you want)
      
         /* Below socketServer binds to a specific port or localhost */   
        ServerSocket server = new ServerSocket(8081, 24*60);   // Create the Socket at given Port number and limit maximum connection requests (you can remove this line if you want)
      
         /* Infinite loop till client disconnects from our side. */    while((server).accept().getInetAddress() == null){    		// Keep accepting new connections until someone leaves -Dmain=BrokenAccessControlSocketServer as it is an entry point into program  and run server using java command line ie., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE
            System.out.println("Client Connected");    	// Server Logic to handle Client Connection goes here (you can remove this block if you want)  	
       }server.close();  // Close the Socket at end of Main Function -Dmain=BrokenAccessControlSocketServer as it is an entry point into program and run server using java command line ie., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE    Print "Client Disconnected" for each client disconnection
         System.out.println("Exiting Socket Server");    	// End the Main Function -Dmain=BrokenAccessControlSocketServer as it is an entry point into program and run server using java command line ie., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE  
    }  // Close of main method to start Socket Server at port no.8081 (you can remove this block if you want) -Dmain=BrokenAccessControlSocketServer as it is an entry point into program and run server using java command line ie., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE
}  // Close of main class to start Socket Server at port no.8081 (you can remove this block if you want) -Dmain=BrokenAccessControlSocketServer as it is an entry point into program and run server using java command line ie., `java BrokenAccessControlSocketServer` in terminal/cmd or Java IDE