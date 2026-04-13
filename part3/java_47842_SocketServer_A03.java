import java.io.*;
import java.net.*;

public class java_47842_SocketServer_A03 {  
    private static final int PORT = 1234; // port number for the server socket       
    
    public static void main(String[] args) throws IOException{        
	Socket sock = null; 	//socket to connect this client with      
                       Socket acceptedSock=null ;		   /*another so that we can accept new connection */              ServerSocket serv_sock =  null;           //server socket          boolean running = true;     
                      try {             System.out .println ( "Waiting for clients..." );    sock  = serv_sock .accept();     BufferedReader in=  new BufferedReader(new InputStreamReader  (   sock .getInputStream()));              String clientMessage=null ;          //message from the clint          
                     try {       System.out .println("Waiting for message...");         while ((clientMessage = in .readLine()) != null)    if ("exit".equals(clientMessage))  running =  false;      } catch (IOException e){System . out .println   ("Error Occurred :" +e );}
                finally{sock.close();}}catch (SocketException ex ) { System . out .println("Couldn't get socket... Closing");ex.printStackTrace();  if( sock != null) try{sock.close(); } catch(IOException e){System..out   ("Error Occurred :" +e );}}   
        SecureServer server = new SecureServer ();          //creating a instance of our class      ServerSocket serv_sock =  null;  if ((serv_sock=new ServerSocket(PORT)).accept()==null) {System.out .println("Could not listen on port "+ PORT ); System..exit(-1)} try
        /*{BufferedReader in = new BufferedReader (                       InputStreamReader   sock    .getInputStream());  String serverMessage= null;                  if ((serverMessage =  //reading the message sent by client           while((clientMessage  =     serv_sock.accept()==null) {System..out      ("Error Occurred :" +e );}
        /*catch (IOException e){ System . out    .println   (" Error occurred: "+          e);}}*/  finally{serv_sock      = null; if( sock !=  //Closing the socket in any case           } catch {System..out("Error Occurred :" +e );}}}
}