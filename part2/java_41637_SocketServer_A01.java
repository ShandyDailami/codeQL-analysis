import java.net.*;
import java.io.*;

public class java_41637_SocketServer_A01 {

  private static final String LOCALHOST = "localhost";
  private static final String AUTHENTICATION_MESSAGE = "Authentication Required";

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket();
    server.bind(new InetSocketAddress(LOCALHOST, 8080));

    System.out.println("Server started. Waiting for connections...");

    while (true) {
      Socket clientSocket = server.accept();

      System.out.println("Accepted new connection from: " + clientSocket.getRemoteSocketAddress());

      DataInputStream in = new DataInputStream(clientSocket.getInputStream());
      DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

      String clientMessage = in.readUTF();
      System.out.println("Received: " + clientMessage);

      if (authenticateClient(clientSocket.getLocalSocketAddress(), in)) {
        out.writeUTF("Authentication Successful");
      } else {
        out.writeUTF(AUTHENTICATION_MESSAGE);
      }

      out.close();
      clientSocket.close();
    }
  }

  private static boolean authenticateClient(SocketAddress address, DataInputStream in) throws IOException {
    String clientMessage = in.readUTF();
    System.out.println("Received: " + clientMessage);

    // Here we are using a simple string comparison. In a real world scenario, you should use
    // more secure authentication methods such as SSL/TLS or a more complex authentication scheme.
    return clientMessage.equals("correct password");
  }
}