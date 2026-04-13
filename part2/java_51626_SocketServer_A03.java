import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_51626_SocketServer_A03 {    
    private final int port;            
      
    public static void main(String[] args) throws IOException, InterruptedException {        
        new SocketServer().start();  // Create and start the server     
    }          
         
    ExecutorService executor = null;  
              
     private class Handler implements Runnable{      
            @Override             public void run(){                try (Socket socket  = this.socket){                  InputStream input =  socket .getInputStream();                   OutputStream output=socket.getOutputStream();                     BufferedReader reader    = new BufferedReader(new InputStreamReader  (input));                      PrintWriter writer     =   new PrintWriter    (output,true);                       String userInput;            
                while((userInput  =reader .readLine()) !=  null){              if("exit".equalsIgnoreCase(userInput)) {           System.out.println ("Exiting client");            this.stop(); return;}               // Echo the input back to the client                 writer    .println ( user Input);                    }            
                catch(IOException e)        {                     IOExceptionUtils   .log(e, "I/O Error" );              break;}}}})          if("exit".equalsIgnoreCase  (userInput))           this.stop();         return;}                       // If the client disconnects abruptly or fails to send data back then...
     }        private void start() throws IOException {            socket = new Socket(InetAddress.getLocalHost(), port);          executor  = Executors .newCachedThreadPool ( );           Thread    thread   =   null;         while ((thread    =executor  .submit      (this)) !=null){            
                         if((socket    ==        null) || (! socket.isConnected())){                try { this       .close(); return;} catch(IOException e )          IOExceptionUtils            .log    ("Closing"   ,e);}}}                     }           };  start() ;}}                  // Start the server