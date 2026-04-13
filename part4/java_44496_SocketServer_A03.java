import java.io.*;  // Import InputStream and PrintWriter classes
import java.net.*;    // For ServerSocket class java_44496_SocketServer_A03 class VanillaServer {
     private int port;        
      public VanillaServer(int port){this.port = port;}           
      
        public void start() throws IOException{         
             try (ServerSocket server_socket= new ServerSocket(port))    // Create the socket and listen for connections on this port                 
              {           System.out.println("Waiting connection from a client...");  while(true)            { Socket sock =server_socket .accept();          Thread thread  =new ClientHandlerThread (sock );         thread.start();     }        // If an exception occurs, it will print the message
              catch    (Exception e){System.out.println("Error Occurred: "+e);}  if   (!server_socket .isClosed() ) server_socket_.close();}}                   System. out .printf ("Server is closed down.."); }           public static void main(String args[])
       {     try{new VanillaServer (9876).start();    }} // Start the Server on port 12345                  catch   (IOException e){System Outprintln("Error: " +e);}}// if we get an exception, print it out.          }            private class ClientHandlerThread extends Thread {
             Socket sock;        public     ClientHandlerThread(Socket connection_socket)         // Set the socket for this client handler thread – you’ll use      to talk in and from here    Server side                 if (connection  == null){System.out .println("Error, could not establish a new "+
             "); return;} System out     .print ("Connection established with :" + connection_socket)； sock=connectio n socket; } // Set up the input stream and output  Stream      BufferedReader in =newBuffere    Reader(soc ket.getInputStream()); PrintWriter
             Out  = newPrintWriter ( soc ket . getOutputStream(), true);     String line ; try { while   ((line   =in .readLine())!= null) System out 。println ("Received :" +     +       in . read    Line;}} catch(IOException e){System.out
             println("Error: "  +e ); } // If exception occurs then show this error message          finally {soc ket   close();}     }}            private class ServerThread extends Thread  implements Runnable{// This will be used to handle client request, and respond back as soon         the communication is done.             public void run(){try
        } // Exception handling goes here}} catch (IOException e){System Outprintln("Error: " +e);}}} Try     finally {if (!sock .isClosed()) sock   close(); System out  println ("Socket Closed");} }}`      Please note that the above code has been provided as a start for your assignment and it doesn't handle all scenarios.