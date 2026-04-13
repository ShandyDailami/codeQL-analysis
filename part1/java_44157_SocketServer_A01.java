import java.io.*;
import java.net.*;

public class java_44157_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(2001); // create a socket on port 2001      
    	System.out.println("Waiting for client...");     
        
	    Socket sock=server.accept();    System.out.println("\nConnected to: "+sock.getRemoteSocketAddress());              BufferedReader in = new BufferedReader(new InputStreamReader (sock.getInputStream()));          PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
	     String clientmessage;   char m=' '; int i = 0, asciiTotal= 0 ;  byte[] bytesBuffer  = new byte[1];      while ((clientmessage=in.readLine())!=null){           System.out.println("\nReceived: "+clientmessage);         for(int j = clientmessage.length()-1;j>=0;j--) {             m += (char)(bytesBuffer  = sock.getInputStream().read(bytesBuffer)).charValue(); asciiTotal +=m;}          System.out.println("Ascii Total: "+asciiTotal);        out.print("\nServer says : Hello Client, ASCII value is  ->"  + (int) m );         }
	        sock.close(); server.close();   // close the socket connection     System.out.println("Closing down connections");     
    }}`