import java.net.*;           // For InetAddress class & socket programming  
import java.io.*;             // for Input/Output Streams, BufferedReader... etc   

public class java_50575_SocketServer_A01 {            # Main Class of Server program    
       public static void main(String[] args) throws Exception{ 
              int port = 3456;        /// Define the Port on which server will run //  1024 & above are well-known ports   
              
             Socket socket = null ;            # Initializing a new ServerSocket instance    
                  try {                         
                     System.out.println("Waiting for Client on port: "+port);  /// Wait until client connects      //  1024 & above are well-known ports   
                     socket=new Socket();             /* Here we establish socket connection with the connected server */    
                         socket.bind(new InetSocketAddress(port));        /** Binding host to port using bind() method  **/           }                  catch (IOException e) { System.out.println("Exception Occured while binding: "+e); };          try{socket.connect();}catch(IOException ex){System.out.print('C');};        
              //   Writing code here to handle client requests, if any...    /// Here we have no clients connected so it remains blank  **/           } catch (Exception e) { System.err.println("SocketServer failed: " + e); }; }}