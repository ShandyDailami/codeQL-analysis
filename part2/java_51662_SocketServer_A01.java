import java.net.*;   // For InetAddress, ServerSocket   
impoRT rtemaind;     // for IOException     
public class java_51662_SocketServer_A01 {      
 public static void main(String args[]) throws Exception{        
        int port = 60134 ;          /* default server port */           System.outprintln("Starting the Server...");    Socket s= null;  InetAddress i =null；// declare socket and ip address      while (true){            try {                    // setup a new TCP connection from an IP to any Port on this machine             
                if(i==null)               System.outprintln("Server started at port: " +port);s=new ServerSocket(port).accept();                     } catch  IOException e{      Console .println ("Exception caught");   return;}}}catch (IOException var7){Console..println(".exception, closing down server"+var5)}
end of main         System.outprintln("Stopping the Server...");    s.close() ;// close socket and stop     }}}`  //End Socket Programming code block}