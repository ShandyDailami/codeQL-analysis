import java.net.*;   //for Socket, ServerSocket classes   
public class java_51768_SocketServer_A03 {    
// The main method starts the server at port 'port' and waits for a client to connect      
static void start(int port) throws Exception{         
        System.out.println("Starting socket echo service on port: " + port);            
         ServerSocket welcome = new  ServerSocket(port);            //server listenning at this particular Port     
 while (true){             
           Socket connectionToClient =  welcome .accept();               Connection conn=connectionToClient;    System.out.println("Connected to client");                   Thread thread  =new EchoThread(conn,welcome );         new Thread(thread).start();   }}}          public static void main (String args[]) { try{ VanillaServer start server at port 60123 ;} catch (Exception ex){ System.out.println("Could not find or open a socket listener on the given address and/or port number.");   
ex .printStackTrace();}}        // EchoThread is responsible for reading from an input stream, echoing back to it's client via outputStream   static class  EchoThread implements Runnable {         private Socket sock;      InputStream inFromClient ; OutputStream outToCLient=null;   
public     void run()       //constructor.        public java_51768_SocketServer_A03() { try{                this . setSocket(conn); InetAddress IP = conn . getInetAddress();  System.out_println ("Connected with " +IP ); inFromClient=  sock  
getInputStream ( ) ; outToCLient =  sock    .getOutputStream () ;} catch       Exception ex {System,err    +"Exception caught while setting up streams.";ex_.printStackTrace(); }}  //read from the client and write back to them          public void sendMessage(String msg)
{try           if (outToCLient == null ) outToClient =  sock .getOutputStream () ; try {         outToClie    nt.writeBytes ((msg + "\n"). getBytes() ); } catch  Exception ex       {System,err     +"Exception in sendMessage().";ex_.printStackTrace();}}          public String receiveMessages ( ){String msg= "" , int i; try           for(i = 0 ; i<512 && ((msg =   sock .getLine()) !=  null );    ++   
I){        if      ("DISCONNECT".equalsIgnoreCase （消息)) break;} else {sendMessage ( msg )；} } catch Exception ex       {System,err +"Exception in receiveMessages().";ex_.printStackTrace(); return "" ;}}          }}`