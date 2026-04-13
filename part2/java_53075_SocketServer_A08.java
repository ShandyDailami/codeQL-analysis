import java.io.*;  // Import Input/Output Streams, Socket Classes and Buffered Reader & Writer classes  
import java.net.*;  // For ServerSocket Class   
      
public class java_53075_SocketServer_A08 {    
// Create a new socket for listening incoming connection requests to the port provided by server     
static int PORT = 6012;        
static Socket s = null;         
private static ServerSocket ss=null ;       
  public void start() throws IOException{            
    try              {                     //Server Starts here                 
       System.out.println("The Vanilla Java server is started");                     
      if(ss==null)              
         ss = new ServerSocket(PORT);               
   s= ss.accept();     }catch (IOException e){  printWriter((PrintWriter)e)); return;}}          //Server Accepts client here              catch block of the try            public void run()                 {try{startup();}//Catch and handle any exception in a way that makes sense to your program.  
public static BufferedReader getRd(Socket s){             if (rd==null) rd= newBuffered Reader ((InputStream)(s).getInputStream(),4096);  return this;           }              public InputStream GetIn(){return iS;}            //Get In and out methods for use in the main function  
public static BufferedReader getRD() { if (rd==null) rd= newBuffere Reader(s.getInputStream(),4096); return this;  }           public void printWriter(PrintWriter pw){try{pW =new Print Writer((S OCKET)( S . GETINPUT STREAM()),false );                    
              if (PRINT WRITER IS NOT NULL)                  //Send back to the client whatever was sent. If there is an exception, just print out what happened         pw= newprint writer(socket,(OutputStream ) s  socket getoutputstream()) ;                      }catch...}}      catch block of a try