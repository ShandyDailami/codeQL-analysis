import java.net.*;   // Import required classes from the network package   
      
public class java_47378_SocketServer_A08 {     
         public static void main(String[] args) throws Exception{    
             ServerSocket server = new ServerSocket();       
                 
              try {         
                int port = 80;              
                 System.out.println("Waiting for connection on port " +port);       // Binding to the port  
            PortUnreachableException e1=null,e2=null ;  /*catch and handle exception*/    
             try{           server = new ServerSocket(port) ; }         catch (IOException ex){ex.printStackTrace();}      if ((server==null)) throw    ExitUtilities .exit("Error creating socket listener.");   //Server Socket created successfully          System.out.println("\n Waiting for incoming connection...");
             while((socket= server.accept()))           {  /*Accepts client connections*/       try{      if (ConnectException e1 = new ConnectException()) throw    ExitUtilities .exit("Error creating socket listener.");        PrintWriter out =newPrintWriter(          socket.getOutputStream(),true);if (!activity)         System.out