import java.io.*;  // for InputStream, OutputStream classes
import java.net.*;   //for ServerSocket class & socket network programming primitives   
    
public class java_45508_SocketServer_A07 {      
        public static void main(String args[]) throws Exception{     
            int port = 6039;        
             if (args.length > 0){ 
                 try {port = Integer.parseInt(args[0]);} catch (Exception e){ /*can't use this arg*/ }  
               };    //end of argument parsing    
              ServerSocket serverSock= new ServerSocket( port );      
             Socket clntSock;     
           try {  while ((clntSock =serverSock.accept()) !=  null) ;            System.out.println("Got connection from " +   //get client request    
                       (clntSock.getInetAddress().toString()));             BufferedReader in=    new BufferedReader(new InputStreamReader  ( clntSock.getInputStream()) );       String userInput, serverResponse;      while (!((userInput =in .readLine()).equals("Exit")));    
                       //do something with the string from client          PrintWriter out=  new   PrintWriter    (clntSock.getOutputStream(), true) ;           }             catch(IOException i){  System.out.println ("Cowardly refusing " +      ((ServerSocket)serverSock).getInetAddress()+ ", port "+  serverSock .getLocalPort());    
                       $clntsocckt} close the connection   //end of communication with client        }          catch (IOException e){  System.out.println ("I am afraid I can't do that.");      return;}}    finally {serverSock.close();}}}