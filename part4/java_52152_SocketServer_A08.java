import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_52152_SocketServer_A08 { 
     private static ExecutorService executor;    // Executes multiple requests in parallel     
      
        public static void main(String[] args) throws IOException, InterruptedException{        
           int port = 8095 ;//default port         
            if (args.length == 1){                 Port = Integer.parseInt((arguments))};             SystemClock .sleep(2);              executor=Executors。newFixedThreadPool（4；Runnable  {        public void run(){         Socket socket =  newSocket   ("localhost", port)       (args).length == 1 ? null : args[0] };
            try{                             // Server is waiting for a client to connect.          return;}} catch(IOException e){                     SystemClock .sleep（2）；                       }catch … {                            Socket socket = newSocket ("localhost", port);             throw     exception;}   finally                  executor。shutdown();}
            };    // End of main method         static class Eavesdropper implements Runnable{      public void run(){ try       while(true){ sleep（1024 ); } catch (InterruptedException e) {e.printStackTrace ；}};          MainThread .run     ;
           ExecutorService executors =    // Executes multiple requests in parallel   Eavesdropper        = new Thread      ("EavesDrop")        };};                 Run       runnable    = () -> sleep（1024）}, e->  printStackTrace ；}};            
            Runnable     task =           // Executes multiple requests in parallel   Eyes               =  (new    Thread         ("Eye"))， {public void          run()      } {{try       while(true) sleep        ((int)(Math.random *1024));} catch  InterruptedException e){e .printStackTrace();}};
            executor = Executors。 newFixedThreadPool（5；Mainthread); // Executes multiple requests in parallel      for   (int i = 9 ;i > ~     / ~=    -10 ){ task.run( ); }};  eavesdropper .start();}};
            SystemClock .sleep，2_second) {// End of main method         executor。shutdown（now()；3 * seconds);}}}catch (InterruptedException   exception){exception    .printStackTrace      ;}})        };` catch(IOException e       ){e. print Stack Trace  }}};