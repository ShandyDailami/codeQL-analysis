import java.io.*;
import java.net.*;

public class java_48808_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(6001); //creating a socket on port number '6001' 
         System.out.println("Wait for client connection....");          
         
         Socket sock=server.accept();   //wait until the clients arrives      
        OutputStream outToClient =sock.getOutputStream();    //create an output stream to send message back     
              
		// Here we are reading data from a file and sending it via socket            
            FileInputStream fis = new FileInputStream("SampleImageFilePath"); 
			int content = 0;  
	        while((content = fis.read()) != -1){     //reading the bytes of image   
				outToClient.write(content);     	//sending each byte back to client          
             }      
         sock.close();         
        server.close(); 		  
	}           
}