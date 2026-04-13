import java.net.*;
import java.io.*;

public class java_39685_SocketServer_A03 {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8080);
    System.out.println("Server started on port 8080");

    while (true) {
      Socket socket = server.accept();
      System.out.println("Client connected");

      // Create input and output streams
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      // Read and echo back the request
      String request = in.readLine();
      out.writeBytes("HTTP/1.1 200 OK\r\n\r\n" + request + "\r\n");

      // Close the connection
      out.close();
      socket.close();
    }
  }
}