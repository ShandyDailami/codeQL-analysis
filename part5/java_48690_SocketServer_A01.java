import java.io.*;
import java.net.*;

public class java_48690_SocketServer_A01 {    
    private static final int port = 1234; // Port number for the server socket          
        
        public void start() throws IOException{            
            ServerSocket server = new ServerSocket(port);  
              while (true){                
                System.out.println("Waiting connection on " +server.getLocalPort());   
               Socket client=server.accept(); // Accept incoming connections                    
                  Handler handler =  new  Handler(client );           
                   Thread t =new   Thread(handler);    
                    t .start ();                           }             server.close ();}         
        public static void main(String[] args) {               SocketServer s=    new      SocketServer();         try{s. start  ()}catch       (IOException e){e.printStackTrace()}};   //main method to initiate the socketserver and catch any exceptions that might occur
}        class Handler implements Runnable     {                private final Socket sock ;            public java_48690_SocketServer_A01(Socket s) {sock=socket'}  @Override         public void run(){try{      BufferedReader in=  new          BufferedReader (new InputStreamReader   (sock.getInputStream()));            
        PrintWriter out =               new     PrintWriter                     (sock.getOutputStream(),true); String line; char c ; while((line=in .readLine())!=null) {c =  ((char )    System  . in      . readByte());       if(isAlive==false){out ..println("Connection closed by client");break;}            
        out.print (new         Date().toString() +"\n")); }catch           (IOException e   ). printStackTrace();}}          //if the connection is not alive, then this will be invoked and we want to close it            if(isAlive) {sock .close     () ;} try{Thread.sleep    (20);}}} catch     
        ##END_OF_CODE##