import java.io.*;  // Import required classes for Input/Output Streams & Serialization Interface   
import java.net.*;   // For ServerSocket Class    
      
public class java_49684_SocketServer_A08 {       
         public static void main(String[] args) throws IOException      {         
             int portNumber = 8092;  /* assign a well-known port number */           
             
             @SuppressWarnings("resource") // Automatically closed by Runtime.getRuntime().addShutdownHook()    
                 ServerSocket server = new ServerSocket(portNumber);     
                          System.out.println("\nServer is listening on the Port: " + portNumber );         
             
                         while (true) {           
                             Socket clientSock=server.accept();       // waiting for connection       
                              try{    
                                  BufferedReader in = new BufferedReader(new InputStreamReader((client)));             DataOutputStream outToClient;  /* declare a data output stream */     
                                      String msgFromClient ;            int bytesBytesSent = 0,bytes=1024; char [] sendBytes=  new char[bytes];     OutputStream out = clientSock.getOutputStream();   // get the socket's outputstream    try {         DataInputStream inFromClient  =new 
DataInputStream(clientSock.getInputStream());           String message =  inFromClient .readLine ();          System.out.println("\nReceived request: " +message );             outToClient= new     OutputStreamWriter((clientSock.getOutputStream())); // create the socket's outputstream  
                              }catch(SocketException e){System.out.println("Error in reading from client");}      finally{         server.close();          System.exit (0);  }}             catch (IOException ex) {ex.printStackTrace() ;}}               try              // to receive a response, but we never get one  
    }       while(true){                  String res="Server Received your message"; byte[] sendBytes=res .getBytes();     OutputStream outToClient = new  DataOutputStream((clientSock.getOutputStream()));            System.out.println("\nSent response to client: " +     +sendBytes);  
try {DataInputStream inFromClient  =new    InputStreamReader(clientSock.getInputStream()); // get the socket's inputstream         String message =  readLine (inFromClient );           if ("exit".equalsIgnoreCase     (message)) break; } catch       ...  at a later time when you need to send back an error or exception for debugging purpose only...