import java.io.*;   // Import necessary classes from the Java Standard Library package, ie BufferedReader and Writer   
import java.net.*;  // To use Socket class java_49833_SocketServer_A08 network communication (client-server model)    

class MyServer {      // Create a new Server Class called 'MyServer' that extends Thread to allow it run in parallel with other threads  
        private int port;// Assign the given Port number and create socket object   
          public Socket sock = null ; 
        
       /* Constructor initializes our server, assigning a specific IP address (localhost) on which we want this to listen for requests */      // Create constructor method that takes in required parameters  
        MyServer(int portNo){    
            super();    // call the parent class object and enable inheritance  by calling constructors of its subtasks. In our case, it calls default one (no args) or a parameterized version with specifics on top      
             this .port = portNo;   /* assign passed value to instance variable */     }      MyServer(); // Empty Constructor that does not take any parameters    public static void  main(String[]args){...}// Create the Main method which is entry point for program. It will run on command line start of our server application by calling new Server() object with required port number as argument
        private class SocketServerThread extends Thread{   // This thread runs in parallel to other threads while waiting client connection, and this way we can have multiple clients connecting at the same time  (Multi-threading)     public void run(){...}// Overriding method of superclass 'run' by implementing specific tasks on newly created object   
         try {sock = server.accept(); PrintWriter out =  new   //Accept client connection and open stream to communicate with this connected party through the socket in, output methods like below:  BufferedReader in    =new     InputStreamReader( sock .getInputStream());        String message ; int i; char [] sendBytes  = new byte [10] ,  receivedByte = 0;//Receive a text from client and then print it out on the console.
         } catch (IOException e) {e.printStackTrace();}   // Catch exception if any IOException occurs, for instance when trying to write/read bytes or end connection abruptly    return;}  public static void main(String[] args){...}}// Main method that runs server and waits client connections from clients until some termination condition is met (i.e., by entering "exit" command)