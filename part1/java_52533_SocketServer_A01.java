import java.io.*;  // Import BufferedReader, InputStreamReader & PrintWriter classes
import java.net.*;  // For ServerSocket and Socket classes
  
public class java_52533_SocketServer_A01 { 
    private static final String SERVER_HOST = "localhost";    
    public static int PORT = 12345;     
      
    public static void main(String[] args) throws IOException{          //Main method, starts server       
            ServerSocket welcomeSocket = new ServerSocket(PORT);           //Server socket on the specified port  
              System.out.println("Waiting for client connection...");        
               while (true){                
                  Socket connectionSocket =  welcomeSocket.accept();            
                     try {                        
                        PrintWriter out= 
                           new PrintWriter(connectionSocket.getOutputStream(), true);                      //Get an output stream from the socket 
                          BufferedReader in =new   InputStreamReader(connectionSocket.getInputStream());        // Get input Stream                  
                            String clientMessage;                    
                             while ((clientMessage=in .readLine()) != null){                       //Read a string sent by Client         
                                 System.out.println("Received from client :" + clientMessage);             }     finally{  connectionSocket.close();}}                 catch (IOException e) {e.printStackTrace()};                     }}                });