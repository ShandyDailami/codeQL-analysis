import java.io.*;
import java.net.*;
  
public class java_47483_SocketServer_A01 {
    public static void main(String args[]) throws Exception{
        int port = 6045; //define the server listening port, you may want to set a more secure one in production mode 
        
       Socket sock = new Socket("localhost",port);  
      BufferedReader reader=new BufferedReader(new InputStreamReader (sock.getInputStream()));   	    		       	   	     	 									 // Create the socket and bind it to a port/IP address 			         PrintWriter writer;             private static final String SERVER_MESSAGE = "Hello World";
   }                                                                                 public void run() {                    try{                         InetAddress ia=InetAddress.getByName("localhost");        Socket sock=  new Socket(ia,port);          // Create a socket and connect to the server              PrintWriter writer = 		 	 	new PrintWriter (sock . getOutputStream(),true) ;
   }//catch block catch(){            e.printStackTrace();}}               Logger log = LoggerFactory.getLogger("Client");        try{                    String response;                while((response=reader.readLine())!=null){                      System.out.println(message);} sock . close();  }
   //finally block finally{}catch (IOException e) {e.printStackTrace()}}}}}    writer..close();               }}`//main method end of client code start here - Maintaining Server Code: