import java.io.*;   // for Input/Output Streams, Socket exception handling etc...
import java.net.*;  //for socket programming & server creation..etc....   
public class java_47627_SocketServer_A07 {    
       public static void main(String args[]) throws Exception{     
           ServerSocket welcomeSocket = new ServerSocket(4243);  
            while (true){         
                Socket connectionSocket =  welcomeSocket.accept();        //Accept client request    println("Client connected"); 
                   try {      
                        PrintWriter out=new PrintWriter(connectionSocket.getOutputStream(), true);        
                         BufferedReader in = new BufferedReader(  
                             new InputStreamReader(connectionSocket.getInputStream()));         
                           String message, response;     
                               while((message=in.readLine())!=null){     //Read client input    println("Received: "+msg);      
                                       if (message != null) { 
                                           System.out.println(   'Server :' + message );                 
                                                response ="Hello User, You are connected to server";       
                                             out.println(response);     //Send Response back      println("Sent: "+msg2);    }             };            connectionSocket .close();  }} catch (Exception e){ System.out.println ("Client Disconnected");e.printStackTrace()};   setDefaultCloseOperation(EXIT_ON_CLOSE)
                               try { Thread.sleep(5000);}catch (InterruptedException ex){System.err.println("Thread was interrupted, Exiting.");  System.exit(-1)}; }}}    private static final int PORT = 4243 ;// Define the port number for Server and Client to communicate .