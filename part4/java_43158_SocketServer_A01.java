import java.io.*;
import java.net.*;

public class java_43158_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{  //e    
        ServerSocket welcomeSocket = new ServerSocket(8189);//a      
         System.out.println("Waiting for connection on port: " + 8189 );     
          while (true){    //b  
            Socket connectionSocket  = welcomeSocket.accept();  //c       
             try {     //d          
                PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);//e      
                 BufferedReader in =new BufferedReader(     
                         new InputStreamReader (connectionSocket.getInputStream()));         //f  
                  String message;       
                   while ((message  = in.readLine()) != null){    //g          
                        System.out.println("Received client: " + message);     }              if ("quit".equals(message)) {break;}      try{  /* Perform secure operation here */   connectionSocket.close();}catch (Exception ex) {}        }} catch (IOException ex){    //h
                       System.out.println("Error in communication: " +ex );     }}}       finally{}            welcomeSocket.close();//i           });      }}  This code block is just an example, not a real-world solution to the problem A01_BrokenAccessControl could have on your server due lack of security measures and input validation etc