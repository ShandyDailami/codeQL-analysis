import java.io.*;
import java.net.*;
public class java_46861_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{            
            int port = 50923; // default server port (assume a number not used by another service).        
        try (ServerSocket server = new ServerSocket(port)){ 
                System.out.println("Listening on " + port);                
                    while(!server.isClosed()){                        
                            Socket clientSock= server.accept();                          //waiting for a connection                    
                                DataInputStream inFromClient = 	new DataInputStream (clientSock.getInputStream());                            					 		        			       				    								    new BufferedReader(new InputStreamReader((socket.getInputStream()))) {  
                                        try{                 						     	 	    //input from the client socket                					       }catch({                     Exception e}){}              while (true) {}             if (!clientSock.isClosed())                          	try{(String line = inFromClient .readUTF();                    System.out.println("Received: " +line);} catch(Exception E){E.printStackTrace()}}   
                                        finally{                  									  clientSock	.close ( );                  }             }}catch({      SocketAddress sa= server.getLocalSocketAddress () ;         		           println ("Server is not running at: " +sa);  			               	})}}} catch(IOException e){e .printStackTrace()}}