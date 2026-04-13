import java.io.*;
import java.net.*;

public class java_38738_SocketServer_A08 {
  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8080);

    while (true) {
      System.out.println("Waiting for connection...");
      Socket clientSocket = serverSocket.accept();
      System.out.println("Connected to client!");

      // Handle the connection in a new thread
      Thread t = new Thread(new ClientHandler(clientSocket));
      t.start();
    }
  }
}

class ClientHandler implements Runnable {
  private Socket socket;

  public java_38738_SocketServer_A08(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        System.out.println("Received: " + inputLine);
        out.writeUTF("Server received your message: " + inputLine);
      }

      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}