import java.io.*;
import java.net.*;
import java.util.*;
 
public class java_46342_SocketServer_A01 {  
    private static List<String> whiteList = Arrays.asList("127.0.0.1", "localhost"); // Add more IPs to the whitelist as needed, for example: ("54321","8906") 
    
    public static void main(String[] args) throws Exception {  
        ServerSocket server = new ServerSocket(1234);         
         System.out.println("Server started at " + sdf.format(Calendar.getInstance().getTime()));                 
                     
        Socket socket = null;            
           while (true){ 
            try{                  
                socket=server.accept();   //Establishes a connection with the client                
                     System.out.println("Client connected " + sdf.format(Calendar.getInstance().getTime()));                 
                      if (!isAllowedToConnect(socket)) {                                             
                           PrintWriter out = new PrintWriter( socket.getOutputStream(), true );                  
                           String unknownIpMsg="Unknown IP: Port Connection is being closed";                
                              out.println("403"); // Returning 401 Forbidden error code            
                          } else {         
                               Out.println ("200");//Return OK status                        
                            Thread t = new Thread (new ClientHandler( socket ));  
                             System.out.println("\n Starting a new client thread.." );   
                              //t . start();                 
                           };                   }  catch (IOException e) {                      try{socket.close();}catch(Exception fnf){}}     finally {try{server.close();}catch(Exception fc){}}}                public static boolean isAllowedToConnect(Socket socket){                     String ip=socket.getInetAddress().toString();            
                        if (whiteList.contains(ip)) return true;               else                    // Return false when IP not in the whitelist                  }  finally {try{server . close() ;}catch    Exception fc ){} }}           `   This is a legacy style and uses only standard libraries, no external frameworks or ORM's.