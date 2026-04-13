import java.net.*;
import java.io.*;

public class java_22926_SocketServer_A08 {
  public static void main(String[] args) {
    int port = 6000;
    ServerSocket server = null;
    Socket socket = null;
    try {
      // Step 1: Set up the server socket
      server = new ServerSocket(port);
      System.out.println("Server started on port: " + port);

      // Step 2: Wait for a client to connect
      socket = server.accept();
      System.out.println("Client connected");

      // Step 3: Communicate with the client (send and receive)
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      DataInputStream in = new DataInputStream(socket.getInputStream());

      String messageToSend = "Message from server";
      String messageToReceive = in.readUTF();
      System.out.println("Server received: " + messageToReceive);

      out.writeUTF(messageToSend);
      System.out.println("Client says: " + messageToSend);

      // Close resources
      socket.close();
      server.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}