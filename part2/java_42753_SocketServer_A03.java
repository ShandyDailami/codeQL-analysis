import java.io.*;
import java.net.*;

public class java_42753_SocketServer_A03 {
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(6001); //server port number, change if needed        
       System.out.println("Waiting for client on Port : "+ server.getLocalPort() +"...");          
          while (true){              
              Socket sock=server.accept();                
                OutputStream outToClient =sock.getOutputStream();   // get an output stream connected to this socket                          
                  DataOutputStream out = new DataOutputStream(outToClient);            
                   System.out.println("Connected!"); 
                      while (true){                      
                          InputStream inFromClient= sock.getInputStream();    # inputstream from the client  
                            BufferedReader inBuff =new BufferedReader(               new InputStreamReader(inFromClient));     
                              String line=null;                         //declare string variable for reading data 
                               try{                
                                   while ((line = inBuff.readLine()) != null){    # loop to read each client message               
                                       System.out.println("Message Received : "+         line);                       if(line=="exit") break;                  }                          } catch (IOException e) {e.printStackTrace();}  //close the connection and end this thread when an exception is thrown                     try{                   out.writeUTF ("Server Echo: Hello Client!!" );            
                           }}catch (Exception ex){ex.printStackTrace()};      # send a message back to client, if any                      }                          sock.close();                  System.out.println("Connection closed by : " +sock.getRemoteSocketAddress());}}                 catch(IOException e) {e.printStackTrace();}
                                         }}  // main method ends here!          This program is a server to client and echo messages from the clients, until it receives an 'exit' message or socket connection failure occurs                   })};