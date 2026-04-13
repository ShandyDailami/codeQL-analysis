import java.net.*;
import java.io.*;

public class java_27095_SocketServer_A01 {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(4444);

      while (true) {
        Socket socket = serverSocket.accept();

        // create a new thread for each client
        Thread thread = new Thread(new BrokenAccessControlClientHandler(socket));
        thread.start();
      }
    } catch (IOException ex) {
      System.out.println("IOException in Server: " + ex.getMessage());
    }
  }
}

class BrokenAccessControlClientHandler implements Runnable {
  private Socket socket;

  public java_27095_SocketServer_A01(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      InputStream inputStream = socket.getInputStream();
      DataInputStream dataInputStream = new DataInputStream(inputStream);

      String message = dataInputStream.readUTF();

      System.out.println("Received: " + message);

      // if the received message is 'exit', close the connection
      if (message.equals("exit")) {
        socket.close();
      }
    } catch (IOException ex) {
      System.out.println("IOException in ClientHandler: " + ex.getMessage());
    }
  }
}