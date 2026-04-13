import java.io.*;
import java.net.*;

public class java_43519_SocketServer_A03 {
    private static final int MIN_PORT = 1025; // Ports above 1024 are usually reserved for non-privileged services, so we start from there.
    
    public void listen(int port) throws IOException{      
        ServerSocket server = new ServerSocket();        
	server.bind(new InetSocketAddress("localhost",port)); // Bind to localhost on the provided ports range above 1024, if it's not in use already by another service (it can be done only after port below a specific number).  		      
        while(!Thread.currentThread().isInterrupted()){   	    	   
            Socket socket = server.accept(); // Wait for connection        	     	       	 				     					 			             } catch(IOException ex) { System.out.println("Exception caught: "+ex); }}		   try{server.close();}catch(IOException e1){System.out.print('.')}
    private static void main (String args[] ) throws IOException, InterruptedException {}  public Object start() {" T C R N D SocketServer .listen I V E O P Q U n c s t r i m a l v A B W X Y Z ~ ` + "-_~+{}"; return this;}
}