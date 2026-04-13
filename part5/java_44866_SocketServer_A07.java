import java.io.*;
import javax.net.ssl.*;
import java.util.*;
  
public class java_44866_SocketServer_A07 {   
       private static int DEFAULT_PORT = 12345; //default port number for server to bind socket connection    
       
      public List<String> users = Collections.synchronizedList(new ArrayList<>()); 
         
         Set<String> authorizedUsers = new HashSet();   
            
       SecureServerSocket ss = null ;  
            BufferedReader reader=null;          
                private SSLServerSocket sslserversocket  = null;     
                      Socket socket    =  null;       
                     PrintWriter out =  null; 
                         InputStream inputstream   = null;   
                            ObjectInputStream in      = null;         
                                boolean connected = false ;        
                                      public static void main(String[] args) {  
                                           SecureSocketServer secureSockServ  = new SecureSocketServer();     //create a socket server instance     
                                                try{       
                             if (args.length != 1){  System.out.println("Usage: java -Djavax.net.ssl.keyStore=<keystore file> \n Example :java -Djavax.net.ssl.keyStore=server-keystore   SecureSocketServer");     
                                                    throw new Exception ("Invalid arguments, must be one argument (port number)") ;        }       try {     secureSockServ . start( Integer.parseInt((args[0]) ) );  } catch (Exception ex){ System.out.println("Failed to Start Server on port " + args [0]  + "\n"+ex);   
                                                       }}      private void start(int port) {     ss = new SecureServerSocket(port,null ,new SSLContextReader());       socket=ss.accept();   connected   = true;        try{ out  = new PrintWriter (socket . getOutputStream(),true );  } catch (Exception ex ) {}   
                                                            while(connected){      if((inputStream = socket.getInputStream()) !=  null) {     reader =  new BufferedReader(new InputStreamReader ((inputStream)) ,8192);        try{       String line=reader . readLine();   }catch (IOException ex ) {}   
                                                                else break;      if((line ==null )){ connected = false ; continue;}         //user entered a message and can be displayed to others.     out.println("Client : "+ line );}        try{       String user= reader . readLine();   }catch (IOException ex ) {}   
                                                                            else break;      if(authorizedUsers.contains((user))){  socket = ss.accept() ; connected  = true;         //new connection accepted, continue loop     out =  new PrintWriter ((socket).getOutputStream(),true);}        try{       String line= reader . readLine();   }catch (IOException ex ) {}   
                                                                            else break;}      if(connected){  socket.close() ; connected = false;}}}}}         ` catch blocks can be further optimized for error handling as per requirement, but I've kept it simple here and commented on the code block where each exception is thrown to indicate its purpose/safety issue