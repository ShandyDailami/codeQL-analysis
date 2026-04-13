import java.net.*;
import java.io.*;
public class java_46753_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        int port = 6013; // Port number to listen on  (can be changed).     
         ServerSocket server_socket = new ServerSocket();      
           String client_message="";           
          try {               
               System.out.println("Waiting for connection...");            
              Socket socket =server_socket .accept();     // Accept a client request  
                 System.out.println("Connection accepted from: " +    socket.getRemoteSocketAddress()); 
                   DataInputStream inputStream= new DataInputStream(socket.getInputStream());     
                     BufferedReader reader =  new BufferedReader (new InputStreamReader (socket.getInputStream()));     // Reading the message sent by client  
                      String ch =reader.readLine();        
                       System.out.println("Message from Client: " +ch);          if(port != Integer.parseInt((String)ch)){    throw new Exception ("Port number is incorrect");}                  try{             // Sending a response back to client          
                           PrintWriter writer =new  PrintWriter (socket .getOutputStream(),true );  
                             String messageToSend="Thank you for connecting";      System.out.println("Sending the Message: "+messageToSend);       
                            ch +=(String)ch;     // Writig in OutputStream            writer.writeBytes((byte )i +'\n');          }catch (Exception e){       Logger log=LoggerFactory .getlogger   FATAL,"Error occurred while sending a message to the client ");  E.printStackTrace();}} catch(IOException ex) {
                 System.out.println("I/O Exception Occurred: "+ex);    }               finally{      socket.close();     // Close connection        server_socket .close ()}   }}catch (Exception e){            Logger log =LoggerFactory  .getlogger(FATAL,"Port number is not correct");
              System.out.println("Error occurred: "+e);    }}}`               catch exception here if any occurs during the execution of main method then it will be caught and handled in corresponding block, i.e., `catch (Exception e){...} ... finally{....}}}  to handle exceptions properly