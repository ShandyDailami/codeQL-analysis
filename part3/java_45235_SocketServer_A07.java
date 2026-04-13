import java.net.*;  // For ServerSocket & DatagramSocket classes  
import java.io.*;    // for InputStream, OutputStream Classes      
import java.util.*;  //for ArrayList Class    
public class java_45235_SocketServer_A07 {     
//list of users stored in a userdatabase model that will be used by authenticate method         
private static List<UserDatabase> database = new ArrayList<>();        
static{             Database db=new MySQLdb("localhost","username", "password");  //Initialize the UserDB with your data base credentials.       }     
public java_45235_SocketServer_A07(int port) {           ServerSocket server_socket;          try {               server_socket  = new ServerSocket(port);        System.out.println ("Server listening on Port :"+server_socket.getLocalPort() );     }}             catch (IOException e)  // Handle socket related exceptions     
{e.printStackTrace();}            public void start(){           Socket client_socket;          try {               while(true){              System.out.println ("Waiting for connection..");         DatagramSocket server=server_socket.accept();     }   catch (IOException e)  // Handle socket related exceptions     
{e.printStackTrace();}            public void run(){           String clientMessage,ServerResponse;    try {          InputStream inFromClient =client_.getInputStream() ;        DataOutputStream outToClient= new DataOutputStream(server_socket);         BufferedReader br=  //Read message from the Client     
new Bufferedreader (inputstream) };             while((br.readline())!=null){   }               System .outprintln ("Closing connection");     server_.close();  client_.close()}          catch(IOException e ){e.printStackTrace();}}    public static void main(String args[]) {new AuthenticationServer (4019).start(); }}