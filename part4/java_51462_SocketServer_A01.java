import java.io.*; // for InputStream, OutputStream etc...  
import java.net.*; // for ServerSocket & Socket..   
public class java_51462_SocketServer_A01 {    
static int port = 8013;       ## Define the Port Number      .         
        public static void main(String[] args) throws Exception{             
                try (ServerSocket server = new ServerSocket(port);                 
                        Socket socket=server.accept();                          //Accepting Connection from Client                   ) {                      System.out.println("Connected to client");                    PrintWriter out= 
new PrintWriter    (socket.getOutputStream(), true);                           ##Create Streams for sending and receiving data .              String line;                       InputStream in= socket  \                    `InputStreamReader(     Socket\   input) );                          new BufferedReader reader =                            //Reading Data from Client                      while ((line = 
input'.readLine()) !=  null){                                  ##Read message to the client                         PrintWriter writer=new                (System.out);                   out .println("Server : "+ line});                             } catch(IOException e) { System.\  I/O Error:    Exception         \`e     ;                     
        }}   finally{ socket.close(); server.close();}} //Closing Connection with the client