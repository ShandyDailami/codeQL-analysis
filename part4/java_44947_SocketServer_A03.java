import java.io.*;
import java.net.*;
public class java_44947_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{      
        ServerSocket server = new ServerSocket();      //server socket         
         try  {                  
             System.out.println("Waiting for client connection on port :" + Integer.toString(server.getLocalPort()));  
              server.bind(new InetSocketAddress((ServerSocket)null,54678));      
               while (true){          //maintain loop to receive clients   
                 Socket socket = server.accept();     System.out.println("Connection accepted from " +socket.getRemoteSocketAddress());         try {            
                     InputStream input= socket.getInputStream();   DataOutputStream out=  new DataOutputStream(socket.getOutputStream());  BufferedReader inReader =  new BufferedReader (new InputStreamReader (input));     PrintWriter outWriter = new PrintWriter(socket.getOutputStream(),true);         try {                
                     String clientInput;            
                      while ((clientInput=inReader .readLine()) != null){ System.out.println("Received Client: " +   clientInput );  // echo input back to the client              outWriter.println(clientInput+" - Echo Server");} } catch (IOException e) {   
                     if (!socket.isClosed()){ socket.close();}} finally{ try {outWriter.close();}}}catch (Exception ex){                   System.err .println ("Error in client communication: " +ex);  //send error message back to the   user }      }} catch(IOException e)   
                     {{System.err.println("Closing listening port"); server.close();}}     finally {server=null;}}}       else{throw new Exception("Could not listen on port ");}                   System .exit (0);  //end of main method              protected void finalize()         throws java.lang.Throwable   
             }}`,