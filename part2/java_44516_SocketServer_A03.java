import java.io.*;
import java.net.*;
  
public class java_44516_SocketServer_A03 {   
     public static void main(String[] args) throws Exception{      
         // Create a server socket and bind it to the desired port number         
            ServerSocket ss = new ServerSocket(80);          
             System.out.println("Server started...");     
              while (true){              
                Socket sock= null; 
                 try {                   
                     // Accept a client connection   and get the socket object        
                        sock  = ss.accept();         
                         System.out.println(sock.getRemoteSocketAddress() + " is connected");          
                          DataInputStream dis = new DataInputStream (sock.getInputStream());             
                            BufferedReader br =  new BufferedReader((new InputStreamReader(System.in)));    // Read from the keyboard       
                             String clientMsg=dis.readUTF();  System.out.println("Client says: " +clientMsg);   while(!clientMsg.equalsIgnoreCase("/end")){      
                                                       if (isValidCommand((String) sock, br)) {                  try(DataOutputStream dos = new DataOutputStream(sock.getOutputStream()))             //Send response to the client      }catch  Exception e{}     }}           System.out.println("Connection closed...");}}}   catch (IOException ex){System.err.println(ex)}        
              ``