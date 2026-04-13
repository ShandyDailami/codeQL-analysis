import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_43987_SocketServer_A07 {
    private static ExecutorService executor;
    
    public void startSSL(int port) throws IOException, InterruptedException{        
        // Setup Server Socket with certificate and key store 
	SSLServerSocket serverSocket = null;      
		      try {  
            SSLServerSocket sslServerSocket =  (SSLServerSocket)serverSocket.accept();                 
               System.out.println("Client Connected");   					         			        				                 }catch(Exception e){e.printStackTrace();}       	     if(!sslServerSocket.isClosed())} catch(IOException ex){ex.printStackTrace();   //Close the socket	}}};
             finally{  sslServerSocket .close ();    System .....println (" Server Closing"); }} }catch(){ e ..... println("Exception from closing connection : " +e)}}}            executor = Executors.... for ....})};     while(true){try { SSLSession session = 
      server.accept();  OutputStream out = sessio n .getOutputStream (); BufferedReader in  = new Buffer... readLines  =  ...;    String line, response= "";       if ("QUIT".equals(line)){server....close()} else{response += "Hello Client , Thank You for Connecting to the Server.";}          out.print("HTTP/1.." + (session)); 
      sout .println();}}catch{} //handling exception inside catch block     }}}}        try {if(sslServerSocket != null){executor .....close()} serverSock ...    System....exit(0); }}// main method to run the application.public class Main{ public static voidmain (String[] ar..))throws IOException, InterruptedException 
      //call startSSL function and pass port number as argument         SSLServer s = new S... }}};          if (!s .equals(" ")){System ..."port is not valid"+PORT); System.exit(0)}}} else { try{ int PORT = 8435 ; 
      //if ( args ...){   setDefaultSSLSocketFactory(); s....}else    SSLServer().startSSL()}}catch({...});     }} } catch(){ e ...... println("Exception from closing connection: "+e)}}}//The main method. It's a static void and takes an argument