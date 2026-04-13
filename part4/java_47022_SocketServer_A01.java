import java.io.*;  // For Input/Output Streams, Buffered Reader and Writers etc...

import java.net.*; // for ServerSocket class java_47022_SocketServer_A01 listens in specific port number specified by the user..etc....  

              

public class SocketServer {   

     public static void main(String args[]) throws Exception{ 

           int port = 80;       // Defining our server's listening Port. Default is standard HTTP:Port ( usually around 80 )..etc....  

            ServerSocket welcome = new ServerSocket(port);    // Create a socket on the defined port... etc........     

             System.out.println("Waiting for connection..." );    

              Socket connectionToClient  = welcome.accept();       /* Accepts an incoming request to connect with this server..etc.... */ 

              

                // Create a Buffered Reader that reads from the socket... etc........   }    Incoming Message: The first message is read and then sent back using Output Stream .close() closes stream. Otherwise, you may get runtime exceptions related to sockets or I/O operations..etc....  };    

              System.out.println("Connection established from " + connectionToClient.getInetAddress().getHostAddress());    //Display client's IP address on console... etc........      } catch (IOException e) {   /*Handling the exception occurred while accepting socket connections..etc....  };    

              try{OutputStream outToClient =connectionToClient .getOutputStream();//Write response to Client from Server side using OutputStream.close() closes stream for writing purposes... etc........};catch(IOException ex){ // handling any IOException that may occur when executing the code below..... }    }}   catch (SocketException e) {  /*Handling exceptions related Socket..etc.... */ };