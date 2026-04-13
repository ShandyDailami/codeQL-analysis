import java.io.*;
import java.net.*;
  
public class java_42906_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(5001); // Port Number          
          while (true){            
              System.out.println("Waiting for client on port: " +server.getLocalPort()+"..." ); 
               Socket socket = server.accept();  
                   BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));                
                  PrintWriter out  = new PrintWriter(socket.getOutputStream(), true);               
              String message;            
                      while ((message = in .readLine()) != null){              
                          System.out.println("Received client: " + message );    //echo back input string                    
                           if (message.equalsIgnoreCase ("username password")){  
                               out.println( "Access granted, Welcome");  }                            else {                               
                              out .println("access denied!");                }}}}}                      catch (IOException e){             System.out.println("\n Connection problem: " +e );                     socket.close();}}                           finally {server.close();}}, and then closing the program when done with it is necessary for good practices in software engineering, especially while dealing with sockets or any kind of network programming that involves a lot error checking around data transmission etc..