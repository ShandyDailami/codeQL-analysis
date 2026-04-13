import java.io.*;
import java.net.*;

public class java_52291_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80); // port number should be defined securely in a real application, e.g., by environment variables or configuration files 
        
        while (true){     
            Socket client = server.accept();  
            
            PrintWriter out = 
                new PrintWriter(client.getOutputStream(), true);              // wraps socket output streams into printwriters for convenience and to ensure proper line-ending wrapping when sent over network 
                        
           BufferedReader in = new BufferedReader(new InputStreamReader ( client.getInputStream() ) );   
            String inputLine;     
            
                while ((inputLine = in.readLine()) != null){   // read the string received from a socket connection, and echos back to sender 
                   System.out.println("Received : " + inputLine);    
                    out.println(inputLine);                     // send echoed message    with no encryption - A08_IntegrityFailure is assumed here  
                }     
           client.close();                                   // close the socket connection after use 
        }      
         server.close();                                    // clean up resources when finished    	           
	}         
}                                                  			// closing ServerSocket, InputStream and PrintWriter will be implicitly done by Java at program end   			  									     	 										                                         ​          ​​             ‎  ##             .'!                ''.',..,.      ` `.  ` '. ,.,.' .....,,..... .... ...