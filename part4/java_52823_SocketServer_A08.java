import java.io.*;
import java.net.*;
  
public class java_52823_SocketServer_A08 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(2401); // listening on port number 2401         
       System.out.println("Waiting for client..." );     
          
               while (true){             
                 Socket sock=server.accept();           
                  DataInputStream dis= 
                    new DataInputStream(sock.getInputStream());            
                   PrintWriter out =new PrintWriter 
                      (sock.getOutputStream(), true);                    
                       String msg;                        
                        do{              
                           try {   // read from socket input stream into message       
                              if((msg=dis.readUTF())==null) return ;           
                          }catch(SocketTimeoutException s){             System.out.println("No Data "); continue;}           catch (IOException e )  {System.out.println ("Server Error");return;}"   //if I/O fails, it's a server error and we exit          },                   });                      }}