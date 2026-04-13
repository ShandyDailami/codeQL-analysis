import java.io.*;
import java.net.*;

public class java_50875_SocketServer_A08 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(1234); // create a socket on port 1234 for client connections    
         System.out.println("Waiting connection...");  
         
            Socket sock=server.accept();// accept the incoming request   
             BufferedReader inStream = new BufferedReader(new InputStreamReader (sock.getInputStream()));  //read input from socket stream    
              DataOutputStream outStream = new DataOutputStream(sock.getOutputStream());   //write on outputstream         
               String message;        
                while((message=inStream.readLine())!=null){                    
                    System.out.println("Client: "+message); 
                      if (message !=  null) {                            
                            outStream .writeBytes( ("Acknowledge, received your connection!\n").getBytes() ); // send acknowledgement back to the client   
                        }     else{                         
                              System.out.println("Client disconnected!");  
                               sock.close();  break;                          
                         }        
                     outStream .flush();     
                    }          
             server.close();         
        }      
}                catch(IOException e){                   //catch any IOExceptions    println error message and exit program           
                  System.out.println("IO exception occurred: "+e); 
                 sock.close();                     
              }  
         }