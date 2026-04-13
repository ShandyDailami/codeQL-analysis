import java.net.*;
import java.io.*;

public class java_36242_SocketServer_A03 {
  public static void main(String args[]) {
    ServerSocket serverSocket = null;
    Socket socket = null;

    try {
      // Create server socket
      serverSocket = new ServerSocket(5000);
      System.out.println("Waiting for client on port: " +
        serverSocket.getLocalPort() + "...");

      // Accept a client socket
      socket = serverSocket.accept();
      System.out.println("Client connected!");

      // Create input and output streams
      OutputStream outToClient = socket.getOutputStream();
      InputStream inFromClient = socket.getInputStream();

      // Create buffered reader and writer
      BufferedReader in = new BufferedReader(
        new InputStreamReader(inFromClient));
      DataOutputStream out = new DataOutputStream(outToClient);

      // Send a greeting message to the client
      out.writeUTF("Connection established!");

      // Create a new thread to handle the client's request
      Thread thread = new Thread(new ClientHandler(in, out));
      thread.start();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class ClientHandler implements Runnable {
  private BufferedReader in;
  private DataOutputStream out;

  public java_36242_SocketServer_A03(BufferedReader in, DataOutputStream out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public void run() {
    try {
      // Read a message from the client
      String message = in.readLine();
      System.out.println("Received: " + message);

      // Send a response back to the client
      out.writeUTF("Server says: " + message);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}