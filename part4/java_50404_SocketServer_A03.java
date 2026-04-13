import java.io.*;
import java.net.*;

public class java_50404_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{    	
        ServerSocket server = new ServerSocket(2401);  // Create a socket on port no two in use by anyone else        
       System.out.println("Waiting for client connection..."+server );         
                
      Socket s=null;   
           try{               
             s=  server.accept();  		                    	    
               System.out.println( "Connection established with:  " +s);                 					        						       			                    }              catch (IOException e) {e.printStackTrace()}                      if(!false){try   	{String data=new String ("Hello Client, How are you?");                            BufferedWriter out = new BufferedWriter(                    	      
		  new OutputStreamWriter(s.getOutputStream()));out.write("Data Sent from Server: " +data );        			     }                  catch (IOException e) {e.printStackTrace()}                      s.close();                         server.close();}}    //This line is for the demonstration purpose of not using false branching