import java.io.*;
import java.net.*;

public class java_37445_SocketServer_A01 {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(12345);
    System.out.println("Server is listening on port 12345...");

    while (true) {
      Socket socket = server.accept();
      System.out.println("Client connected");

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      String message = in.readUTF();
      System.out.println("Received message: " + message);

      out.writeUTF("Hello, Client!");
      out.flush();

      socket.close();
    }
  }
}