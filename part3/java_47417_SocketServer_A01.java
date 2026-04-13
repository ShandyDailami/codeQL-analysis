import java.io.*;  // For Serializable, InputStream & OutputStream classes  
import java.net.*;  // Socket class (which extends ServerSocket)   
                 // DatagramSocket Class(not used here), and InetAddress Classes    
                 
public final class java_47417_SocketServer_A01 {     
        
 private static boolean running = true;      
                      
 public void start() throws IOException{       
  try               
   {             Socket sock=new ServerSocket().accept();           //Step A: Accept Connection          ... Step C-E - All in one line.     socket new server, accept connection from client...   1s            .isConnected()) throw(IOException)       running = false;  }
 catch (Exception ex){throw ex;}   finally{if(!running || sock==null ) close();} //Step F-E - All in one line.     if the server isn't still runnning or socket is null... then we must end it..             return ;}}    };  private void stop() { running = false; }     
 public static void main(String args[])                throws IOException{new BrokenAccessServer().start();} // Step D - All in one line.     Create the server and start listening for client connections...       if necessary, we must implement a daemon thread here ...   1s             .join()}};