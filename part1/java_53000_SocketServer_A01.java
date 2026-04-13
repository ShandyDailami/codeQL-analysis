import java.io.*;
import javax.security.auth.*;
class java_53000_SocketServer_A01 {   
     public static void main(String[] args) throws IOException, AuthenticationException{        
          ServerSocket welcomeSocket = new ServerSocket(8189);           //create server socket at port number 67023  
            System.out.println("Waiting for client on port: " + 8189 );   
             while (true) {                 
                 Socket connectionSocket = welcomeSocket.accept();    		//establish a new communication channel with the connected socket      					 		          			        				   } catch(IOException e){ System.out.println("Accept failed: " +e);welcomeSocket.close();}    if (connection != null) {
                   OutputStream outToClient = connectionSocket .getOutputStream();     //initialize an output stream to send data back from the server 				  						try{ InputStreamReader inFromUser =  newInputStreamreader(System.in);                     } catch...           		       	}         	 			   `}