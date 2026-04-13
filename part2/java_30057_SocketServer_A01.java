import java.net.*;
import java.io.*;

public class java_30057_SocketServer_A01 {

  public static void main(String[] args) throws Exception {

    // Create a socket for the server
    ServerSocket serverSocket = new ServerSocket(4242);

    // Listen for client connections
    while (true) {
      Socket clientSocket = serverSocket.accept();

      // Create streams for communication
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      // Read a message from the client
      String message = in.readLine();
      System.out.println("Received: " + message);

      // Send a response back to the client
      out.println("Hello, client, thank you for connecting!");
   
      // Close the streams
      in.close();
      out.close();
      clientSocket.close();
    }
  }
}