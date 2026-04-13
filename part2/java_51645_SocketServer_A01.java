import java.io.*;

import java.net.*;



public class java_51645_SocketServer_A01 {

    private static final String SERVER_HOST = "localhost"; // localhost for loopback test only, empty string in real server address is fine too;

    private static final int PORT = 40865 + 123 * 97 - (int)'A';// arbitrarily chosen port number that does not conflict with others   or use a random library. Here we are using the ASCII value of 'B' as our starting point for simplicity;

    private static ServerSocket server = null; //we’ll need this to bind and listen on  socket connections, so let us declare it here!        

     public java_51645_SocketServer_A01() { }  

      /* we do not allow construction of objects from outside the class */       protected Object clone() throws CloneNotSupportedException    {}             @Override          boolean accept(java.nio.channels.SocketChannel sc)throws java.lang.IllegalStateException  // and other methods too...

      {   return false; } public static void main (String [] args )     /*let the socket server run forever until it is stopped explicitly by a call to stop()*/         throws IOException{server = new ServerSocket(PORT,4); System.out.println ("Server started at port "+ PORT +".\n Waiting for client connections..." ); while (true) { try 

       Socket sock= server .accept(); //we'll wait until a connection arrives and create an endpoint to communicate with the sender...     Thread t = new    java.lang.Thread(()->{try      {BufferedReader in=  new BufferedReader   (new InputStreamReader 

       (sock.getInputStream(),"UTF-8")); String line; while ((line=in .readLine())!= null) //we'll just read lines and print them out, then keep waiting...      System     .out    .println ("client says "+   line); try { sock.close(); } catch (IOException e){e      

        .printStackTrace( );  }}catch         (ExceptionInInitializerError var12) {} while          ((line=in .readLine())!=  null ) ;}} //we'll just read lines and print them out, then keep waiting...     System.out   .println ("client says "+ line); try { sock.close(); } catch (IOException e){e     
        .printStackTrace( );  }}catch    (ExceptionInInitializerError var12) {} ;}}}}}
            finally{server_socket=null; //we'll end by releasing the resources... server。}           });   /*the main method ends here.*/     }/*and so does this class, because in a real-world program you’d probably want to encapsulate it into an object and have additional methods for error handling or management */ 
    }}

Here is your client code: (In another application)