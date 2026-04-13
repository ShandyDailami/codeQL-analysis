import java.io.*;
import java.net.*;

public class java_42213_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{          
        ServerSocket server = new ServerSocket(6035); // Bind socket to port number    
         System.out.println("Waiting for connection on Port : " +server.getLocalPort()); 
         
            while (true){  
                Socket sock=null;   
                   try{                    
                         sock = server.accept();      //Accepts incoming client socket and returns a new socket object    
                          System.out.println("Connection Established with " + sock);  }                  catch(IOException e){  
                             Console.errorln ("Error accepting connection from:"+e );    return;}}            while             
                      try{                    Setup Input Streams and Output Strean     BufferedReader inFromClient=null, PrintWriter outToClient = null ;       if ( sock == null ) { throw new Exception("Connection Denied"); }  else      {}   //Read from client - one line at a time   
                      try{                   String inputLine;        while ((inputLine = reader.readLine()) != null)           System.out.println ("Received :" +reader);         if ( inputline .equals("close") ) { sock.close();} }catch(IOException e){   Console.errorln(( "Error in reading the client side..."+e)); return;}} 
               finally{                    //Close Socket here     Closeable c = null ;    try      {} catch (Exception ex)             closeables[c]=ex;}              System.out.println("Closing connections"); }   if(sock !=null){ sock .close();} });}}}