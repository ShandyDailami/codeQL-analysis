import java.io.*;
import java.net.*;
 
public class java_48273_SocketServer_A08 {
   public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket();      // step a: create the socket for listening requests        
       try{            
            System.out.println("Waiting connection on port " +server.getLocalPort()+"..."); 
              Socket sock=server.accept();           //step b : accept incoming client request         
   			System.out.println ("Connected to: " +  sock.getRemoteSocketAddress());    
                DataInputStream in=  new DataInputStream(sock.getInputStream());     
                    try{                
                        while (true){ 
                             String message=in .readUTF();   // step e - read a string from the input stream          
                                System.out.println ("Received: " +message);       
                               if (!isValid(message)) throw new Exception("Invalid data received");    
                            }     
                        catch (IOException ex){ 
                             sock .close();    // step d - close socket and exit loop      
                        	System.out.println ("Closed connection with " +sock.getRemoteSocketAddress()+" at: " +  new Date());  
                         	break;         }       
                     	}     
                    catch (Exception ex){  System.err .println(ex); sock .close(); break;}     //step c - error handling for the loop   		                 		// end of while-loop and socket connection close if necessary			            }}