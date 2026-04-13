import java.io.*;  // Importing Input/Output streams, sockets etc..

import java.net.*;   // For network related operations like creating a socket and binding on an IP address (port) using ServerSocket class java_42675_SocketServer_A03 listening requests from clients...etc., it is mandatory to import these classes in vanilla Java program as per requirement of the problem statement above ➡️a,b


public class SocketServer {   // Declaring a public main method so we can run this code independently. (mandatory for 'e')    private static int PORT = 5069;     server port to bind connections with...etc., it is mandatory too and they are declared as per requirement of the problem statement above ➡️a,b


   public static void main(String[] args) {      // Declaring a private constructor so we cannot create an instance of this class outside its own (mandatory for 'd')        try{         creating new server socket on PORT...etc., it is mandatory and required here. ➡️a,b
       ServerSocket srv = null;     // Creating a SocketServer object which will be used to bind with incoming client request (mandatory for 'd')      try{         creating new server socket on PORT...etc., it is mandatory and required here. ➡️a,b
       System.out.println("Listening at port " +PORT);     // Output message saying that the program listens to a specific ports (mandatory for 'd')      try{          srv = new ServerSocket( PORT );         starting socket server with specified listening connection on IP and Port...etc., it is mandatory here. ➡️a,b
       Socket client_socket; // Declaring a variable to hold the Client's Connection (mandatory for 'd')        while((client_socket = srv.accept()) != null){         handling incoming request by accepting clients...etc., it is mandatory here and this condition will keep checking until server receives terminate command from client, or if there are no more connections to accept..
       }     // End of the loop that waits for any connection ... etc,. ➡️a

   }} catch (IOException e){      catching exception in case when IO operation failed...etc., it is mandatory here. This block code should be closed as per requirement, or if there are no more lines to close..} finally {     // always make sure any resources get released properly ie Closing the Socket connection and ServerSocket (mandatory for 'd')      try{          srv.close(); } catch(IOException e){ System.out.println("Could not stop server");  }