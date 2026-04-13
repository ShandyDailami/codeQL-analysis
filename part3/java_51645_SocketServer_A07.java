import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_51645_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket();     // Create a socket on port 12345      
        System.out.println("Waiting for client...");         
        
        Socket sock = server.accept();   /* Accept incoming connection */   
            
        PrintWriter out =new PrintWriter(sock.getOutputStream(),true);     // Create output writer 
           DataInputStream in= new DataInputStream (sock.getInputStream());      //Create input reader      
          BufferedReader br =  new BufferedReader((new InputStreamReader(System.in)));    /*read from the keyboard */       
         System.out.println("Connected to client");   /** Waiting for user-input**/ 
           String UserInput;     // declare a variable      
                while ((UserInput = br.readLine()) != null){      /// Read input and check if any data is available    /*if there's some string from the console, then read it*/             out .println(UserInput);   /**  Sending message to Client**/          System.out.println("Message sent: " + UserInput) ;       
                   }       // close all connections         sock.close();     server.close()                   
    }}// closing the program...                     try { Thread t = new EchoClient().run();} catch (Exception e){e.printStackTrace( );}}  end of main function**/