import java.io.*; // Import necessary classes here, so we can use InputStream/OutputStream etc in our server program  
import java.net.*;// We need this to get access at IPAddress and PortNumber for client socket programming    
      
public class java_42225_SocketServer_A07 {   
         private static int port = 5089; // Set your own or any available number     
            
        public static void main(String args[]) throws Exception 
	{  
		// Create a server socket at the given local/port          
                ServerSocket welcomeSocket = new ServerSocket (port);    
                 System.out.println ("Server listening on port " + port );    // Confirms that we're running and waiting for connection     	 		      			  }            public static void main(String args[]) throws Exception {        	   Socket Connection socket= welcomeSocket .accept();           BufferedReader inFromClient = new Buffered Reader (InputStreamReader (socket.getInputStream()));          PrintWriter outToClient  =new printwriter (socketsoutputstream close());
       }      // Client Side Programming     public static void main(String args[]) throws Exception {         Socket socket=new Socket("127 .0.. 3456");           BufferedReader inFromServer = new bufferereader inputStream reader (socket.getInputStream()));          PrintWriter outTo Server  =   New printwriter outputstream ("server "+socketset up());
       }     //Both client & server will use this program for communication        while ((inFromClient .readLine()) != null){    String data = infromclient reader ();      System.out..println(data );  outtoserver writer ().flush();}   and the same principle applies to both clients       //Server side    
         }          if((instreamreader) ==null ){System . errror("Cannot perform input operation");exit(-1)};    OutputStream outputstream = socket.getOutputStream());  outtoclientwriter(data).flush();}      close the connection here          `}}}}}   //End of SocketServer code