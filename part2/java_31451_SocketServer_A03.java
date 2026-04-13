import java.net.*;
import java.io.*;

public class java_31451_SocketServer_A03 {
  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(6000); // open a port
    System.out.println("Waiting for client...");

    Socket socket = server.accept(); // accept a client connection
    System.out.println("Client connected");

    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    // read the message from the client
    String message = in.readUTF();
    System.out.println("Received: " + message);

    // prepare a response
    String response = "Hello, client, your message was: " + message;

    // send the response to the client
    out.writeUTF(response);
    out.close();
    in.close();
    socket.close();
    server.close();
  }
}