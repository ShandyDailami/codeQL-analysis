import java.io.*;
import java.net.*;
  
public class java_46705_SocketServer_A03 {    
    public static void main(String args[]) throws Exception{        
            ServerSocket server = new ServerSocket(6013);         
             while (true){              
              Socket s=server.accept();               
                     Thread t  =new Thread(new ClientThread(s));                
                      t .start();                  }   }  // Main thread ends here     public class    ClientThread implements Runnable {        private      Socket socket;         public java_46705_SocketServer_A03(Socket connection) {          this.socket=connection;}           @Override            public void run(){                try{               BufferedReader in = new BufferedReader(new InputStreamReader  
  (s.getInputStream())); PrintWriter out   =     new    PrintWriter( s . getOutputStream(),true); String line; char[]      ch  ={'a','d'};       while ((line=in.readLine())!=  null){             for(int i = 0 ;i<ch.length && 
   !Thread.currentThread().isInterrupted();++i) {              Thread.sleep(10); out .println("Server:Message From Client : "+ line +" Characters read:"+  ch[i]); }     if (socket==null){socket=connection;}             socket.close();}} catch   
   (IOException e ){e . printStackTrace() ;}          }}  // Server thread ends here      class SenderThread implements Runnable {           @Override public void run(){ try         {BufferedReader reader = new BufferedRead...`(System.in); PrintWriter writer =  ... }     catch (IOException e)  
    {}//end of function}};                   sender .start();                 receiver . start()  }; //Main thread ends here }}           ReceiverThread implements Runnable {         @Override public void run(){ try{ BufferedReader reader = new...`(s.getInputStream())); PrintWriter writer =  ... } catch (IOException e) {}//end of function}};
            sender   .start();                  receiver  . start() ;}          }} //Main thread ends here