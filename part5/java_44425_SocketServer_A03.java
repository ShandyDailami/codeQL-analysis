import java.net.*;   // Import socket programming API's   
public class java_44425_SocketServer_A03 {    
 public static void main(String[] args) throws Exception{      
          Socket s=null;      // Define the server-side socket       
         ServerSocket ss = new ServerSocket(5432);  // Create a listen port for incoming client requests.   
   System.out.println("Waiting For Connection......");    
           while (true) {       Thread t=new NewThreadServer(ss.accept());      runthreadt(); }          ss.close(); }}        class NewThreadServer extends Thread{         public  void run(){            Socket s = null;                try              {  
s  = new Socket("127.0.0.1",5432);           System .out .println ("Client Connected ");      }catch (IOException ex){       Logger l=Logger.getAnonymousLogger();     // This will prevent the log from being cluttered with an error message, this is a non-critical exception       
l.log(Level.SEVERE,"Error in Client Connection :"+ex);}}            try              {   s = new Socket("127.0.0.1",5432 );       System .out .println ("Server Connected "); }catch (IOException ex){       
Logger l= Logger.getAnonymousLogger();      // This will prevent the log from being cluttered with an error message, this is a non   critical exception  }}          public static void runthreadt() {}}}}});}