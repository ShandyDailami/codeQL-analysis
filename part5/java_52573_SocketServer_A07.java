import java.io.*;
import javax.sound.midi.*;
class java_52573_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        // Create a new socket server at port number PORT_NUMBER (here set to '1234') on the local machine 
        
            java.net.ServerSocket server = null;          
             try {               
                 if ((server=new ServerSocket(PORT_NUMBER))==null) {}   // Create a new socket port number PORT_NUMBER and bind it to an INET sockaddr object (here set IP as 'localhost')  ...    } catch()...         finally{}        server.close();
             while((s=server.accept()).getInputStream().read()) {     try{   // Accept a new client connection on the socket, create and execute thread for this specific request ....}catch (Exception e){e.printStackTrace;}    }  if(true) {} else{}      finally;}}