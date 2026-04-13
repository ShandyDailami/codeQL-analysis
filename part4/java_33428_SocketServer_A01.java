import java.net.*;
import java.io.*;

public class java_33428_SocketServer_A01 {
  public static void main(String[] args) {
    Socket socket;

    try {
      ServerSocket server = new ServerSocket(8080);
      System.out.println("Server started on port 8080");

      while (true) {
        socket = server.accept();
        System.out.println("Client connected from " + socket.getRemoteSocketAddress());

        // Check if the connection should be allowed
        InetAddress remoteAddress = socket.getRemoteSocketAddress();
        if (remoteAddress.isLoopbackAddress()) {
          System.out.println("Connection from loopback address, closing connection");
          socket.close();
        } else {
          // Data stream handling
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());

          String request = in.readUTF();
          System.out.println("Request: " + request);

          out.writeUTF("Server accepts your connection");
          out.flush();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}