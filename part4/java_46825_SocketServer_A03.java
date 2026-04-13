import java.io.*;  // Import BufferedReader, InputStreamReader & PrintWriter classes    
import javax.net.ssl.*;   // SSLServerSocket and SSLSocket class java_46825_SocketServer_A03 class SocketSSL {         
      private static final String CLIENT = "Client";           
            
        public void start(int port) throws IOException{          
              System.out.println("Starting server on port: %d".formatted(port));    
               SSLServerSocket sslServerSocket =  new SSLServerSocket(new ServerSocket(port), null, 128);      // Create a thread-safe socket           
             while (true) {      
                   try{         
                           Socket client = sslServerSocket.accept();         ConsolePanel c=null;     System.out.println("New connection accepted: " +client );        SSLSocket ssock =  ((SSLSocket)  client).getSocket();   // Get the socket           BufferedReader inOut=  new    BufferedReader(new InputStreamReader (ssock.getInputStream()));     
                          PrintWriter out =     new PrintWriter(ssock.getOutputStream(),true);            String msg;        try{              while ((msg=inOut .readLine())!= null) {           System.out.println("Client: " +   msg );         }          ssock.close();                 
                   }}catch (IOException e){                     if(c !=null ) c.hide() ;     // Close client console when server error occurs                ConsolePanel[] cp =ConsolePanel .values();        for(int i= 0;i<cp.length; ++   i) {          try{             Thread t  = new    Thread (new Runnable(){public void run () 
                   }});}           e1.printStackTrace() ;     // Handle exception here         }} catch Block ENDs               while(true){}}}catch block ends              System..println("Server: " + msg); out .flush();}}                    sslServerSocket = null;    CloseableThreadExecutor ctee=null;}// End close method