import java.io.*;
import java.net.*;

public class java_40727_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 5000; // chosen port

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("A client has connected");

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String message = in.readUTF();
                    System.out.println("Client says: " + message);

                    out.writeUTF("Server says: Hello, client!");
                    System.out.println("Server says: Hello, client!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}