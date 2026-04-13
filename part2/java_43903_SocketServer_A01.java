import java.io.*;
import java.net.*;
import javax.security.auth.Subject;   // For BasicAuthentication & PrincipalCollection interface only available from Java EE platform (not standard library)
public class java_43903_SocketServer_A01 {   
     public static void main(String[] args){     
         String username = "user"; 
          final int port = 8090 ;      
           try{   //Set up server socket.              
                  ServerSocket s=new ServerSocket();//socket for connection to client           
                 Socket incoming;    DataOutputStream outgoing;     byte[] bytes=new byte[12]; 
                   while(true){         System.out.println("Waiting on port "+port);     
                     //accept a new socket into s         
                       incoming =s.accept();   PrintWriter pw= 
                      new PrintWriter (incoming.getOutputStream(), true) ;        for (;;) {    try{  bytecount=read( incomig,bytes,,4 )}catch(){ }     if (!authenticateUserFromClient()) throw cancept;      //send a welcome message to the client         
                     outgoing .println("Hello Client you are connected");   }} catch (IOException ex){ System.out.println ("Error " +ex );}}  try{ s.close();}catch(Exception ex) {}           }        finally {         for (;;);}}}     private static boolean authenticateUserFromClient() throws RemoteException   
             {"Subject subject=new Subject(){};   PrincipalCollection pc=  new   //only available from Java EE platform (not standard library)", UserPrincipal("user"), null));  return((subject.runAsLdap(pc)== AccessControlContext.SUCCESSFULL_ALLOWED ||   
             subject.doAs(new PrivilegedAction<AccessControlContext   //only available from Java EE platform (not standard library)"{return new    
              AccessControlContext(subject, UserPrincipal("user"), null);}})};catch  {System . out .println (" Authentication failed"); return false;}    } catch {} throw ex ; }}      public static int read (Socket sock , byte [] b , int offset ,int length) throws IOException{
            InputStream is=sock.getInputStream();     DataInputStream dis =new   //only available from Java EE platform(not standard library)"DataInputStream  disc =  new DisconnectedInputStream((is)); return    dis .read (b,offset,,length); }}`; Please replace `//replace with your code