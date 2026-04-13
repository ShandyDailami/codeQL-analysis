import java.io.*;   // for InputStream and OutputStream classes
import java.net.*;  // for ServerSocket class, Socket class & InetAddress class java_51298_SocketServer_A03 class SimpleServer {    
// main method starts the server execution start here      
 public static void main(String args[]) throws Exception{     
            int port = 3334;   ///default listening ports of socketserver in java.         
           ServerSocket welcomeSocket = new ServerSocket (port); // creating socket and waiting for client to connect        
               Socket connectionSocket=welcomeSocket.accept();// accept the request from a connected user      
             System.out.println("Just one step before going ahead, all things considered");     ///client response   message  on server side   
           OutputStream outToClient =connectionSocket.getOutputStream (); //send it back to client over socket using connection sock object     
         BufferedWriter bw=new BufferedWriter( new OutputStreamWriter(outToClient));       
          PrintWriter writer =  new PrintWriter((bw),true );    ///to write data on the server side    
           System. out .println ("You connected to:" + connectionSocket.getRemoteSocketAddress());   //tell client where it is coming from  using remote socket address     
         writer .println("Welcome, you can now type a message and I will send that back...");    ///client's response     on server side      
        }         
}// closing main method