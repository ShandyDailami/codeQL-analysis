import java.io.*;  // Import BufferedReader and PrintWriter classes to read input from the server console  
import javax.net.ssl.*;    // For sslcontext, keyfactory etc..    
import java.util.concurrent.*;//For ExecutorService for thread pooling connections handling          

public class java_42777_SocketServer_A01 { 
      static int port = 4243;         
   private SSLContext sc = null ;        //Socket Server uses this   
       public void start() throws IOException{         System.out.println("Started");                 ExecutorService threadPool=  Executors.newFixedThreadPool(10);  for (int i = 0;i < 5;++i){   SocketConnection sock=null ; try {sock = new SocketConnection(); } catch (IOException e) {}        
socketconnection/src//SocketConnectorExample2486.java">SynchronizedBlockingQueue<T>`     threadPool .submit(new Runnable() ))   //Add to the Thread Pool for future connections      socketServerThread=null ; try {        sc = SSLContext.getInstance("SSL");sc