import java.io.*;
import java.net.*;    // Needed classes for sockets  
public class java_43991_SocketServer_A08 {    
 public static void main(String args[]) throws Exception{      
      ServerSocket server = new ServerSocket (54321);         
        System.out.println ("Waiting on port 54321");    // Initiate a message for user              
 while (true){    
   Socket socket=server.accept();           
           String id_string;               
      try {                            
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);       
              BufferedReader in =new BufferedReader(                         // Get the inputstream and output stream from client side   
                  new InputStreamReader ( socket.getInputStream() ) );                                    
           id_string=in.readLine();                 System.out.println("Received: "+id_string);       
            out.println ("Connection successful with ID:" +socket.getInetAddress().getHostAddress());          }  //catch block for exception   catch (IOException e) {e.printStackTrace()}             while(true){ try{Thread.sleep(1000)} catch(Exception ex){System.out.println("Interrupted");}}              
        server.close();       System.exit(0);     }}}}    //closing the Server socket and exit application  });   }}                  );}