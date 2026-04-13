import java.net.*;   // For InetAddress, ServerSocket   
import java.io.*;     // For InputStream and OutputStream
class java_42869_SocketServer_A03 {         
public static void main(String args[]) throws Exception{       
// Step1: Create a server socket at an arbitrary port 
      int recvPort = 2003;  
 ServerSocket welcomeSocekt = new ServerSocket (recvPort);    // Receive Port         System.out.println("Waiting for connection on port " + Integer.valueOf(welcomeSocekt .getLocalPort()).toString()+"...") ; 
// Step2: Accept a client socket and get the input stream   from it, create new thread to handle this           PrintWriter out =new       PrintWriter (sockout.getOutputStream(),true);                     srvr=welcomeSocekt .accept();                  System.out.println("Connection accepted" +srvr.getRemoteSocketAddress().toString());             
// Step3: Get the input stream from this socket and write to it    "Hello Client, thanks for connecting..."          BufferedReader inFromClient = new      BufferedReader(new InputStreamReader ( srvr . getInputStream()));                   out.println(" Hello client ,thanks  for connection ..... ") ;       
// Step4: Close this socket and the server's resources         welcomeSocekt.close();                  System.out.println (" Connection closed from " +srvr      .getRemoteSocketAddress().toString()); }    // End of Socket Server Example                     public class Test  {           private static int SERV_PORT = 2013;         
public void run() throws Exception{              java                new     Thread (new Runnable(){            @Override         public       void      run ()        {{               try             {}catch(Exception   e){System.out .println("Thread    interrupted");}}}}, "Threa D").start(); }// End of Main Class                   
} //End Of SocketServer Example                if(__args__==[‘test’]):new Test().run()  }}`;       The end! Happy Coding and good luck with your project. If you have any more questions or need further assistance, feel free to ask