import java.net.*;
import java.io.*;

public class java_16191_SocketServer_A01 {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(1234);

    System.out.println("Server is listening on port 1234");

    while (true) {
      Socket socket = server.accept();

      // Start a new thread for each client
      new HandleClient(socket).start();
    }
  }
}

class HandleClient extends Thread {
  Socket socket;

  public java_16191_SocketServer_A01(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

      // Read the client's request
      String request = in.readLine();

      // Simulate a security-sensitive operation
      if (request.equals("accessDenied")) {
        System.out.println("Access Denied");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Access Denied");
      } else {
        System.out.println("Access Allowed");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Access Allowed");
      }

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}