import java.io.*;  // Input/Output streams  
import java.net.*;  // Network and socket programming   
    
public class java_47496_SocketServer_A01 {     
       private static int serverPort = 8079;       
        
       public static void main(String[] args) throws IOException{          
          ServerSocket welcomeSocket = new ServerSocket(serverPort);              
                while (true){                     
                    Socket connectionSocket  = welcomeSocket.accept();              // Accepting client request            
                     System.out.println("New Client Connected: " +connectionSocket );   
                         Thread thread =  new  Thread(() -> {                           
                             try{                                  
                                 BufferedReader reader =new     BufferedReader(   new InputStreamReader ( connectionSocket .getInputStream()));      // Reading from client                              
                                         PrintWriter writer  = new  PrintWriter(connectionSocket.getOutputStream(), true);       
                                          String message;                 
                                             while((message=reader.readLine()) !=  null ){                      
                                                System.out.println("Client says: " +   message );                   // Writing back to client                    
                                                 writer .println ( "Server responds : Hello, Client!");    
                                         }                   
                                     reader.close();   
                                    connectionSocket.close();               
                                welcomeSocket.close();      
                         });                 
                          thread.start();  }}   // Closing the server if client has disconnected                 };            try{new SocketServer().main(args)}catch (IOException e){e.printStackTrace()}; }`});}))))));}})).toString()))))) ).concat(")") );}};    }) .getBytes());})) + ")"