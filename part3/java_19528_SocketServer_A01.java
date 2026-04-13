import java.io.*;
import java.net.*;

public class java_19528_SocketServer_A01 {

  public static void main(String[] args) {
    try {
      // Create a socket and bind it to port 12345
      ServerSocket server = new ServerSocket(12345);
      System.out.println("Server is running...");

      while (true) {
        // Wait for a client to connect
        Socket socket = server.accept();
        System.out.println("Client connected...");

        // Create a writer to send data to the client
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Send a message to the client
        out.println("Hello Client, How are you today?");

        // Close the connection
        socket.close();
      }

    } catch (IOException e) {
      // Handle exceptions here
      e.printStackTrace();
    }
  }
}