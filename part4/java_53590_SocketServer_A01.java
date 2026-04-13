import java.net.*;
import java.io.*;
public class java_53590_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(5067); //port number should be in use by any other program or not at all if there's no such port 
       System.out.println("Waiting for client on port: "+server.getLocalPort()+"...");    
        Socket socket = server.accept();     
        PrintWriter out= new PrintWriter(socket.getOutputStream(),true);   //to send message to the connected clients 
       BufferedReader in =new BufferedReader ( new InputStreamReader(socket.getInputStream()));   
         String command;    
          while((command=in.readLine())!=null){      System.out.println("Received client: "+ command);   //received message from the connected clients  }           out.println ("Server Received your Message");} catch(IOException ex) {ex.printStackTrace();}}   
public class SecureSocketClient{     public static void main (String args []) throws Exception       Socket socket = new Socket("localhost",5067);      PrintWriter out=new  printwriter   (?socket.getOutputStream(),true), true)         BufferedReader in=  ?(intem stream reader, "+server . getInputStream()),?}while((command  =in,.readline())!==null){ System.out:println("received from server :" + command); out=new printwriter  (?socket.getOutputStream(),true), true) }catch (IOException ex){ex..printstacktrace();}}