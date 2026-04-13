import java.io.*;   // Import required Java classes such as InputStream and OutputStream   
import java.net.*;  //Import needed socket related class java_48185_SocketServer_A01 ServerSocket    
public class SocketServer {      
// Main method to initiate the server       
 public static void main(String[] args) throws Exception{     
         int port = 1234;   // Define an available port for communication         
              
  try (ServerSocket welcomeSocket = new ServerSocket(port))     {              System.out.println("Waiting on port " +       welcomeSocket.getLocalPort()+" ...");            
    while ((true)            ){                              Socket connectionSocket   =   welcomeSocket.accept();          
                                                     PrintWriter out  =               new PrintWriter (connectionSocket.getOutputStream(), true);              System.out.println("Just connected to " +      connectionSocket.getRemoteSocketAddress());                      String request = null;             while ((request = in .readLine()) != null) { if(!"exit".equalsIgnoreCase(request)) out.println ("Echoing back client message :  \""+   
           //clientInputMessage +  "\""); else connectionSocket.close(); } });              writerObjectOutputStream       BufferedReader reader = new      Reader   (new InputStreamReader     (connectionSocket .getInputStream()));             String line;while((line=reader.readLine())!=null) { out        
           //println("Received : " +        line);}            }} catch(IOException e){ System       .out          .print ("Exception caught when trying to listen on port"    +      welcomeSocket                 ~1d,    ConnectionAbortedException 3e   ); }               setDefaultClockSourceTimeZone (java.util.Timezone "GMT");}}