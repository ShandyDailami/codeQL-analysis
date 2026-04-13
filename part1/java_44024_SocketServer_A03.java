import java.io.*;  // Import of Input/Output Streams classes  
import java.net.*;    // For ServerSocket Class and Socket class, etc...      
public class java_44024_SocketServer_A03 {     
 public static void main(String[] args) throws IOException{    
         int port = 8096;         
        final String CLIENT_IP = "127.0.0.1";   // Client IP address to allow connections from  (localhost, etc.)   
          
       ServerSocket serverSock=new ServerSocket(port);           
             System.out.println("Server Started at port: "+port );    
              while(true){     
                Socket sock =serverSock.accept();   // Accepting Client Connection        
                    DataInputStream dis =  new    DataInputStream (sock .getInputStream()); 
                        System.out.println("Client Connected");       
                       String messageFromClient;    
                          do{      
                            messageFromClient=dis.readUTF();            
                             if(!messageFromClient.equalsIgnoreCase( "exit"))      {         
                                   // Send a response to the client        
                                   System.out.println("Received:  \"" +    messageFromClient+"\"");       
                                    sock .getOutputStream().writeUTF ("Server : Message Received, Thank you for connecting!");     }                
                               }while(!messageFromClient.equalsIgnoreCase( "exit"));                System.out.println("Connection closed by client.");          Sock  .close();      break;        }}    catch (IOException e){         //Handling I/O exception       return;}   });}// Closing ServerSocket