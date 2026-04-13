import java.io.*;
import java.net.*;

public class java_36305_SocketServer_A07 {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("Server is listening on port 8080");

    while (true) {
      Socket socket = serverSocket.accept();

      // Handle the request and send the response
      handleRequest(socket);
    }
  }

  private static void handleRequest(Socket socket) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    String request = in.readLine();
    System.out.println("Received: " + request);

    // Send a response
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    out.write("Content-Type: text/html\r\n".getBytes());
    out.write("\r\n".getBytes());
    out.write("Hello, World!".getBytes());
  }
}