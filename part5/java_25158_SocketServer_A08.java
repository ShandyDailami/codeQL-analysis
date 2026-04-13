import java.io.*;
import java.net.*;

public class java_25158_SocketServer_A08 {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8189);
    System.out.println("Waiting for client on port " + 
                        server.getLocalPort() + "...");

    Socket client = server.accept();
    System.out.println("Connected to " + client.getRemoteSocketAddress());

    DataInputStream in = new DataInputStream(client.getInputStream());
    DataOutputStream out = new DataOutputStream(client.getOutputStream());

    String message = in.readUTF();
    System.out.println("Received: " + message);

    String response = "Server received your message: " + message;
    out.writeUTF(response);
    System.out.println("Sent: " + response);

    client.close();
  }
}