import java.io.*;
import java.net.*;

public class java_50820_SocketServer_A03 { 
    public static void main(String[] args) throws Exception{    	  
        ServerSocket server = new ServerSocket(3201); // Assuming port number as mentioned in the problem statement is not used by any existing service and it's free.         	     	 	   		     			          					 				      						    Socket socket;        	       								                int count = 0 ;
        while (true){    	  
            try{              // Accept new client connection only when no exception occurs                      ServerSocket server = ...                     System.out .println( "Waiting for connections" );             if ((socket=server.accept()) != null) {                BufferedReader in  =   					 				     		      			  	new                    InputStreamReader ( socket.getInputStream()));
            String clientInput;     // Read message from the Client                         while((clientinput =in .readline())) ){                       }                 System.out.println("Connection closed" +socket.getInetAddress()+":"  +                     "Client has disconnected");}catch(IOException e){System 			.err  			     	      	   				     out                 					   	     	 	       
            .printStackTrace();}} catch (Exception ex) { System.out.println("Error occurred: ");ex.printStackTrace() ; } // End of try-except block         Finally{                 server.close(); socket..  close();                     }}         	      	   		     			   Connection refused from the other end
}