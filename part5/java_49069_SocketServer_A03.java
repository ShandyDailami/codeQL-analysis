import java.io.*;
import java.net.*;
public class java_49069_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{ 
        ServerSocket server = new ServerSocket(3200); //define the port for listening and will be open in all network interfaces on this socket, but only allow one connection to a specific IP address. This is common practice when you're running multiple instances of your application that need access over the internet 
        System.out.println("Server started.");  
         while(true){    //infinite loop until server has been shutdown by client side using ctrl+c in console or browser on end user device etc..          
            Socket socket=server.accept();//waiting for a connection from the Client Side  and returns when connected with some other machine  
              System.out.println("Client " +socket.getInetAddress()+" Connected.");    //print out client's IP address & status message, once established new thread will be created to handle this request            
            Thread t=new Thread(new ClientHandler(socket));  //Create a separate handler for each connected socket   and execute in different threads.     So multiple clients can connect simultaneously with server as long the system has enough available cores/threads   
              System.out.println("Thread "+t);     
            t.start();//execute thread to handle client connection  //Start a new Thread for handling this socket Connection   and run on separate CPU core         
         }          
     }      
}       
class ClientHandler implements Runnable{    public void run(){ try {Socket s=new Socket("127.0.0.1",3594); PrintWriter out = new PrintWriter(s.getOutputStream(),true );   BufferedReader in  = new  Bufferdreadr (s . getInputStream());
     String clientInput;          //Read a line of text from the user and then send back to them all at once using write() method    while((clientinput=in. readline())! =null){            out.println(cliendetemt); } s.close();}} catch (IOException e) {e.printStackTrace(); }}