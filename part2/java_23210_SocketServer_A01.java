import java.net.*;
import java.io.*;

public class java_23210_SocketServer_A01 {
  public static void main(String[] args) {
    int port = 6666;
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(port);
      System.out.println("Server is listening on port " + port);
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("New client connected");

        // Create input and output streams
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Receive request
        String request = in.readLine();
        System.out.println("Received request: " + request);

        // Send response
        String response = "HTTP/1.1 200 OK\n\n" + "Hello, client!";
        out.writeBytes(response + "\r\n");

        // Close connection
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (serverSocket != null) serverSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}