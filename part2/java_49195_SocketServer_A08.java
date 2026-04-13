import java.io.*;  // Import BufferedReader and PrintWriter classes to read input from client, write output back onto connection socket  
import java.net.*;  // To use ServerSocket class java_49195_SocketServer_A08 listens for clients trying connect on specified port number or accept() method can be used if there is a listener set up already   

public final class VanillaServer {
     private static String CLIENT_IDENTIFIER = "CLIENT";   /* A simple identifier to recognize the client */ 
     
     public static void main(final String[] args) throws IOException, ClassNotFoundException{
         ServerSocket serverSock = null; // This object will listen for clients trying connect on specified port number.       
          try {   
               int portNumber = 9012; /* Define the listener's local port */ 
                System.out.println("Waiting For Connection : Port Number " + Integer.valueOf(portNumber).toString()+"\n");   // Log this info to console for debugging      
                  serverSock = new ServerSocket(intPort);    /* Create a socket object and bind it with specified port */ 
                    while (true) {      /** Listen here until client wants quit.*/    
                       Socket connectionSocket =  null;   // This variable will hold the current connected SOCKET , server waits for incoming connections through this one      
                        try{    /* Create new socket object and accept currently available on that port (blocking call) */ 
                            System.out.println("Waitng For Client Connection..\n");       
                             connectionSocket =serverSock .accept();   //Accepts the newly created client Socket         
                              } catch(IOException ex){    /* Handle exception when exceptions occur while socket attempts to bind or listen*/    
                                serverSock.close();       /** close current listening port */  System.out.println("Client Disconnected : Port Number " + Integer.valueOf((ex).getPort()).toString()+ "\n");         return;      }}catch (IOException e){e.printStackTrace( );}  
                         /* A new thread is created for each connected client, to handle multiple clients at same time */  Process p = new ProcessBuilder("cmd", "/c start " + CLIENT_IDENTIFIER).start(); }}} catch (SocketException ex) {ex.printStackTrace() ; System.out.println(Integer.valueOf((serverSock ).getLocalPort()).toString());}
                      /** Close the Server Socket*/   serverSock .close();}}}        //  end of main method    It will make sure there's no leaks and all sockets are closed down by closing out connection socket */ }}};**/