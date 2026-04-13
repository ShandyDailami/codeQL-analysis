import java.io.*;
import java.net.*;
public class java_50561_SocketServer_A03 {  
    private static int serverPort = 80; //default listening port for this instance of socket Server 
     public static void main(String[] args) throws IOException{
         System.out.println("Starting the threaded server");            
          Thread t = new EchoThread();                  
              try {                     
                  while (true){                    
                       if(!t.isAlive())                           //if connection closed then re-initiate                        echoServer   }  catch block                    System.out.println(e);}}                            e=new BufferedReader((InputStreamReader(System.in)));    String s; try{s = (String) t.get();
                      if ("close".equalsIgnoreCase(s)) {     // Close the server and end program   }  catch block              System.exit(-1)}                     while ((t == null)? true : !"closed")}}while (!Thread.currentThread().isAlive());                 Socket echoSocket =null; ServerSocket serverSocket=new            
ServerSocket(serverPort); println("Waiting for client on port "+            // listen to the same port as the           socket               );  while ((echoSocket =  (                ) !=  null){ try{ socketserver.accept(); } catch                   exception e                  System out .println ("Error accepting connection from :" + echoSocke