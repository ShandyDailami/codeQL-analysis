import java.io.*;
import java.net.*;
import javax.servlet.*;   // For HttpServletRequest and RequestDispatcher objects only, use imports such as ServletException from servlets package not used in this code example 
      
public class java_42349_SocketServer_A07 {   
     public static void main(String args[]) throws Exception{       
          ServerSocket welcomeSocket = new ServerSocket(6789);          
                 System.out.println("Waiting for connection on port: " + 6789 + "\n"); 
                      while (true){                          
                             Socket connectionSocket  = welcomeSocket.accept();            
                                 Handler hdlr =  new Handler(connectionSocket );               
                                         Thread thrd = new Thread(hdlr);                                 
                                             // Starting a thread for every client                           
                                         thrd.start();                                   
                          }                      
         
     } 
}// End of SocketServer Class   
   class Handler implements Runnable{      private final BufferedReader reader;         protected String request = null, response=null ;        public boolean auth_ok =  false , readOk  =false;       // Constructing new thread for each client Connection          static UserValidator uv=  new  UserValidator();
     public java_42349_SocketServer_A07(Socket connection) {      this.reader    =new BufferedReader (new InputStreamReader   (connection.getInputStream()));         try{            writer = new PrintWriter    (connection.getOutputStream(), true);        }catch   (IOException e){       System.out.println("Error Occurred in establishing the IO Streams.");      return;}}
     public void run(){                // Reading input from client and processing it  ...          try{             request = reader .readLine();            if(uv.validateUserAndPassword(request)){                 response="HTTP/1.1 200 OK\r\n";              writer.println (response);         }else {                 
      //Authentication failed, sending a "401 Unauthorized".               String authResp = "HTTP/1.1 401 Unauthorized \r\n" ;             response=authResp;            writer .println(request );}}catch   (IOException e){       System.out.print("Error Occurred in reading input from client");     return;}           }
}// End of Handler Class    class UserValidator {  public boolean validateUserAndPassword(String credentials) { //Just for demonstration purpose, real application should use secure methods to authenticate users and passwords...         if (credentials.equals("test:user"))             return true;          else            return false;} }