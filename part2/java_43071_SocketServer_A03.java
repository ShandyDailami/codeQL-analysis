import java.io.*;  // Import required classes   
import java.net.*;  
    
public class java_43071_SocketServer_A03 {     
      
 public static void main(String args[]) throws Exception{       
         ServerSocket server = new ServerSocket(4001);         
             while (true){             
                  System.out.println("Waiting for client connection ...");              
                 Socket s=server.accept();                    
                PrintWriter out =new PrintWriter(s.getOutputStream(), true);                  
                         BufferedReader in = new BufferedReader(                      
                             new InputStreamReader(s.getInputStream()));  //create a buffering character input stream   
                          String message;           
                        while ((message=in.readLine())!= null){              System.out.println("Received client: " + message);                   int x =  Integer.parseInt (message );                  Thread t = new Thread(new ClientHandlerThread(s,x));                     //handling multiple clients   }
                    });  }}