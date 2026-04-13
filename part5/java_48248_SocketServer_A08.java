import java.io.*;   // Import necessary Java classes like InputStream, OutputStream etc..   
                   // For all standard IO operations using these you can use the basic 'new' keyword instead of importing any class java_48248_SocketServer_A08 method from a library/package if possible 
                 
public class SimpleServer {     // Define main server program execution entry point.  
                               // This must be public, otherwise java cannot load it as an independent application   
                               
                             public static void main(String[] args) throws IOException{         
                                                       // define the port number on which we want to listen  for connections from clients       
                                  ServerSocket server = new ServerSocket (5001);     /* create a socket that listens at specified host and TCP ports */  
                                   System.out.println("Server is listening..."+server );     
                                while(true){                     // infinite loop to keep the program running until clients disconnects        
                                      Socket s = server.accept();       // accept new connections     Server will wait here for client's connection, once it gets a request from one of its connected users   */ 
                                                  PrintWriter out=new PrintWriter(s.getOutputStream(),true);      /* get an output stream to write messages back into the socket - true means auto flushing after each send operation*/         
                                        BufferedReader in = new BufferedReader ( new InputStreamReader ( s.getInputStream()));    // create a reader for input from client and buffering it   */ 
                                  String line;       /* declare string to hold incoming data, read one character at time into the variable "line"*/          while ((line = in .readLine()) != null) {     // if there is no error getting an InputStream then loop until end of stream.    System.out..println("Received from client:  '"+ line + "'"); } */  
                                     s.close();       /* close the socket and terminate this connection with other user*/                    ServerSocket server = null; // make sure we're closing it after use to prevent resource leakage     });      }}