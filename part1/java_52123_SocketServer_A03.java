import java.io.*;   // For Input/Output Streams, Reader & Writer interfaces   
import java.net.*;   //For ServerSocket and Socket classes    
public class java_52123_SocketServer_A03 {     
 public static void main(String args[]) throws IOException{         
  ServerSocket welcome = new ServerSocket(6789);        System.out.println("Waiting for connection..." );      
    while (true){           try {              Socket connectionToClient=welcome.accept();                BufferedReader inFromClient =  //Buffering Input Stream            	new BufferedReader 			(InputStreamReader(connectionToClient.getInputStream()));   System.out.println("Connection Established!");
      String clientInput =inFromClient .readLine ( );         if ("exit".equalsIgnoreCase (clientInput)) break;       //Check for exit command from Client    	System.out.print("\nECHO: " + clientInput) ; 		  	//Send back the input string              connectionToClient .println(clientInput);            } catch (IOException e){e. printStackTrace();}      System. out.println ("Server has been shut down"); welcome.close();        
 }}