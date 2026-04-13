import java.io.*;  // Import necessary classes/IOExceptions   
import java.net.*;  
public class java_47259_SocketServer_A03 {    
 public static void main(String[] args) throws IOException{        private ServerSocket server;      try       {         System.out.println("Waiting for client...");         
server = new ServerSocket(6013, 54987 , true );           //listen on port  2xxx     } catch (IOException e){e.printStackTrace();}            Socket socket;      try {              while ((socket= server .accept()) !=  null)      
{                     System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());          //create new thread for each client           Thread t =new EchoThread(  sock );       
t.start(); }                    catch (IOException c){c.printStackTrace();}    }}     class   EchoThread extends Thread {         private Socket s;      try       {            this .s  = socket ;          //get reference to the current client connection           BufferedReader inFromClient= new 
BufferedReader br =new InputStreamReader(socket.getInputStream());        String line, msg =  null   , strLine=  "";              while ( ((line =br.readLine()) !=null))               {             System.out.println("Received: "+line);                //process the message and return to sender           if ("exit".equals(line)){ this .stop(); }
msg += line;            }} catch  (IOException e){e.printStackTrace()}     public void run(){try{for (; ;) { reply(this, s );}}catch    (Exception ex){ex.printStackTrace();   try{}}}}