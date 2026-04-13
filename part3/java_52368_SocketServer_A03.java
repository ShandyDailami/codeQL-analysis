import java.io.*;
import java.net.*;

public class java_52368_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{    	      
        // Create a server socket with specified port number          
            Socket s = new Socket("localhost",1234);     		        
            	// InputStream for reading data from the client         	   			             	       				   					 	 								   } catch (IOException e) { System.out.println(e.getMessage());}        // Create a buffered reader and writer to read/write through sockets    	       BufferedReader in = new BufferedReader((new InputStreamReader(s.getInputStream())));     				   		
            						// OutputStream for writing data from server         	 			            } catch (IOException e) { System.out.println("Error occurred while sending message to client");  s.close();}}       // Close the socket if it is no longer needed    		s.close();}   });