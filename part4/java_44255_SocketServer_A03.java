import java.io.*;
import java.net.*;
public class java_44255_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(8956);         //server socket port number is 1234    
                                                                                System.out.println("Waiting for client on Port: " + 8956 );  
    Thread thread=new Thread(){                     @Override                   public void run() {                      try{Socket sock = server.accept();                  //Accept the connection                 if(sock !=  null)                          Connection conn =  new Connections (socket);                System.out .println("Client Connected");  }catch{}}};
        thread.start();   }}    class ServerThread extends Thread{@Override public void run(){try {Socket s=new Socket ("127.0.0.1",8956 ); PrintWriter out = new                     PrintWriter (s . getOutputStream () ,true);  BufferedReader in  =                  new                 BufferedReader(new InputStreamReader