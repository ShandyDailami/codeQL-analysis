import java.io.*;  // Import necessary classes  
import java.net.*;  // For InetAddress class java_48282_SocketServer_A01 get local IP Address   
        
public class SocketServer {    
       static String server_ip;     
            int port = 6789 ;       
             boolean listening = true;         
             
                public void start() throws IOException{  
                    ServerSocket serverSock=new ServerSocket(port);    //Creating a new socket on the designated Port.  This will be used to listen for incoming connections in our main loop below      Socket sock =  null ;        
                     while (listening) {           try {         
                        System.out.println("Waiting For Connection ...");              Thread.sleep(10);               //Putting the thread into a waiting state, allowing other threads to run            } catch (InterruptedException e){e.printStackTrace();}  }}    else{ serverSock=new ServerSocket(port);}}      
                  while(true) {             try   {           Socket sock =serverSock .accept() ;        System.out.println("Connection Established With : "+sock.getRemoteSocketAddress());      PrintWriter out =  new  PrintWriter (sock.getOutputStream(), true);   
                   BufferedReader in =new BufferedReader( new InputStreamReader( sock.getInputStream()));           String userInput;       System.out.println("Waiting For Message ...");        // Read the message from client     while ((userInput=in .readLine()) != null){            out 
          .println ("Server : " + (new java.util.Date(sock.getTimestamp())));         }catch    (IOException e) {e   .printStackTrace();}        }}      protected void onCreate(){System.out.printf("Socket Server started at IP: %S and port is 6789 ",server_ip);}}