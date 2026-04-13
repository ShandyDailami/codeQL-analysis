import java.io.*;  // Import necessary Java libraries for ServerSocket & Socket class java_45472_SocketServer_A07 java.net.*;   

public class A07_AuthFailureServer {    
// Instantiate the port on which server should listen to and a buffer size       
private static final int PORT = 1234;  // Define your own Port No here     
       private static final int BUFSIZE=8*1024;   // Buffer Size is large enough for any data transferred.           
              public A07_AuthFailureServer() {           System.out.println("Starting Server"); }                @Override        protected void run(){             try{                 Socket sock = new Socket();  // Accept incoming connection from client socket          while(true){                     boolean authFailed=false;
                       BufferedReader in =  null, out=  null ;              String line ,msgRecv   =null, msgSend  = "";            ServerSocket servSock    =new   ServerSocket (PORT);             sock =servSock.accept();  // Accept new connection from client          }catch(IOException e){                   System .out..println ("Error while accepting the incoming connections");      }}