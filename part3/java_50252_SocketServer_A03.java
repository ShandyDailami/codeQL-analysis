import java.io.*;  // Importing necessary classes  
import java.lang.*;   
import javax.crypto.*;    
import sun.security.md.*;     

public class java_50252_SocketServer_A03 {      
//The Server Side of socket Program       
private static final String MD5 = "MD5";        
 private ServerSocket server;          //Define a variable to hold the created socketserver   
 public void start(int port) throws IOException{           
     System.out.println("Starting SocketServer...");            
      this.server= new ServerSocket(port);        if (this.server == null){           throw newIOException();       }              while((socket = server .accept()) !=  null ) {          ProcessRequestsForClient socketclient  =new  processrequestforclientsimpleimpl class() ;     //Creating a thread for each client     
            Thread t=   new Threat(Sockett, SocketMessage);       runnable r;           try{               BufferedReader in =new buffreader (socket.getInputStream());          String decodedString , userpasswortempstring  =in .readline();              MessageDigest md ;       
                byte[] buffer=decodetext(userpasswordtempsting). getbytes()  rc4-keys;            RSAKey key = newRSAPrivateCipher (privatekey);           mD5key  =  KeyFactory.getInstance("MD5").    generateSecret((SecureRandom)null ).getBytes());              
                  if (!Arrays .equals(mD5, md )) { throw nioex..newauthenticaticaionexception();      }                   rc4-Cipher c = newRC4Cipher (key);           String decodedstring2  = in.readline;         byte[] buffer2  = 
                 readfrostring(decodestrinfg).getbytes()          RSAKey key=newRsaPrivate Cipherenoticecaiableexception();                rsacipher c = new RSACipher (key);               String decodedstring3  = in.readline;              byte[] buffer  = 
                 readfrostring(decodestrinfg).getbytes()          throw nioex..newauthenticationserviceexceptions());                   }catchall{throw e;}       }}                catch (IOException io){         System .outprintln("Error: " +e.getMessage);        server_.close();}
 //The Client side of socket Program    private Socket socket;      public void start(String IpAddress,int port) throws IOException {           this  socker = newSocket(ipaddress ,port ) ;         BufferedReader in=newbuffreader (socket.getInputStream());          PrintWriter out= 
                 newprintwriter  ​                      ("Server: " + socket . getLocalSoketAdress()+":"+  String port)    }catchall{ throw e;}        finally {  if(this_Socket! = null ) this._sockethook.disconnect();}}       });                  SocketClient _socketclient  =new socketsimpleimpl ();    
            start("127 .0.0 .net",4356)          }              e.printstacktrace()                System..exit(EXIT_FAILURE ); }}        //Main Class  public static void main...         { try{ SocketServer server = newSocket Server();     
            server_.start (8971);           while true {}       catchall}{                   }}}}                     EOF   };