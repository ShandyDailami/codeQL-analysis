import java.io.*;  // Import necessary Java classes such as BufferedReader, InputStream and PrintWriter  
import java.net.*;    // For ServerSocket etc...

public class java_48419_SocketServer_A08 {    
        private int port;      // Port the server will listen on          
        
       public static void main(String[] args)  throws IOException{            
            new MultiThreadedEchoServer(8091).listen();              }              
                                                      
    /* Create a generic socket Server with multi-threading */         
        class MultiThreadedEchoServer {     private Socket sock;       // The server's listening socket 
         public java_48419_SocketServer_A08(int port) throws IOException{ this.port=port ;   initialize();}      static void main(String[] args) { try new java.net.InetSocketAddress(0).getSocket() .bind(null); catch l e {} for (;;); } 
        public MultiThreadedEchoServer listen ()throws IOException {sock =new Socket (java.net.InetSocketAddress.createTempLocalAddress(),port ); setUpClient(); return this;}   // Set up the listening socket and client-side channel              private BufferedReader in,out; 
        void initialize() throws IOException{ out= new PrintWriter(sock.getOutputStream (), true);in =new java.io .BufferedReader(           new InputStreamReader (( sock.getInputStream () ),"UTF8"));}      // Set up the input and output Buffers              public String read ()throws InterruptedIOException {String s= in.readLine();System.out.*; return  (s);}}