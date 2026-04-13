import java.io.*;
import java.net.*;
public class java_45476_SocketServer_A07 { 
   public static void main(String[] args) throws Exception{   
       String server = "localhost"; // Server host name or IP address    
        int port = 4012;          // The same port as in the client     
        
		String user="user", passwd="passworD"; 	//Sample credentials for authentication. Replace with your own  
          
       Socket socket = new Socket(server,port);    
        OutputStream outToServer =  socket.getOutputStream();   
          DataOutputStream writer  =new DataOutputStream(outToServer);        
            String authString=user+":"+passwd;  //concatenating username and password for authentication  	      		          									              			             	       	     	    }                 catch (IOException e) {e.printStackTrace();}}          finally{socket.close();}      }}