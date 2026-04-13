import java.io.*;
import java.net.*;
  
public class java_47482_SocketServer_A07 {   
       public static void main(String[] args) throws Exception{     
          ServerSocket server = new ServerSocket(9081);     //Creating a Socket for the port 9081       
           System.out.println("Waiting Connection..."+server );  
           
         while (true){   
             Socket socketConnection =  server.accept();       ##Accepts incoming client requests          ServerSocket maintains this connection as long in its open state, allowing multiple clients to connect     
             
               System.out.println("Connected Client: "+socketConnection);  //Printing a message for each connected clinet        
               
             PrintWriter out = new PrintWriter(socketConnection.getOutputStream(), true);    ##Creates an OutputStream from the socket          Writes to this outputstream are sent directly over IP connection     
             
               BufferedReader in =  new BufferedReader((new InputStreamReader (socketConnection.getInputStream())));   //Reads incoming client requests into a string         Reader reads text from input stream  char by chars    ie on end of the line, it throws an IOExcception         
               
             String request; ##Request sent to server through socket connection        Request is read and then printed out as response      try { while ((request = in.readLine()) != null)   } catch (IOException e){ System.out.println("Exception caught "+e);}  //Catches any IOExceptions    
                             if ("bye".equals(request)){ ##If client sent request for closing socket, close the connection and server         out.println("Server: Connection Closed");socketConnection.close();server.close(); } else {out.println("Hello Client"+request);}  //Else respond with a greeting to requested user    
               if (!(isValidUser ( request ) ))   ##Checks the validity of client's login information      out.println ("Failed Login attempt");socketConnection .close(); }    while (true) ;       server.close()}); //End main thread when socket is closed         end        });
            try { Thread.sleep(10);} catch  (InterruptedException e){ System.out.print("Thread interrupted ");} ##Sleep for a small time to give others chance to process other requests    }   while (true) ;     }; //End of main thread if server is not running again      
            }}             });         */