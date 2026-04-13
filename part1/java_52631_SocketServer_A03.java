import java.io.*;
import java.net.*;
public class java_52631_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(80); // listen on port number defined by the argument value of program, ie., 12345 for this example.      
            try {            
                while (true){              
                    Socket sock=server.accept();//waiting till a connection is accepted             
                        new SecureThread(sock).start();     //create and start thread to handle each client requests   
                  }         
           } finally{ server.close();}  //closes the listener upon completion of program execution or when it throws an exception      
      }   public static class SecureThread extends Thread {public java_52631_SocketServer_A03(Socket sock) {super("SecureConnection");        try (InputStream is=sock.getInputStream();          Reader reader =new BufferedReader( new InputStreamReader  (is, "UTF-8"));             OutputStream os  =sock.getOutputStream())        
{ String inStr;     //input string from client           while ((inStr=  reader .readLine())!= null) {               System.out.println("Client says: '" +   inStr+"'");                if(isSecureCommand (inStr))  sendBackAuthorizedUser (os,sock); else throw new IllegalArgumentException();    }
}catch{System.err .printStackTrace()}}     //handling exceptions       private boolean isSecureCommand              (String command){ return                  /*simple check for secure commands - only one of them */   true;  }}             void sendBackAuthorizedUser(OutputStream os,Socket sock)throws Exception {
        String user="secureuser";      if("log in".equalsIgnoreCase((new BufferedReader    ( new InputStreamReader     (sock.getInputStream(), "UTF-8")).readLine())){os .write   ("welcome back ".getBytes()); os 。flush();}}
} }        //example of SQL Injection attack - where a malicious user can overtly input sql commands to the server, leading it into executing them. This is only for testing purposes and not recommended in production due to security risks!     if (command .matches(".*drop table users*.$")) { throw new IllegalArgumentException(); }