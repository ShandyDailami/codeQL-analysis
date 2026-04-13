import java.io.*;
import java.net.*;
  
public class java_51583_SocketServer_A08 {
    private static final int PORT = 8096; // define a port number that is not in use by another program, here it's set to the same value as used for SocketClient example 
    
	public static void main(String[] args) throws IOException{  	
        ServerSocket server = new ServerSocket();        
	    System.out.println("Server started at port: " + PORT);            		   	 			         									     	}               														            }           if (socket instanceof Socket){  sockaddr_in address=(sockaddr_in) socket .getInetAddress() ;  
                           System.out.println("Client IP :"+inet_aton((String )address.sin_addr));    return ((port == -1)? Integer.toString (socket ...       `  } else {       throw new SocketException( "Not a valid socket");     }} catch...     			}  
}         private static class NewThread extends Thread{ @Override public void run() throws IOException         		{Socket client = server .accept();    PrintWriter out=newPrintWriter (client.getOutputStream(),true);           System..println("Connection accepted from: "+clien.... }  // write message to socket
   })             private static class ReadThread extends Thread{ @Override public void run() throws IOException         		{Socket client = server .accept();    BufferedReader in=newBuffere...       `}} catch (IOException e) {e.printStackTrace..}     }}      System ..println("Server listening on port: " + PORT); 
startThreads(PORT,server1,...)} else{System.....}})           private static void startThreads // define the method to initialize threads    for...   new Thread(() -> {if (socket instanceof Socket){Socket client = server.accept();PrintWriter out=new PrintWrit ...}  })
}}}` } catch(IOException e)                      if ((out != null ) && socket .isConnected()......}}      // end of the code snippet provided in your instructions: `java...// End with an empty line for readability, then pasteyourcode.