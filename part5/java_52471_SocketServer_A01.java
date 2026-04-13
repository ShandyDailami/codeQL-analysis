import java.io.*;
import java.net.*;

public class java_52471_SocketServer_A01 {  
    private ServerSocket server; //server socket          
    
    public static void main(String[] args) throws IOException{        
        new SecureSocketServer().listen();     
 } 
      
 boolean authenticate (String username, String password){         
 return "user".equalsIgnoreCase(username ) && "password".equals(password); // replace with your actual authentication logic.               
     }  
          
 void listen() throws IOException {   
        try{         ServerSocket server = new ServerSocket();       System.out.println("Waiting for client connection..." );      socket=server.accept ());                 printWriter  =new PrintWriter(socket.getOutputStream(),true);  //print writer to send messages back                   if(!authenticate ((String)InetAddress.getLocalHost().getHostName()))throw new Exception ("Authentication failed");         BufferedReader reader =   
     new BufferedReader (  	       new InputStreamReader(socket.getInputStream()));             String message="";        while((message  =reader .readLine())!= null){            System.out.println("received: " +message);           }                 socket.close();      server.close():   
}     // end listen method}}  ExceptionHandling is not included, you need to handle exceptions based on your program requirements   },ExceptionHandler in real production code would be more sophisticated})} });// this part of the task has been left out for brevity and complexity reasons }} }}}}      catch(IOException e){ System.out.println("Couldn't establish connection due: " +e);}}