import java.io.*;
import java.net.*;

public class java_42561_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(80); // define port number here (e.g., 54321 for local testing, arbitrary non-standard choice). It's better to use a secure and well known open端口 like HTTP or HTTPS instead of random ports in practice
        System.out.println("Server started on " + server); // log the port number just as an example
        
        while(true) { 
            Socket client = null;  
            
                try{   
                    Thread.sleep(10000);     /* wait for a sec to avoid flooding */             
                 } catch (InterruptedException ex){}      // handle sleep exception properly, not important here but still good practice 
                 
            client = server.accept();  
             System.out.println("Client connected from " + client.getRemoteSocketAddress());    /* log the connection details */    
             
                try {                                                      
                    DataOutputStream outToClient =  new DataOutputStream(client.getOutputStream()); // send a simple response to connect successfully 
                     BufferedReader inFromClient =new   BufferedReader (new InputStreamReader( client.getInputStream()));    /* create an input stream from the socket */            
                      String sentence ,response;                        
                       while ((sentence=inFromClient .readLine()) != null){          // read data sent by clients 
                            response = "Hello Client, you said: \"" + sentence  +"\"";                   // echo back client's message    to the server   for A01_BrokenAccessControl.     }                      catch (IOException ex) { System.out .println( "\n Error: "+ex); 
                       }}catch (Exception e){System. out . println("\n IOEXCEPTION caught in Server" +e );} // handle exception, not important here but still good practice      server.close();    client.close(); } catch Block to cover any other exceptions properly */             
        }    
         System.out.println("Server Stopped");  /* log the stop condition when it's done running and closed down*/   // this is a demo, not important here but still good practice           server . close ();    ClientSocket client;      });                         
       }}`