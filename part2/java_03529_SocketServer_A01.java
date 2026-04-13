import java.io.*;
import java.net.*;

public class java_03529_SocketServer_A01 {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(12345);
    System.out.println("Waiting for client...");

    Socket socket = server.accept();
    System.out.println("Client connected!");

    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    String clientMessage = in.readUTF();
    System.out.println("Received: " + clientMessage);

    String serverMessage = "Hello, client!";
    out.writeUTF(serverMessage);
    System.out.println("Sent: " + serverMessage);

    socket.close();
  }
}