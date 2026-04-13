import java.io.*;
import java.net.*;

public class java_10134_SocketServer_A01 {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(5000)) {

            System.out.println("Server is listening on port 5000");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected");

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String request = in.readUTF();
                    System.out.println("Received request: " + request);

                    String response = "Hello, client!";
                    out.writeUTF(response);
                    System.out.println("Sent response: " + response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}