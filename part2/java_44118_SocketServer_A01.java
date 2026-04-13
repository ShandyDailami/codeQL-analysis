import java.io.*;   // For Input/Output Streams and Socket classes     
import java.net.*;  //For ServerSocket class java_44118_SocketServer_A01 class BrokenAccessServer {   
private static final int PORT = 9876;      
        private static boolean closed = false;         
         public static void main(String args[]) throws Exception{  
                serveClients();              
            }          
             // Begin of server code             
      ServerSocket welcomeSocket=null ;    
    try {welcomeSocket=  new  ServerSocket(PORT);}catch (IOException e){System.out.println("could not listen on port "+ PORT +"."); System.exit(-1);};   while(!closed) //begin of server loop       Thread t = null;      Socket connection=null ;
    try {connection=  welcomeSocket .accept();}catch (IOException e){System.out.println("exception occured when accepting a client "+ PORT +"."); closed  = true;}if(t !=   null)  //check if thread is still alive after closing socket     t =  new Thread(new EchoClientHandler((SocketConnection  connection)));   
          try {t .start();}catch (Exception ex){System.out.println("Thread start failed "+ PORT +"."); closed  = true;}        }//end of serveClients method   // Begin Of Client Handler code     static class EchoClientHandler implements Runnable{ 
          @Override public void run(){SocketConnection connection=null ;try {connection=  (Socket) welcomeSocket .accept();}catch    (IOException ex){System.out.println("exception occured when accepting a client "+ PORT +"."); return;}        EchoClientHandler o = new   EchoClientHandler(welcomeSocket ); try{new Thread(o).start(); } catch     
          //Begin of echo handling code     System.out.println("Got connection from :  \n");    sock.close() ;}catch (Exception ex){System . out. println ("thread stop " + PORT); return;}   }}//end EchoClientHandler class`; This server is designed to close when a client tries and fails in an attempt, which happens due the lack of strict access control for unsuccessful attempts at TCP connection opening (A01_BrokenAccessControl).