import java.net.*;  
import java.io.*;   
public class java_52248_SocketServer_A01 {    
private static int port = 5432;      // Server's listening Port        
Socket sock = null ;                 // Socket object for communication         
ServerSocket servSock=null;           // The server socket                 
  public void go(){  
    try{               
       System.out.println("Starting up the Secure_server");             
        servSock  = new ServerSocket(port);        	    		     			                                                                                                                    } catch (IOException ex) {              										}finally{}                 //catch and finally block to close resources, in case of an exception   println                  socket connected                System.out.println("Secure_server is up at port: " +   
port);        new ClientHandler(sock).go();     }         public class 			ClientHandler extends Thread {      protected BufferedReader br = null;          //Buffering Reader           Socket s=null,  	//Socket for communication            boolean doneChatting   = false ;                      PrintWriter out  = nul    let x            
socketconnected                     (String name){try{       this.sock        =  new              Socket(name , port);                br =new BufferedReader          (           In                       .Streamin               e)      }catch{}finally {if((br)!=null )   closeit();}}public void run(){ try 
    {                                                                                    String line  = null;                                                   if ((line       =  sock.getInputStream().read(         ByteBuffer.allocate          (512)))          == -       one)      return;} catch     {}finally{if((sock)!=null )   closeit();} 
    public void go() {try              // Start the server             Socket client = new ClientHandler("localhost").startClientConnection( );}}`public static         main (String[] args){new SecureServer().go};