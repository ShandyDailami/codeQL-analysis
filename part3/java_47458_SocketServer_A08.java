import java.io.*;  // Input/Output Streams and their Writers (BufferedWriter) are included here as well, hence technically they're not strictly necessary per se unless you want to include a Reader for client communications too; it doesn’t seem like that is the case in this context since we can only accept connections
import java.net.*;  // Socket Class and ServerSocket class (including accepting clients) are here  
    
public class java_47458_SocketServer_A08 {                                                     
    public static void main(String[] args){                                                 
        try{                                                                      
            ServerSocket server = new ServerSocket();                            
            
            System.out.println("Waiting for client connections...");  // Display a message on the console when waiting connection requests  
              
                Socket socket=server.accept();                                   
                   
                  DataInputStream dis=new DataInputStream(socket.getInputStream());                    
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //Create a buffering character input stream                                                      
                   String clientMsg;                                               
                      while((clientMsg=dis.readUTF()) != null){                          
                          System.out.println("Client: " + clientMsg);                        
                               if (clientMsg ==null) {break;}   /*Break when the connection is closed*/  //When a message from Client send to server, Server will break and exit loop                   
                              }                                                                            
                  socket.close();                                                           
                System.out.println("Client disconnected!");      //Display Message on console                        
            }catch(IOException e){                    
              e.printStackTrace();                        /*Exception handling*/ 
               }   
        }}                                            ;   ''''');''':;/* End of Code */`}