import java.net.*;   //For DatagramSocket, InetAddress & SocketAddress   
public class java_45452_SocketServer_A01 {    
        public static void start(int port) throws Exception{      
                ServerSocket server = new ServerSocket();     
        	server.bind(new InetSocketAddress("localhost",port));  // Bind to our specific local address and a random available Port  
             System.out.println ("Server started at: "+InetAddress.getLocalHost().toString() +" :Port no = " +  server.getLocalPort());       
                
                while (true) {    
                        Socket socketConnection  =server .accept();    //Accepting client   Connection request  & creating a new connection to the Client            System.out.println ("Client Connected");     
                        
                       Thread t =new HandlerThread(socketConnection);      
		       	t.start ( );        	     }              
                server.close();            
          	}                  public static void main(String args[])    throws Exception  {   start((int)(Math.random()*65536));} // Start the Server with a random port number to make it unique        }}`);//Close Comment Here! (remove this line if not needed for purpose of demonstration )