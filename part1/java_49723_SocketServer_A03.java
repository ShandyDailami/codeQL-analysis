import java.io.*;
import java.net.*;
public class java_49723_SocketServer_A03 { 
    public static void main(String[] args) throws IOException{       
         ServerSocket server = new ServerSocket(1234);          // create a socket to listen on port  1234           
       System.out.println("Waiting for client connection..." );          
               while (true){            
                Socket sock=server.accept();                    
                 System.out.println ("Connected");                   
                  Thread t = new Thread(new ClientHandler(sock));  // start a thread to handle the newly accepted socket           
                   t.start();                                                       }}}     class Handler implements Runnable{       private Socket sock;      public java_49723_SocketServer_A03(Socket s) {   super(); this .socket=s;} @Override    public void run()             { try  {" + "InputStream in = sock.getInputStream(); BufferedReader br =  new BufferedReader(new InputStreamReader(in));" + 
                  " String clientMessage; while ((clientMessage  =br.readLine()) !=  null){ System . out .println(\"server: \"+   (Object )  clientMessage); } sock.close();} catch (IOException e) {e.printStackTrace();}}}}}    class ClientHandler implements Runnable{       private Socket socket;      public java_49723_SocketServer_A03(Socket s) { super() ; this .socket =s;} @Override    
                  " +   public void run(){ try {" + 
                  +"OutputStream out=this.socket.getOutputStream(); PrintWriter pw =  new  PrintWriter (out,true);pw.println(\"Hello from server!\"); Thread.sleep(5000) ;    pw .println (\"Goodbye\") " +   } catch (IOException e){e.printStackTrace()}catch
                  [Tab]+{}`  // end of code block}}, {}}); this will only run if there is an exception at the try blocks, and print out a stack trace for debugging purposes}}}"}); `})};