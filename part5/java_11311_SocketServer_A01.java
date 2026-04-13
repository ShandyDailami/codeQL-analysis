import java.net.*;
import java.io.*;
import java.util.*;

public class java_11311_SocketServer_A01 {

  private static final String SERVER_SOCKET_ADDRESS = "localhost";
  private static final int SERVER_PORT = 4445;

  private static void startServer() {
    try {
      // Create a server socket and set up the accept loop
      ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
      while (true) {
        // Accept a client connection
        Socket clientSocket = serverSocket.accept();
        // Start a new thread to handle communication with the client
        new ClientHandler(clientSocket).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("Starting server...");
    startServer();
  }

  private static class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_11311_SocketServer_A01(Socket socket) {
      this.clientSocket = socket;
    }

    @Override
    public void run() {
      try {
        // Get the input and output streams from the client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
          System.out.println("Received: " + inputLine);
          out.println("Echo: " + inputLine);
        }

        // Close the connection
        clientSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}