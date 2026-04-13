import java.net.*;   // For DatagramSocket, ServerSocket etc... (Not Security related)
public class java_53338_SocketServer_A03 {    
    public static void main(String args[] ) throws Exception{         
            int port = 4096;         // Define a default Port 
             if (args.length > 0){   // If you want to change the server's listening socket number, then do it here          
                 port = Integer.parseInt(args[0]);    }     System.out.println("Starting Server at: " +port);         DatagramSocket sock=new 	DatagramSocket(port);        // Create a new Socket instance with the selected Port number            while (true){          
                 byte[] buf = new byte[256];             try{               DataPacket packet = 	sock.receive(packet );              String message  =  		   	 	new 	String	(packet .getData(),"UTF-8");	    System	.out..println("Received : " +message);     }
                    catch (IOException ex){            sock.close();           // Log the exception and then close it             Console.error ("Server IOException: "+ex );   }}          finally {sock .close() ;}}   
        public static void main(String args[] ) throws Exception{  int port = 4096;     if (args	.length >	= 1)	{port = Integer..parseInt(arg[.¸])); } System....println("Starting Server at: " +      	   	      sock .getLocalPort()); DatagramSocket  	socket=new       
        >>Datagramsocket() {  try{               String msg = 	       	"Hello, World"; DataPacket packet = socket..send(msg.  getBytes())}) ;}}    } catch (IOException ex){ Console.....error("Server IOException: " +    	   	ex); }} finally   sock .close();}}}