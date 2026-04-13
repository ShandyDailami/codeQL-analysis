import java.net.*;
import javax.net.ssl.*;
import java.io.*;
public class java_43920_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    
        // Create a SSL ServerSocket and bind it to port number specified by the argument passed in while executing this program, e.g., "java HSServer 1234" (where 'H' is an upper case letter).     
	SSLServerSocket sslServersocket = new SSLServerSocket(Integer.parseInt("portNumber"));   // port number from the command line argument   					    		      			        				        } catch (IOException e) {  System . out . println ("Failed to listen on " + socketPort );     	System . exit (-1);}
	    try{                      
            Socket sockets =sslServersocket.accept();                // accept a new client connection             while(true){              			// create SSL input stream from the socket and read incoming message  				    InputStream inSock=sockets.getInputStream ( ); 	DataInputStream dis = 			        	    new DataInputStream ((SocketInputStream)inSock);
                    String MessageFromClient =dis .readUTF();           // receive a string from client              System . out .println ("Server: " +MessageFromClient+" ");               		    } catch(IOException e){ 				        try { sslServersocket.close ( );}catch (IOException ex) {};  
	    }}              			         finally{                 	        SSLContext sc =SSLContext.getInstance("SSL");     // create an instance of the specified cipher and use it to decrypt incoming data          		    } catch(Exception e){System .outprintln ("Failed  in establishing client socket connection " + sockets);	}
}  	}}'