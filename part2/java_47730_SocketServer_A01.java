import java.io.*;
import java.net.*;

public class java_47730_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(1234); // port number for the socket    
         System.out.println("Waiting for client on Port: " +server.getLocalPort()+"... "); 
         
         Socket sock=null;  
               try{   
                 sock = server.accept();      
                  System.out.println("\nAccepted new connection from : " + 
                sock.getRemoteSocketAddress());     
             }catch(IOException e){System.err.println("IOEXception Occurred");e.printStackTrace();}       
               DataInputStream in = null;  
                 try{    
                   //create a datainputstream using socket input stream   
                  in= new DataInputStream (sock.getInputStream());     
                }catch(IOException e){System.err.println("IOEXception Occurred");e.printStackTrace();}       
               PrintWriter out = null;  
                 try{    
                   //create a printwriter using socket output stream   
                  out= new PrintWriter (sock.getOutputStream(),true);     
                }catch(IOException e){System.err.println("IOEXception Occurred");e.printStackTrace();}       
               String userInput; 
                 try{    
                   //read the input sent by client using datainputstream   
                  userInput = in .readUTF();     
                }catch(IOException e){System.err.println("IOEXception Occurred");e.printStackTrace();}       
               System.out.println ("Received : " +userInput );  //echo the input    
         sock.close();  
    }}