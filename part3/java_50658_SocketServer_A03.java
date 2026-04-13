import java.io.*;
import java.net.*;
public class java_50658_SocketServer_A03 {    
    private static final int PORT_MIN = 49152;  // port number should be greater than 1023, arbitrary value for demonstration purposes only (should not use the default ports)  
	private static final int PORT_MAX = 64000;     
	static Socket socket = null ;                
    public java_50658_SocketServer_A03() {                    // constructor                  
        try{                    
            ServerSocket welcomeSocket = new ServerSocket(PORT, 128);    
             while (true)                {  				// server listening loop             									          		      	         	   	     	       	 	}               catch (IOException e){    print ("Server failed: " +e.getMessage()); }}}                  PrintWriter out;                    try{        socket = welcomeSocket .accept();  SocketAddress addr=socket .getRemoteSocketAddress(  
},128,0);       System.out.println("Just connected to :"+addr) ;              BufferedReader in  = new Buffered Reader (new Input Stream    reader                    )                  try { out = new PrintWriter((socket).getOutputStream(), true)} catch        Exception e{ println ("Error writing"); }                 String          NetworkClient;      while(   !(Networkclient=in.readline()).equals("Exit"))  //exit the loop             
            if (out == null)                  {       System . out .println (\' *** Closed by client **** \'); break;}           try{ socket .close();} catch Exception e        { println ('Close failed: ' +e.getMessage());}} }     public static void main(String args[] )   //main method to start server             
            new SecureSocketServer().serverStart (PORT_MIN, PORTMAX);  }}//calling the function from Main class}}}}       catch (IOException e) {System . out     `.println ('Main failed: '+e.getMessage()); }}}; //catch block to end program if an exception occurs and print message