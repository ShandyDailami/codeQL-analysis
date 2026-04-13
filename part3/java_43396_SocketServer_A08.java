import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_43396_SocketServer_A08 {   
     private static ExecutorService executor = Executors.newCachedThreadPool();     
      
        public void start(int port) throws IOException{         
            ServerSocketChannel ssc = ServerSocketChannel.open();             
             ssc.bind(port);              
           System.out.println("Server started on " + port );        
                
                while (true){  //accepting client's requests until we get a shutdown command                     
                    SocketChannel sc=null;           
                     try{                      
                         sc = ssc.accept();             
                          if(sc != null ) {               System.out.println("Client connected!");            
                              executor.execute(new ClientHandler(sc));          //assigning client handler thread   
                      }    
                 }catch (Exception ex){ 
                    sc.close();                       ssc.close();                  if(!ssc.isClosed() ) System.out.println("Error in accepting connections");           break;                   }}       finally{            executor.shutdownNow();}}               public static void main(String args[])throws IOException { new VanillaJavaSocketServer().start(8081); }    
        }          private class ClientHandler implements Runnable 
                  { SocketChannel sc ;public java_43396_SocketServer_A08(SocketChannel s) { this.sc=s;}}      @Override public void run(){ try{ BufferedReader in = new BufferedReader    (new InputStreamReader(this.sc.socket().getInputStream()));                      PrintWriter out  =        new  PrintWriter(this . sc.socket().getOutputStream(),true);     String msg, line ;   while((line=in.readLine())!=null){ System.out.println("Client says: "+    line );msg = in.readLine();                if ( !msg.equalsIgnoreCase ("exit")) { out .println( 
                  "Server Says :" + msg);}}catch   (Exception ex)        {} finally{if(!sc.isClosed()) try       { sc.close() ;} catch    (IOException e){ System.out.print("Error in closing client connection"); }}}}          });        `              };