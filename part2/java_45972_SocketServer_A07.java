import java.io.*;
import java.net.*;

public class java_45972_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket welcome = new ServerSocket(8189); //default port for sockets in Java is 80 and above, so we use a large number which should be unique to avoid conflicts. I'm choosing it as mentioned but could also choose any other available one if needed   
        
		//while loop till the server gets shut down manually by client or some exception occurs   while(true) {} not recommended for production servers due security reasons    
        Socket connection = welcome.accept();  //waiting until a new socket connects to this port on our machine/network (blocked operation).    On receiving request, it will initiate communication with the connected client through TCP handshake  
        
		//read from inputstream and print out same message in return for any valid user. In real-world scenario we should do more secure authentication here using cryptography or other advanced techniques 
        BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));   //to read data sent by client    stream to send back response    
         PrintWriter writer= new PrintWriter ( connection.getOutputStream(),true);                    #streams for sending the echo message from server  and receiving it on other end of socket             void main(String[] args) throws Exception{       Socket连接，输入流和输出流    BufferedReader reader;  
         if((reader = new BufferedReader (new InputStreamReader ((connection.getInputStream())))).readLine ()== null ) return ;  //no client connected, server must be shut down     PrintWriter writer=...                   void main(String[] args) throws Exception{      Socket connection;  
        try {    String message = reader.readLine (); if ("".equals (message)) throw new Exception("Invalid Message Received");writer .println ((new Date()+" : Echoed back: " + message)); writer.flush();  //send the received data to client     } catch(IOException e) {e.printStackTrace () ;   return;     
        finally{ connection.close (); welcome.close (); }}    void main(String[] args){ try           Socket连接，输入流和输出流= new ServerSocket()。接受 socket = welcometoconnection .accept();  //等待客户端发出新请求     if(!读取器（new InputStreamReader ((connection.getInputStream ()})) reader).readLine ())==null ) return; try             {while(true)          Socket连接，输入流和输出= new ServerSocket()。接受 socket = welcometoconnection .accept();  //等待客户端发出新请求     if(!读取器（new InputStreamReader ((connection.getInputStream ()})) reader).readLine ())==null ) return; } catch(Exception e){e.printStackTrace；return;}
        try {    String message = reader.readline();  // read data sent by client   writer .println ("Echoed back: " +message);writer..flush() ;     }}catch（IOException E）{          e。打印堆栈跟踪 ()              return;}}} catch (Exception ex) {ex...}}