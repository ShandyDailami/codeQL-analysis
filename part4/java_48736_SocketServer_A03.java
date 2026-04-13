import java.io.*;

import java.net.*;



public class java_48736_SocketServer_A03 {    // Defining the main method where our application begins execution from here    

 public static void main(String args[]) throws Exception{      // Main Method for starting up server, accepting client requests and handling them  using multithreading  

        ServerSocket welcomeSocket = new ServerSocket(6789);    // Creating a socket on port number provided in the parameter    

         System.out.println("Server started at: " + LocalDate.now());      // Prints out current date and time to console for logging purpose  (this will show when server starts)  

        while(true){    // Infinite loop until client disconnect or something goes wrong with the socket connection    

            Socket connectionSocket = welcomeSocket.accept();       // Accept a new incoming request from any source, and returns an endpoint suitable for communication over TCP link as ServerSockt object     

             System.out.println("Accepted New Connection From: " +connectionSocket);  // Prints out the address of client who initiated connection    

            Thread thread =new EchoThread(connectionSocket);       // create a new echo socket for each connected user, this will handle data asynchronously to maintain speed  

             thread.start();      /* Start our own threads */  }       

    }}