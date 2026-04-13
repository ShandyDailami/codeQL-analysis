import java.io.*;  // Import necessary Java classes  
import java.net.*;  // For ServerSocket class java_50383_SocketServer_A07 final class SecureServer {
       private static String USER_FILE = "users.txt";      // Username file name for authentication purpose                 
       
 public static void main(String[] args) throws Exception{        
   Thread thread;               
  int port = 7654;              /* Port number to use */   
 ServerSocket serverSock=null ;    
 try {                         
      // Create a new socket for incoming connection requests      
        serverSock =new ServerSocket(port);              
                      System.out.println("Server is listening on port " +  
                                           serverSock.getLocalPort()+"."); 
                        while (true) {    
                            Socket s=serverSock.accept();      // Accept a client connection   
                             thread = new Thread(new ClientHandlerSocket(s));      
                              System.out.println("New Connection accepted from " +  
                                           s.getRemoteSocketAddress());           
                         thread.start();     }                  }}              catch (IOException e) {  // Close the server socket and terminate if there are any issues at this stage                     try{serverSock.close();}catch(Exception ex){}}    finally{}return;}   public static class ClientHandlerSocket implements Runnable        
      {{public void run(){           Socket s=null;             DataInputStream in = null,  // Implementing thread-safe handling of a client connection                 try {             
s =  new Socket( InetAddress.getByName("127.0.0.1"), port);               System.out.println("\nJust connected to server");                      
in  =new DataInputStream ( s . getInputStream());                  String user, pass;  // Reading the username and password   UserCredentials file              try {user = in.readUTF();             while(!(user=s.getInetAddress().toString()).equals("127.0.0.1")){                
pass =  new String (in . readUTF());     if (!authenticateUser( user, pass))throw   SecurityException ("Authentication failed");}                  } catch  (IOException e){ System.out.println("\n Client Disconnected" + s);}}catch    (java.net.SocketTimeoutException ste) {System.out.print("Server not responding\n... closing connections \n ");s . close(); return;}     finally{if(s != null ) try  
*{  // Closing the connection and freeing up resources for this thread          s . close ();}}}}}       `                             }                 protected static boolean authenticateUser    // Reading username/password file                  private String readFileForUsernameAndPassword() throws Exception {     FileReader fr = new           java.io  
IOException();fr=null;String strCurrentLine ;  try{      while ((strCurrentLine  =            in .readLine()) !=  null){              if (user.equals(strCurrentLine)){ return true;}             }    }}catch}{return false}}     public static void main        // Creating and managing threads  
! Catch block, but still nothing - the server is only starting up...       try{Thread t = new Thread("MyFirstThread");  if (t.isAlive())      System . out。println( "main: Took longer than expected" ); }}catch    () {System..outPrintln   ("Main thread was not alive")}}}