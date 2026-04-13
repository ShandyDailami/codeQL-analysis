import java.net.*;
import java.io.*;

public class java_21157_SocketServer_A07 {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(8080);
    System.out.println("Server started");

    while (true) {
      Socket socket = server.accept();
      System.out.println("Client connected");

      // Create new thread for this connection
      Thread thread = new Thread(new SocketHandler(socket));
      thread.start();
    }
  }
}

class SocketHandler implements Runnable {
  private Socket socket;

  public java_21157_SocketServer_A07(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      // Create input and output streams
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // Handle each message received
      String message;
      while ((message = in.readLine()) != null) {
        System.out.println("Received: " + message);

        // Send a response back
        out.println("Server says: " + message);
      }

      // Close the socket
      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}