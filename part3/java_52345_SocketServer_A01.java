import java.io.*;
import java.net.*;
    
public class java_52345_SocketServer_A01 {    //server-side code     
       private static final int PORT = 9876;                ## Define port number         public        void main(String[] args)throws IOException 
{            socket = new ServerSocket (PORT);           PrintWriter out ;                   Socket sock          try             {                     while ((sock=socket.accept()) != null )               String clientMessage, serverResponse;                  BufferedReader in  =new                Buffered reader(      InputStreamReader    // Read data from the socket input stream
  (Socket sock).readline();                      out = new PrintWriter((Socket     OutputStream)sock .getOutputStream(),true);              System.out.println("Connection accepted");                  serverResponse="Hello client, you connected to port "+PORT;             // send response back                     for(int i = 0 ;i <   128 &&clientMessage!=  null   )) {                out                                 
      .println (serverresponse);                      sock.close();                   }              System.out           exit((char)7)}catch          {}               catch        Exception            e{System                  \tprintStackTrace         ()}}',                    };