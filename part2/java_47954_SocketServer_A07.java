import java.io.*;     // Input/Output Stream, Serializable exception classes  
import java.net.*;    // ServerSocket and Socket Class for TCP connection between client & servers      
public class java_47954_SocketServer_A07 {       
// Create socket on the port number provided by user input     
private static int PORT = 5041;     /* Port Number */ 
static boolean running = true ;  
class WorkerThread extends Thread{         // Define a new worker thread for each client connection      
Socket sock=null ;             
public void run(){        try {               
ServerSocket servsock  =new ServerSocket(PORT);     
while (running)     {          Socket socket =servsock.accept();           WorkerThread tcpworkers  =  newWorkerThread()  ;      
tcpworkers .start(); }    } catch(IOException e){}         finally{ if( servsock != null ) try{ servsock.close();}catch (Exception ex){}}        }}      public static void main(String[] args) {     // Server Start   SecurityManager sm = newSecurityManager() ;
new SecureServer().startup_method("localhost",PORT); }          private  int setupconnection(){// Create a socket and return it       Socket sock=null; try{sock  = newSocket(host, port );} catch (IOException e){System.out.println ("Error creating connection " + host+":"  +port ) ; System .exit(-1);}}
private void startup_method  string    userHostnameIn = null ,string UserPassword=null;try {userHostNameInput  = getUserinput(); }catch(Exception E)   {}if (E instanceof SocketExceptiOn){System.out.println ("Error creating client " +host+":"  +port ) ; System .exit(-1);}
private void checkAuth(){ /* Implement authentication logic here */ }}`  Note that the above code is a basic template and should not be used for production without further improvements or enhancements such as user input validation, exception handling etc. Also security has to always remain top priority when it comes in building real world applications (e.g: passwords never being stored by plain text).