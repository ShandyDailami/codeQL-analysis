import java.io.*;
import java.net.*;

public class java_00206_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive data from client
            byte[] bytes = new byte[1024];
            int length = in.read(bytes);

            // Check if the received data is integrity-sensitive
            if (isIntegritySensitive(bytes, length)) {
                System.out.println("Data is integrity-sensitive, aborting...");
                socket.close();
                return;
            }

            // Process the received data...
            // ...

            System.out.println("Data processed successfully!");
            out.writeUTF("Data processed successfully!");

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isIntegritySensitive(byte[] bytes, int length) {
        // Implement your own integrity check logic here...
        // ...

        // This example just checks if the length is less than 100, which is a typical example of integrity failure
        return length < 100;
    }
}