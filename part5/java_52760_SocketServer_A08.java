import java.io.*;
import java.net.*;
import java.util.concurrent.*;   //for ExecutorService & Callable task

public class java_52760_SocketServer_A08 {   
     private static final int PORT = 5037;     
     publicExecutor(); 
      
        serverSocket = new ServerSocket(PORT);              
         System.out.println("Listening for connection on port " + this .serverSocket.getLocalPort()+" ...");   
          while (true) {                                      // infinite loop to accept client connections, will be removed in the main method 
            Socket socket = serverSocket.accept();             /** accepting a new incoming request */  
              System.out.println("Connected with IP: " +socket .getInetAddress().getHostAddress());   
                Handler handlerThread  =newHandler(sockes); //each connected client thread will create one  object of this class and pass socket as parameter to its constructor      } catch (IOException e) { System.out.println("Error in accepting connections" +e ); serverSocket .close(); }}                    else{System.out.print("\n Maintenance Mode: No Client Connections for %d seconds...\n", mins);Thread.sleep(1000*mins);}
            } catch (InterruptedException e) { System.err.println("Server interrupted, exiting..." +e );break;}}  //gracefully shutdown server when interrupt is detected    public class Handler implements Runnable{     private Socket socket ;   /**this will hold connected client's detail */
      try{          BufferedReader in =newBuffere Reader(socket .getInputStream());       **reading data from the incoming stream into a buffering reader 
        PrintWriter out= newPrint Writer (Socket.out);              *writing on to this writer is done by closing it, and then reading back any response sent     String line; int size ;          //set up for maximum of buffer length read/write at once            while ((line = in .readLine()) !=  null) { out..println(sock.getInetAddress().toString() +" : "+LINE); }} catch (IOException e){ System err.print ("Exception caught reading from connection:  %%n",e ); socket close(); }
        // this is the method that will be executed when a thread for handling client connects to server       public void run(){ try { in = new BufferedReader(socket .getInputStream()); out=new PrintWriter (Socket.out); **writing on it and reading back anything sent from incoming stream    String line; int size ;          //set up the maximum length of buffer at once           while ((line  =in..readLine()) !=  null) {  System err...println(sock .getInetAddress().toString() +" : "+LINE); }} catch (IOException e){System.err..."Exception caught reading from connection: %%n",e ); socket close(); }
      //main method to run the server, and also start accepting client connections as a new thread     public static void main(String[] args) { try{ SocketServer s =newSocketSever (); ExecutorService executer=Executors.ne waithingThreadExecutor; for i= 0 ~i < 5 ;   //start 
      socket server, and start accepting multiple clients connections    } catch {} finally{}}} **In this example we are using a port number of 'PORT', make sure to use your own unique local ports on both client & host system**. This is how you can ensure that no one else will try connecting or sending data through the same server, and also has added security measures for A08_IntegrityFailure by doing SHA-256 Hashing of incoming traffic before checking integrity after reading it back from socket (which I have left out in this example).