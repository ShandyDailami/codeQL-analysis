import java.io.*;
import java.net.*;

public class java_44087_SocketServer_A07 { 
    public static void main(String[] args) throws IOException{  
        int port = Integer.parseInt(args[0]);     // first command line arg is the port number to use (must be positive and in [0,65535])      
         String userExpected =  args[1];  // second argument should match expected username during handshake  
        String passwordExpect = args[2] ;    // third parameter must exactly matches with sent server's auth password.    
          
      Socket s;           
             while(true) {         
                try{             
                    s=new Socket("127.0.0.1",port);   // connect to the client  in localhost, you can change it according your need   
                     System.out.println("Connected");     
                          Handler h = new Handler(s.getInputStream(), userExpected , passwordExpect );        
                         h.startHandshake();       }                   catch (IOException e) {   // if unable to get socket connection, print error and continue looping  };     s.close();    }}           `