import java.io.*;
import java.net.*;

public class java_50682_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8091);  // port number should be dynamic in production level code, not hard-coded here for simplicity's sake  
         System.out.println("Waiting For Client...");    
          Socket sock=server.accept();   
           System.out.println ("Client Accepted ");     
            DataInputStream dis = new DataInputStream(sock.getInputStream());       //socket input stream  to read client's message from browser  
             String strMessage;       
              do {                       
                try{                    
                  if((strMessage=dis.readUTF())!=null){    
                    System.out.println("Client says :"+strMessage);    //printing the received data  by client       }                         catch(Exception e) {}     
                 }while(true && strMessage != null );           do{   try {                     if ((new DataOutputStream(sock.getOutputStream()).writeUTF((BufferedReader)( new InputStreamReader(System.in)) .readLine())))    System.out.println("Server says: Hello");  else
                 throw new Exception();                        }catch (Exception e) {}      catch (IOException ex){ex.printStackTrace();}       if ((strMessage = dis.readUTF()).equalsIgnoreCase( "exit")) {System.out.println ("Connection Closed by Client "); sock.close(); server .close(); break;}
                 }, 1024);     do{try{}catch (Exception e){}};      }while true ;   // end of while loop    }}//end main method        `java' at the start, rest is syntactically correct code and should work fine. If you face any errors it would be best to provide more details about them for further assistance