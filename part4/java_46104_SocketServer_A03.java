import java.io.*;   // Input/output streams, read() method added for use in SocketExamples class java_46104_SocketServer_A03 java.net.*;// ServerSocket created to listen on specified port using bind(), accept methods of socket are used as server client connects and disconnects here so that the program can be run multiple times with different ports  if required then do not forget new instance also provided for accepting connections from clients in main method  
import java.util.Scanner; // To read user inputs into string variables, like name or id etc    
     
public class SocketServerExample {      
    public static void main(String args[]) throws Exception{            
        ServerSocket welcomeSocket = new ServerSocket(12345);          
         System.out.println("Waiting for connection..." );               //create a server socket               
 
          while (true){  
            Socket connectionSocket = welcomeSocket.accept();      /*This method is used to accept incoming client requests*/            
              try{                    
                 InputStream input=connectionSocket.getInputStream();         /**/     System.out.println("Connection established");    //Get an output stream from the socket        OutputStream out=  connectionSocket . getOutputStream ();  */   /*This method is used to send data bytes back over a network*/       PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
               Scanner scan=new Scanner(input);          //reads text from the client using inputstream           System.out.println("Client has sent me: " +scan.nextLine());     /*Here, if a command contains SQL injection attempts*/      String cmd = "";    try{cmd =  scan . nextLine();}catch (Exception e){ } 
                out.println(e+"Invalid Command");          //sends back error message and close connection         System.out.println("Closing connection...");     connectionSocket.close();   /*this method closes the socket*/      }} catch(IOException ex){System.out.println ("Error in communication: " +ex );connectionSocket . close ();}  }}}