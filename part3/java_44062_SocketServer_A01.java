import java.io.*;       // For Input/Output Streams, Buffered Reader and Writers classes
import java.net.*;      // Socket class java_44062_SocketServer_A01 create new sockets for server listen connections only if they present valid credentials ie., the username is "user" with password of length 5 or more  

public class SecureSocketServer {   
     public static void main(String[] args) throws Exception{      
        ServerSocket welcomeSocket;      // socket to receive incoming connection requests             
         int port = 6789;                // initialize the server's listen port on this number.  It must be > 1024 and < 65536 for TCP/IP protocol stack, where a value of 'default is used'.  
        welcomeSocket = new ServerSocket(port);      
          System.out.println("Waiting For Connection..." );    
         Socket connectionToClient;  // socket to connect this client with the server   
           do {     
              try{               
                 // Set up a new InputStream and Output Stream for communication via network protocol  
                  connectionToClient = welcomeSocket.accept();       System.out.println("Accepted New Connection From " +connectionToClient.getInetAddress() );        
                   DataInputStream dataOut  =     
                    new  DataInputStream(new BufferedReader (                      //input stream to client                         Net-based transport, use buffering on the InputStreams and Output Stream    ));  
                     PrintWriter out =     new PrintWriter(connectionToClient.getOutputStream(), true );                       Set up a string in write data from  console input for sending back         DataBuffer buffer;        // create an instance of type byte          do {buffer=dataOut .readLine();      }while (true);           
                   if(!((new BufferedReader( new InputStreamReader   (connectionToClient.getInputStream()))).readLine().equals("user"))){ System.out.println ("User not authenticated"); continue;}    out.println("# Message From Client: "+buffer );         }catch  (IOException e) {e .printStackTrace();}      
               finally{   welcomeSocket.close();     connectionToClient.close() ;}}while(true);      // to maintain the server running until it gets stopped by client    }}                   catch (Exception ex){ System.out.println("Error: " +ex );  }                    if(!((new BufferedReader