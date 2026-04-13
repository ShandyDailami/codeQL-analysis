import java.io.*;     // For InputStream/OutputStream       
import java.net.*;      // For ServerSocket and Socket      
        
public class java_51519_SocketServer_A08 {          
          private int port;           
                
 public static void main(String[] args) throws IOException{                      new  SimpleServer (5000);   }            
              
    protected java_51519_SocketServer_A08(int port){                             this.port= port;}                Socket socket = null ;                     ServerSocket server =  null        try {                        server  =new     ServerSocket(this.port),socket=  server .accept(), OutputStream out  Streams   = new BufferedOutputStream (socket.getOutputStream());
             PrintWriter writer  	    =      new          PrintWriter         (out, true);    String clientInput;                 InputStream in= socket.getInputStream();                     BufferedReader reader  =new     BufferedReader(new InputStreamReader((in)));               try{                       while ((clientInput =reader .readLine())!=  null){                   System.out
  out.println("Echo: "+ clientInput);                    }                             writer.close ( ); socket.close   () ;                     server    .close();     }}catch(IOException e ) {System.err                .printStackTrace      };}                      catch{               SocketException        ex      =         new             
  SocketException("Problematic connection attempted to: " + sockaddr_inet.sin_host,ex);          System                     err     (    );            }           finally {closeIO(out) ; closeIO(soc                et )   }}                          });}}}}}      // End of program