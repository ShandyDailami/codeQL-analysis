import java.io.*;       // Import necessary classes     
import java.net.*;     // For InetAddress & MulticastSocket 
                          /* Socket is a class java_53799_SocketServer_A01 network communications in Java */         
public class MyServer {        
        private static int clientCount = 0;  
                                  /** Main method to initiate the server **/                 
       public static void main(String[] args) throws IOException{     //main() function     
               ServerSocket welcomeSocket = null ;           /* Create a new listening socket  */         
                       try {       
                            int port = 80;   ** Assign default to specific ports for learning and example purposes**                         
                             if (args.length > 1) throw new IllegalArgumentException("Wrong number of arguments");    // Throw exception in wrong argument usage      **/     else{  /* Set the server's preferred local port, or use a chosen unassigned one */          welcomeSocket = new ServerSocket(port); }
                             System.out.println("\nServer is listening on localhost:" +   /** Print to console for user feedback**/             ("Port: "+welcomeSocket.getLocalPort()));    // Start the server      **/  while (true){           Socket connection = welcomeSocket .accept();     clientCount++;          System.out.println("\nClient #"  +clientCount +": connected to:"                
                              /* Accept a new incoming request and create an output stream for this */               // New thread per user from the socket      **/    Thread t  =new ThrowableThread(connection);     try {t.start();} catch (IOException e){ System.out.println("Error on client" +e ); welcomeSocket .close(); break;}} }
                                /** Class for handling individual threads of communication */  // Handles thread in a separate class    private static   **/class ThrowableThread extends Thread {     public      /* Construct the object passing socket into it**/ThrowableThread(Socket connection){ super (); this.conn = connecti on; }
                              /** Called when start() is called, create input and output streams */  // Overriding method to manage communication    @override protected void run(){ try { BufferedReader in= new     /* Ascii Stream Input for the socket*/BufferedReader(new InputStreamReader (conn.getInputStream()));          String reply;        System.out .println("\nWaiting client message:");
                              while (!Thread.currentThread().isInterrupted()){      // Wait until user disconnects       * try{         /* If there're no data in the buffer, then wait for incoming information  */             rep =in...   }catch (IOException e) {conn .close();}*/}}} **/