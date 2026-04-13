import java.net.*;
import java.io.*;

public class java_22903_SocketServer_A08 {
  public static void main(String[] args) throws Exception {
    ServerSocket server = new ServerSocket(6666);
    while(true) {
      Socket socket = server.accept();
      System.out.println("Client connected");
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      String message = dis.readUTF();
      System.out.println("Received: " + message);
      dos.writeUTF("Message received");
      dos.flush();
      socket.close();
    }
  }
}