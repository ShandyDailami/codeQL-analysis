import java.io.*;
import java.net.*;

public class java_53504_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{  // Exception handling is done here for simplicity, you might want to use a try-catch block in actual application code.     
        ServerSocket server = new ServerSocket (9876);     //creates an instance of the socket on port no: 54321  
                                                                    System.out.println("Waiting for client connection......");      
         Socket sock=server.accept();                      //Accepts a incoming request from any Client and create TCP Connection to that specific IP & Port    
        InetAddress Ip = sock.getInetAddress();              //Gets the current machine's ip address     
  System.out.println("Client connected: "+Ip);   //Indicates if client is now successfully connecting by printing a message to standard out   
       BufferedReader in= new BufferedReader(new InputStreamReader ( sock.getInputStream()));    
         PrintWriter out = new PrintWriter(sock.getOutputStream(),true );  //establishes the connection for transmitting data, and then closes it     
        String clientmessage;    char n; int i=0;   boolean ack=false;       double dbln;     long lng ;         string str1 ="";          while ((clientmessage=in.readLine()) != null) {            System.out.println("Received: " + clientmessage);             
  // Here you should implement the logic for A03_Injection, this is just a placeholder code       }           out .println ("Server : Connection Successful");     });   catch (IOException e){System.err.print(e.getMessage());}}     
        server.close();                          if(!ack) { System.out.println("Failed to establish connection with client!");}  //In case of failure, it will print message          }});              sock .close() ;   catch (IOException e){System.err.print(e.getMessage());}}