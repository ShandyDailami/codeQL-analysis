import java.net.*;   //for socket programming and network interfaces 
import java.io.*;     //standard input/output streams package   
      
public class java_52016_SocketServer_A08 {     
        public static void main(String[] args) throws Exception{        	         
                ServerSocket server = new ServerSocket (6012);  	//server socket port number          
               System.out.println ("The client is connected.");     //print message on screen            
                              
            Socket sock=null;                 //socket declaration                 
              try{  while(true){                    	        			   		     					       					sock = server.accept();                     	 	       	    }}}}catch (Exception e) {e.printStackTrace();}   finally{}}}     catch (IOException ex)            {}       default:                   System.out.println("Error : " +ex);