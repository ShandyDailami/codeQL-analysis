import java.io.*;
import java.net.*;
  
public class java_47552_SocketServer_A08 {    
    public static void main(String args[]) throws Exception{        
        int port = 1234;          // local port to listen on     
          
       try (ServerSocket server = new ServerSocket(port))  {               
            while (!server.isClosed())   {              
                    Socket clientSock = server.accept();                
                   DataInputStream dis=new DataInputStream(clientSock.getInputStream());                         // receive from socket   
                      String msg;                    
                       do{                       
                            try  {                         
                                                  if ((msg = (String)dis.readObject()) != null){  
                                          System.out.println("Client says: "+msg);                           }                                 
                                      else break;}                   except(Exception e )           {}    //end loop                 catch          end of file        ctrl-c to shut down server       try{ ServerSocket sock = new Socket ("127.0.0.1", port ); System.out .println("Connected"); }catch (IOException e) {System.err.println(e.getMessage());}    
                            //end loop  end of program         catch    Exception   in java        printStackTrace      do-while       finally          try{ socket = new Socket ("127.0.0.1", port); System . out .print ( "Connected" ); }catch( IOException e){System err,println("e: %s\n","ioexception");}