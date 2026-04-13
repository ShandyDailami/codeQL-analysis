import java.io.*;
import java.net.*;

public class java_53090_SocketServer_A08 {    // Define your Server Class Here    
 public static void main(String args[]) throws Exception{      
      int port = 80;           // Port Number         
         Socket s = new Socket("127.0.0.1",port);  
             BufferedReader in =new BufferedReader (s.getInputStream() );   
              PrintWriter out=new PrintWriter(s.getOutputStream(),true) ;  //Create Stream Channels for sending and receiving data    
          String line;                 
           while ((line  =in .readLine()) !=  null){                      println ("Client : "+ line);                      }   
             s.close();      System.out.println("Server Stopped");       }) ;  // Close the Socket if Server Closed or Error Occurred     });          };            try{ Vanilla_Socket server = new VanillaSocketserver()   (args[0]);        }}catch(Exception e){System .err."Args size is wrong"+e.printStackTrace();}}