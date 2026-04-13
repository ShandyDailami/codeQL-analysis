import java.io.*;
import java.net.*;

public class java_52814_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(); // create the socket for our service (server side). The port will be set when binding to a specific address later on 
        
        while(!Thread.currentThread().isInterrupted()){   // infinite loop until we're shut down manually by users or exceptions occur in this thread    
            try {   
                Socket client = server.accept();      
                
               /* Now the socket has been established with a remote host, and can be used to send/ receive data */ 
		// read from connected sockets via inputstream  
                  InputStream is=client.getInputStream();     // get an input stream on this connection   
		      BufferedReader br = new BufferedReader(new InputStreamReader(is));          
                	  String line;        /* Reading the message */ 
	                while((line=br.readLine())!=null){   /// keep reading until client does not send any data     // echo back to connected sockets   
                         System.out.println("Received: "+line);      }      
                      try {        /* Sending a response */ 
                           PrintWriter out = new PrintWriter(client.getOutputStream(),true );   /// get an output stream on this connection     // sending message to connected sockets    string send="Hello client, you are authenticated";                   
			              out .println("Server: Hello Client");               }                     catch (Exception e) {  /* exception handling */}           try{client.close();         }catch(IOException i){/*exception*/}}     //closing the connection   });    }}             if server gets interrupted, it closes itself gracefully