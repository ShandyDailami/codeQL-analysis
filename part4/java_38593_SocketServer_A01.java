import java.net.*;
import java.io.*;

public class java_38593_SocketServer_A01 {

  public static void main(String[] args) throws Exception {

    ServerSocket server = new ServerSocket(6000);
    System.out.println("Server started.");

    while (true) {
      Socket socket = server.accept();
      System.out.println("New client connected.");

      //Create a new thread for this client
      Thread thread = new Thread(new SocketHandler(socket));
      thread.start();
   
    }
  }
}

class SocketHandler implements Runnable {
  private Socket socket;
  public java_38593_SocketServer_A01(Socket socket) {
    this.socket = socket;
  }
  
  public void run() {
    try {
      //Create input and output streams
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      //Handle incoming request
      String request;
      while ((request = in.readLine()) != null) {
        out.println("Echo: " + request);
      }

      socket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}