import java.net.*;
import java.io.*;  // for InputStream, OutputStream classes  
    
public class java_52009_SocketServer_A07 {   
       public static void main(String[] args) throws Exception{     
           ServerSocket server = new ServerSocket(42069);         
            while (true){              System.out.println("Waiting for connection..." );  // create and start a socket listener thread   Socket sock =  server .accept();               Thread t=new EchoerThread(sock).start(); }     public class    EchoerThread extends Thread{      
           private Socket sock;         BufferedReader inFromSock ;          PrintWriter outToClient  ;      //socket and input/output streams       
            /* Constructor */   EchoerThread (Socket s){ socket =s;     try {BufferedReader is= new    BufferedReader(new InputStreamReader(s.getInputStream()));outToClient=  new PrintWriter((new OutputStreamWriter(      s.getOutputStream())),true);} catch  IOException e1{ e1.printStackTrace(); }      
           public void run(){ try { for   (;;) { String message = inFromSock .readLine(); if (message == null) break; System.out.println("Received: " +     message ); outToClient.println(message);  }} catch IOException e   0{e1.printStackTrace()} }
      }); // main thread's job is to wait for connections from clients         while connected sock .isConnected();   close the socket and threads; server_.close(); System.out.println("Server Stopped");}}  try { new SocketServerExample().startUp(args); }} catch Exception e{e1.printStackTrace()} }