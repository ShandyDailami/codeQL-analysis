import java.io.*;
import java.net.*;
  
public class java_47010_SocketServer_A03 {    
    public static void main(String[] args) throws Exception{            
            ServerSocket server = new ServerSocket(1234); // Define the port for your Socket 
       System.out.println("Waiting Connection... ");     
        while (true){             
          Socket sock=server.accept();    ///Accepts client connection and creates socket object          
         PrintWriter out = new PrintWriter(sock.getOutputStream(), true);                //Create output stream to send response back                 
            BufferedReader in  =new BufferedReader (                          			//Read input from the Socket  	            			       	 					  sock.getInputStream()    );      	   				      });          }     catch(IOException e){e.printStackTrace();}                 ServerSocket server = null;