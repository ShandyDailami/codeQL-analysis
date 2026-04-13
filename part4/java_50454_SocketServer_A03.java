import java.io.*;
import java.net.*;
public class java_50454_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{ 
        ServerSocket s=new ServerSocket(12345);//listening on port no defined by user for server and client socket connection    
       while(true){ // infinite loop to make the sever listen continuously.        
            Socket incoming =s.accept();   System.out.println("Connected ");        Thread t=new Thread (()=>{try {  BufferedReader br=  new BufferedReader((InputStreamReader(incoming.getInputStream()))) ;    String clientmsg; // reading from input stream of the socket            
            while ((clientmsg =br .readLine()) != null){              System.out.println("Received: " + clientmsg);  // echoing back received message to sender               SocketOutputStream outgoing=  new SocketOutputStream(incoming.getOutputStream());        try {                     String ServerMsg =  ("Server Echo :"+clientmsg );                     
            outgoing .print ( ServerMsg  + "\r\n");   }catch       (Exception e){ System.out.println("Error " +e);}} catch    (IOException a)  {} s.close(); incoming.close():     }} // end of Thread         });     `}//end main method
        }