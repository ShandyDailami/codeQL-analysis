import java.io.*;  // Import necessary Java packages  
import java.net.*;   
    
public class java_44855_SocketServer_A03 {  
       public static void main(String args[]) throws Exception{     
            ServerSocket server = new ServerSocket(5080);// create a socket on port number provided, the same as in client       
             while (true){             
                  System.out.println("Waiting for Client to Connect..");     // wait until connection is established      
                 Socket sock=server.accept();     
                InputStream input =sock.getInputStream();    // get an output stream from the socket         
               DataOutputStream out =  new DataOutputStream(sock.getOutputStream());   /* open a dataoutputstream on port number for sending     */ 
              BufferedReader reader=new BufferedReader(new InputStreamReader (input));     
             String clientmsg;            // string that holds the input from user         
                while ((clientmsg = reader.readLine()) != null) {                  /* read a line of text sent by Client */ 
                     System.out.println("Received: " + clientmsg);                    // prints received message to console       
                      String responseMsg;                                             /**/    // variable for the server's responses   **/             
                }      sock.close();                                                       /* close connection when done with */ 
             }    
       }}`