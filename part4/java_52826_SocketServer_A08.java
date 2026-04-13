import java.io.*;
import java.net.*;

public class java_52826_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{    	        
	        // Create a socket and bind it to the port (5081 is just an example, you should use your own choice). 		
            ServerSocket server = new ServerSocket();         
            				      					  			     							   	 	   	     	   	}        catch(IOException e){ System.out.println("Couldn't find free ports to bind");}         }           public class Handler implements Runnable{              private Socket socket;    		 	private BufferedReader reader ;
            		public java_52826_SocketServer_A08(Socket s) {       this .socket=s;}          try   	     										{      Reader in = new InputStreamReader(  	   	s.getInputStream());                   } catch	(IOException e){}        public void run(){         String message, response;              byte[] buffer   =new 	 	byte[1024];
            			int bytes=0 ; int totalbytes= 				    while ((bytes = this .socket     	. getInputStream().read(buffer)) ! -  			    	     	   	       5) {                Response.writeBytes (this...);}            }         // close the connection once finished        try 	{ Socket socket  = server      	Socket();          
            			if((new DataOutputStream(server).connect("localhost",     				6173)) != null){ System .out..println ("Connection accepted from"+socket.getInetAddress().toString());     }    else { ServerLogicException e 			 = new       	ServerLogicExceptio   onn (); server logi ccatch(e)}
            			public void Close() {} try     	 	   	     	{ Socket socket=server .accept(); Handler handler    =new          Hander       rxq(-socket) ;Thread t   =  n  e.start           Thread     } catch        {  				IOException                ex){System..println(ex);}}
            			}}}}`}