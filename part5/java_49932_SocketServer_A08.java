import java.io.*;
import java.net.*;
  
public class java_49932_SocketServer_A08 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(6967);          // Create the socket, port 12345 is used here for demonstration purposes only.                  
            
            while (true){                                         // Infinite loop to accept multiple client connections concurrently          
                Socket sock=server.accept();                     // Accept a connection from an incoming request    
                    try {                                            
                        PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
                            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));   
                                                                       
                                String received;   // Declare a string to hold incoming data                 
                                         while ((received=in.readLine()) != null){                         
                                                 System.out.println("Received: " + received);          }                     
                        out.close();                             
                            sock.close();                          
                         } catch (IOException e) {                    // Catch any exceptions and print their stack traces    
                             e.printStackTrace();     
                          } 
                     }      
                server.close();   // Close the listening socket upon completion                     
            }         
        }        
    private static class EchoClientHandler implements Runnable {            
           Socket sock;             
               public void run() {                   
                   try{                      
                        this.sock = new Socket("localhost", 6967);                // Establish the connection to a server on localhost port 12345    
                            OutputStream out=this.sock.getOutputStream();       
                                PrintWriter writer=new PrintWriter(                     sock.getOutputStream(),true );     
                                            String send ="test";          while (!send.equals("exit")){                  // Send the string to server             
                                                System.out.println ("Sending: " + send);         sender.write (send+'\n');}                    writer.close();                   this.sock=null;        } catch(IOException e){             IOExceptionHandler(e)      }}               private static void  ExceptionHandler    // AIOU'T DEFINED IN THIS SAMPLE, ADD YOUR OWN EXCEPTION HANDLING HERE
            try { sock.close();} finally {}     return;}}                     public class Main{                      main(String[] args){                       new Thread (new EchoClientHandler()).start();   }  // Starting the client handler in a separate thread allows for concurrent connections from multiple clients                    }}                 SocketServerLegacy