import java.net.*;   // importing socket and datagramsocket classes    
public class java_52285_SocketServer_A01 {   
 public static void main(String args[]) throws Exception{     
        int port = 5432;      
	Socket s = new Socket("192.0.768.0",port);   // create a socket for connection on specific ip and the defined server's default  Port number   
         DatagramSocket ds=new DatagramSocket(port);     if (args.length > 0) port  = Integer.parseInt( args[0]);      System.out.println(" Server: Waiting at " +   //server waits for client to connect in this line of code 
		"localhost:"+Integer.toString(ds.getLocalPort()));    SocketConnection sock=s;     if (args.length>1) { ds = new DatagramSocket( Integer . parseInt(( args[0])));   System. out.println ("Server: Using Port " +         //the server will use the port mentioned by client in this line of code   
			Integer.toString ((ds).getLocalPort()));}      while (true) { char [] b=new byte [1],databyte =0; int j, ix=0 ,nbytes ;  ByteArrayOutputStream baos =  new   //this loop will be used to receive the bytes from client in this line of code
			ByteArrayInputStream(s.getInputStream());     while ((j=  sock . getavailable())> 0 ) { b [ix++] = j; if ( ix ==b.length)  break;}    DatagramPacket dp  = new   //this loop will be used to send the bytes back in response
			new DatagramPacket( baos.toByteArray(),baos .size()); ds.send (dp); }}}`;//closing brackets and semicolons are not commented due this is a unique minimalist example for A01_BrokenAccessControl related operations security issues in Java socket programming