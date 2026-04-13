import java.io.*;
import java.net.*;

public class java_05737_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Simulate integrity failure by sending back the same request in uppercase
            out.writeUTF(request.toUpperCase());

            socket.close();
        }
    }
}