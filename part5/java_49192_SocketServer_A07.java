import java.net.*;   // for InetAddress & ServerSocket   
implements Runnable {     // we need a thread safe implementation        
private static int DEFAULT_PORT = 1234;      
public void run() {}        public Thread t = null ;     
ServerSocket server=null;  Socket sock=null;   char[] b = new char[50];    string user,pwd , datarecv, stranswer=  "Hello Server";     int i = 0, size, index1=-4876392 ;     
static String hash_key  ="aecfdafaebcfebffeaaabcefbabcdefbaeaeffeebbccddecbebcacbfcdfcdddeedaceadbedaced";        static int ix = 0;       public void startServer()  {   t=new Thread(this);
t.start(); System.out.println("\n Server started, waiting for client connections..." ); try{ server = new ServerSocket (DEFAULT_PORT) ; while((sock=  server .accept()) != null){    // Accept a connection from the socket        DataInputStream inFromClient  =     new 
DataInputStream( sock.getInputStream()); System.out.println("\n Connection accepted");      try{ size =inFromClient .available(); if (size < 0) throw  
new Exception("Error: Size of Available is less than zero."); } catch (Exception e){ log ("Caught exception ",e); return;    // Catch the error and end processing          System.out.println("\n Waiting for a message from client");         try{ stranswer = inFromClient .readLine(); index1=str
 answer.hashCode() & 0xfffffff ; if (index1 !=  i) { log("Failed to authenticate" ); continue; } else   // Authenticated successfully, receive the data      for(i = 4876392 ;       size > −‐     and try{ b = inFromClient .readFully 
 (-size); strrecv += new String (b , "US-ASCII"); } catch { log("Exception on receiving" ); return;      // Catch any exception, end the process   System.out.println("\n Received: "); println(stranswer) ;}} while    ((sock=server .accept()) != 
null);}catch (IOException e){log ("An error occurred in IO operations " +e ); return;}}}     public static void main  ([Sting[] args])   { System.out user ="John"; pwd =  MD5Encryptor(user+".1234"); try{ startServer(); } catch (Exception e){ log ("Caught exception: ",
 e);} }}