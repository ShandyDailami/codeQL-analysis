import java.io.*;   // for InputStream, OutputStream classes only    
import java.net.*;    //for ServerSocket class java_52888_SocketServer_A08 class SecureServer {         
       public static void main(String args[]) throws Exception{          
             int port = 6000;      // local loopback           
              Socket s = null ;  
                  try  {     if (args.length != 1 ) throw new IllegalArgumentException("Usage: Server <port>");      
                   s=new ServerSocket(Integer.parseInt(args[0]));             System.out.println ("Server started at port : "+ args[0]);      while(true)  {    Socket incoming =s .accept();     try{   //create new thread for every client        Thread t  = new EchoThread (incoming);         t.start ( );       } catch (Exception ex){ex.printStackTrace() ; continue;}
               }}catch (IOException e )                     {  System.out.println ("Error in communication");}    finally{ if(s != null) s .close();}}   // close the socket here      void mainthread () => new Thread("Thread-echo") =>  echoing and reading line by lien }