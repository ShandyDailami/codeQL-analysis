import java.io.*;
import java.net.*;
import java.util.*;

public class java_40256_SocketServer_A08 {
    private static int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            String data = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + data);

            // Check if data is corrupted (replace this with your own logic)
            if (isDataCorrupted(data)) {
                System.out.println("Data is corrupted, sending response...");
                output.writeBytes("Corrupted Data Response\n");
            } else {
                System.out.println("Data is valid, sending response...");
                output.writeBytes("Valid Data Response\n");
            }

            output.flush();
            socket.close();
        }
    }

    // A simple check for integrity failure. You should replace this with your own logic.
    private static boolean isDataCorrupted(String data) {
        // This is a simple check for corrupted data. In real use cases,
        // you should use a stronger algorithm or a checksum to verify the integrity.
        return data.contains("corrupted") || data.contains("malformed") || data.contains("error");
    }
}