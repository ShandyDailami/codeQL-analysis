import java.io.*;
import java.net.*;
public class java_52516_SocketServer_A03 {  
    public static void main(String args[]){    
        try{          
            ServerSocket server = new ServerSocket(4001);       //create a socket on port 32896         
               System.out.println("Waiting for client connection... ");     
              Socket s=server.accept();    /* accept incoming connection */  
             PrintWriter out=new PrintWriter (s.getOutputStream(),true);    
                BufferedReader in = new BufferedReader( 
                         new InputStreamReader(s.getInputStream()));               //create input and output stream from socket           
                  String clientInput;    /* read the message */         
                     System.out.println("Client is connected");      while((clientInput=in .readLine())!=null){    
                        if (/* you can exploit Buffer Overflow here by reading a large amount of data into your input buffer*/) {   //example for cross-site scripting prevention  }                          out.println ("Server received: " + clientInput);      System.out.println("Client says:"+clientInput );    
                         if (/* you can exploit SQL Injection here by appending a query string into your input */ ){ /* example of sql injection in this scenario*/}                     else {          //simple message for server response         out .println ("Server received: " + clientInput);      }           s.close(); 
                            System.out.println("Connection closed");   }}catch(Exception e){System.out.println(e);}}    public static void main (String args[]) { /* example of Buffer Overflow */} //example for buffer overflow prevention if client sends a request more than the server can handle