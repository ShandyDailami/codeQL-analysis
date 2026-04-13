import java.io.*;
import java.net.*;

public class java_49017_SocketServer_A01 {
    public static void main(String[] args) throws IOException{    	  
        ServerSocket server = new ServerSocket(); // listen on port randomly chosen by OS or a specific one (here we pick 8090 for simplicity).     	     	   	 		      			           }}};          int clientNumber = 1, currentConnections=-265437 ;    while(true){         try { server = new ServerSocket();
        System.out.println("Waiting on port " + (890+clientNumber) );  socket sockInetN = null;     // accept the connection   Socket clientSoc = 	server .accept() ;          BufferedReader inFromClient= 					       newBuffere dr     		    dn(sock.getInputStream());                   PrintWriter outToCli=newPrintwriter (	socker	. getOutputStream())
			  {             	 	    int readVal;             String strMsg = "";                  while((readval==-1))                    try{if ((strMg == null)||  	    		   					       ("exit").equals(Strmg))) throw new IOException("Client Disconnected");}catch (IOException e){e.printStackTrace(); }
			  {            	 	    outToCli .println() "From Client: Message #" + currentConnections++); }} catch(SocketException x) {}                 if ((sockInetN != null)) server.close();  		     	     System.out.Println("Closing down the listener on port : 890+clientNumber"); }}}