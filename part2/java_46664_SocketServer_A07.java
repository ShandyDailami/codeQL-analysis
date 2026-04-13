import java.io.*;
import java.net.*;
  
public class java_46664_SocketServer_A07 { 
    public static void main(String[] args) throws IOException{       
           //create a socket object,get the local machine name and port number        
            ServerSocket server = new ServerSocket(5048);      
               System.out.println("Waiting for client on Port : "+server.getLocalPort() );    
              Socket sock=null;           //socket connection to receive incoming messages 
          while(true){        
             try{  
                //step2: Listen here until an activeconnection is made with the Client      
                 sock = server.accept();     
                  System.out.println("Connection Accepted from " +sock.getRemoteSocketAddress());    
              }catch (IOException e){        
                   consoleMessage(e);        //if exception raised then print message  on screen and continue          
                    return;       break;}   try{   
                       InputStream input = sock.getInputStream();      BufferedReader reader =  new BufferedReader((new InputStreamReader(input)));     String clientInput, serverOutput="";          //read in the string from Client  while looping through them          
                  do {           
                    try{       
                      /* Read data received at socket */            
                        if ((clientInput = reader.readLine()) !=  null){                System.out.println("Client : " + clientInput);     //Print for checking}          else  return;       break;}           catch (IOException e) {consoleMessage(e)} ;                  } while (true );   try{
                           OutputStream output = sock.getOutputStream();      DataOutputStream writer =  new DataOutputStream((output));    serverOutput="Authentication Failed";     //Send the message to client        write out data and close connection      
                        if ((writer).equals(serverOutput)){            System.out.println("Server : " + (clientInput) );   return;}}else{catchException e){consoleMessage(e)};}  } catch {sock=null}}}      finally{}                     //close socket connections     sock = null: