import java.net.*;
import java.io.*;

public class java_12495_SocketServer_A08 {

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8000);
    while (true) {
      Socket socket = server.accept();

      // create input and output streams
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      // read from the socket
      String received = in.readLine();
      System.out.println("Received: " + received);

      // send back to the client
      out.writeBytes("Echo: " + received + "\n");
      socket.close();
    }
  }
}