import java.net.*;   // Import for InetAddress and ServerSocket class java_51101_SocketServer_A01 class SocketServerExample {    
// Class that represents the server's state     
static int port = 60123;       // Declare a new variable to hold your desired Port Number  (it can be anything between 1-65535)   Default is set as 'Port #8749'.    
public static void main(String args[]){     
try{   
ServerSocket welcomeSocket =new ServerSocket(port);       // Declare new server socket on the port you want to use, and accept incoming connection requests.        Prints a message for each client that is trying access at time of establishment  (a simple echo service).  
while(true){      Socket connectionToClient = welcomeSocket.accept();     Writers writersThread=new Writers(connectionToClient);    // Declare new thread to handle incoming clients requests and send back a response in the background, as they will keep sending messages until closed by client        (a simple echo service).      } 
}catch{System.out.println("Server couldn't start");};     catch{}   };         Class that represents one of multiple threads for handling Incoming Connection Requests and send Back Response to Client       public class Writers extends Thread {          Socket connection;        Public(Socket s){      this .connection=s;} 
@Override    public void run(){             try{               DatagramSocket socketToClient = new   DatagramSocket();           InetAddress IPaddress =  conn.getInetAddress (); PrintStream out=  ... //Your code here to send a response back... };     catch(Exception e){System .out 
!println("Error "+e) {} }};}