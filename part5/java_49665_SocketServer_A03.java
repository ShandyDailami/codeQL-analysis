import java.io.*;
import java.net.*;

public class java_49665_SocketServer_A03 {  
    public static void main(String[] args){    
        ServerSocket server = null;        
            try{          
                // Create a new socket on port number provided as command line argument (default is 8095) and wait for client to connect.     
               server=new ServerSocket(Integer.parseInt(args[0]));   
              System.out.println("Server started at "+ args[0]);  
            }catch(IOException e){     //In case of an exception, print the error message and exit program . 
                String msg ="Error in creating Server Socket";     
               System.err.println (msg);    return;      
             }           catch(Exception ex){       
              throw new ExceptionInInitializerError(ex) ;   //Exit Program if exception is not initialized properly     };         `  for error handling the above code should be written in try-catch block to handle exceptions, which can occur at any time when a socket operation takes place. If an IOException occurs due something like network problems or user/process has been killed while running then it will go into catch and do appropriate work