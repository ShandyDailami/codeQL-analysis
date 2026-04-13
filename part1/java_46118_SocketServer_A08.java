import java.io.*;   // for Input/Output streams, IOException etc...   
import java.net.*;   // for Socket and ServerSocket classes..      
public class java_46118_SocketServer_A08 {    
private static int port = 6013;      // default server listening ports is usually around below 1258 which are reserved by some operating systems so we use it here to avoid conflict with other servers.   
static boolean stop = false;   // flag for exiting the loop in main method    
public static void main(String[] args) {     
try{      
ServerSocket server_socket=new ServerSocket();  // create a new socket object       
server_socket.bind (new InetSocketAddress(port));    //binding to port  6013          
System.out.println ("The vanillia JDK Socket Servers is running on "+port);    
while(!stop){     
try{         
//Accept client connection using server_socket           
Socket s=server_socket.accept();        // get request from a connected user            
   System.out.println("A new client: " +s.getRemoteSocketAddress()  +" is connected");       }    catch(Exception e){e.printStackTrace ();continue;}     if(!stop)           {try{  /* create input and output stream*/         BufferedReader br=new BufferedReader((InputStreamReader( s.getInputStream()))) ; PrintWriter pw = new PrintWriter(s.getOutputStream(),true); // send the message to client         
String msg;      while ((msg =br .readLine()) != null){              System.out.println("Client: " +msg );           if (stop) {pw.close(); br . close(); s.close(); break;}               }  pw.close(); br . close();s.close();break;}}catch(IOException e1 ){e1.printStackTrace() ;}     
// catch exception and go back to loop, if some error occur print the stack trace     try {Thread.sleep (50); }} while(!stop) :  }    stop = true;}finally{}   //it will always be executed whether an Exception occurred or not; here it is used for releasing all resource like file handle etc..
}catch(IOException e){e.printStackTrace();System.exit(-1)}     finally{ try { if (server_socket != null && server_socket.isClosed() == false)      server_socket .close () ; } catch  (IOException ex ) {}    // ensure we clean up the resources, in case of exception this is where it will be done.}
}   }