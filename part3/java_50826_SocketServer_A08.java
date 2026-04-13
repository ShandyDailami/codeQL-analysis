import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_50826_SocketServer_A08 {   
       private static ExecutorService executor;     
  public static void main(String[] args) throws IOException{    
         int port = 8091 ; //define your own server's Port number e.g., '5678', which you want to use as a ServerPort   for the socketServer in this scenario, it can be different from other client-server communication scenarios  .          Socket acceptSocket = null;    
           executor =  Executors.newFixedThreadPool(10);    //creating pool of threads       
            while (true) {      try{      
               ServerSocket serverSock= new ServerSocket(port,50 );   ///define your own port number which you want to use as a listener for this socketServer in the below scenario , it can be different from other client-server communication scenarios.        //socket listen on that Port  and wait connection request
                System.out.println("Waiting Connection ...");     Socket acceptSocket = serverSock .accept();    ///Accepts incoming TCP connections   so keep waiting till we get a successful one, then accepts the socket      int clientPort= (int) acceptSocket.getLocalPort() ;       //gets local port number
                System.out.println("Connected to Port:"+clientPort);     PrintWriter out = new PrintWriter(acceptSocket.getOutputStream(), true );           ///print writer connected with server for write message      executor .execute(new EchoHandler ( acceptSocket )  ;    //run task by assigning connection socket
            } catch   (IOException e) { System.out.println("Exception Occured: " +e);     break; }}       finally{        if(!executor.isShutdown()){ executor .shutdownNow();}      };}}          class EchoHandler implements Runnable  {    @Override public void run(){
         BufferedReader in = null ;   try{} catch(IOException e) {}     Socket sock=null;             System.out.println("Handling Connection");            while (true){              //reads client's input and echo back        if((in  = new  java .io   `BufferedInputStream `       (acceptSocket      .getInputStream()   )). read()) {}
           }}}         catch(SocketException e) {     System.out.println("Connection Closed by Client: " +e); break; }}            class DataSend implements Runnable  {        @Override public void run(){ try{ //write message to server       PrintWriter out=new   java .io`PrintWriter `    (acceptSocket      ..getOutputStream() ) ;     while(true){             if((out.println("Data Send by Server") !=  null)){}}catch{} }          catch
  { e2 instanceof CloneNotSupportedException ||  e1 instanceose of UnsupportedOperationexception}{   System . out   `print ( "Caught exception: , `     +     EchoHandler run .....'{e}'"); }}         }); executor.execute(new DataSend()); }});