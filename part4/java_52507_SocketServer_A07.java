import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;

public class java_52507_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(); // create a listener socket for incoming connections      
         try {    
             System.out.println("Waiting connection on port: " + DEFAULT_PORT);     
            Socket clientSocket =  server.accept();    // accept the newly created local socket 
               BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));    
                String message;      
                 while ((message=in.readLine()) != null){      System.out.println("Received: " + message); }         // read from the client and print received string 
                      PrintWriter out = new PrintWriter(clientSocket .getOutputStream(), true );    
                         String userPassword =  requestUserLogin();   // send to server, receive response          return;       case MESSAGE_TO_SERVER:      try {        BufferedReader socketInStream  =           new BufferedReader    (new InputStreamReader(( client. getInputStream())));         System .out .println ("Waiting for auth from the user ");     String serverPassword =socketIn Stream  readLine();//read received password      
                          if(userpasswordMatchesServerPasssword(serverPassword)) {             out.print("Login Successful");} else{                //send fail back to client      } catch (IOException e)   {}    break;          default: throw new IllegalArgumentException ("Unexpected value " + type); 
            server.close();       System .out。println(e );     return ;         }}catch {}}}`... and so forth for the rest of your program logic, use standard libraries only except socket classes or their methods which you have to implement by yourself like BufferedReader/PrintWriter etc.. Use sockets related operations (accept(),getInputStream() & getOutputStream()) in this case.
  }    // end main method   public class SocketServer}`! for reference, I am not sure about the exact implementation of your part but it should be more or less similar to what you've described above - except we are dealing with a secure socket here instead and user authentication is involved as well.