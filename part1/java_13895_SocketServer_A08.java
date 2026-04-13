import java.io.*;
import java.net.*;

public class java_13895_SocketServer_A08 {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(8080);
      System.out.println("Server is listening on port 8080");

      while (true) {
        Socket client = server.accept();
        System.out.println("Client connected");

        // Create input and output streams for the client
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        // Read the message from the client
        String message = in.readUTF();
        System.out.println("Received message: " + message);

        // Generate the response
        String response = "Hello, " + message + "!";

        // Send the response back to the client
        out.writeUTF(response);
        out.flush();
        System.out.println("Sent message: " + response);

        // Close the streams and the client connection
        client.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}