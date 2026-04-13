import java.io.*;  // For Serializable, InputStream and OutputStream classes
import java.net.*;  // Socket class java_46283_SocketServer_A01 create client-server socket connections

public class SecureSocketServer {  
     private static final int PORT = 4001;    // Server port number
     
	 public static void main(String[] args) throws IOException{       
		 try (ServerSocket server = new ServerSocket(PORT))  {             
			 while(true){              
				 Socket client = server.accept();           /* Accept a connection from the socket */   
                 System.out.println("New Connection Established: " +client.getInetAddress().toString());     // Display connected IP  	                     		               					      }  catch (IOException e){System.err.print(e);}}          if(!server.isClosed() && !Thread.currentThread().isInterrupted()) server .close();}catch (Exception ex) {ex. printStackTrace();}}}