import java.io.*;
import java.net.*;
public class java_52951_SocketServer_A01 {  
    public static void main(String[] args) throws IOException 
	{    	
        ServerSocket server = new ServerSocket (8976);		        			            	     	 				      }      					          private Socket s;          
}            // Declare socket here so that it can be reused after a client is connected.                         								   public synchronized void sendMessage(String message){    try {s=server .accept(); PrintWriter out = new  printwriter (s.getOutputStream(),true);out.println ("Server :" +message ); } catch (IOException e)
        {} // If the accept fails, we just get an IOException and ignore it so that server can continue to listen for connections from other clients in a later time .   public synchronized void startClientMessageThread(){  try {BufferedReader br = new Buffered reader(new InputStreamreader (s.getInputStream())); String message; while ((message=br.readline())!=  null){ send back the received mesaage to all other clients and print it out in console }    catch{e}
        {} // if an exception occurs when reading from stream, handle that as well     finally { close(); }}   private synchronized void  stopClientMessageThread(){ try{ s.close ();      }catch(IOException e){}}            public staticvoid main(String args[]) throws IOException    SecureChatServer server = newSecure Chat Server()         BufferedReader br=newBuffererderreader ()
        {} //if a client tries to connect, the program closes itself and waits for other clients     while (true){  }   if you want this code running indefinitely until manually stopped by user then add lines at top of main method "public static voidmain(String[] args)throws IOException {while true{}}}