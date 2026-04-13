import java.io.*;
import java.net.*;

public class java_33419_SocketServer_A08 {
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static int failedAttempts = 0;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams for communication
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Echo client messages
            while (true) {
                String message = input.readUTF();
                if ("exit".equals(message)) {
                    break;
                }
                output.writeUTF("Echo: " + message);
                output.flush();
           
                // Check integrity failure
                if (++failedAttempts >= MAX_FAILED_ATTEMPTS) {
                    System.out.println("Integrity failure detected. Closing connection.");
                    socket.close();
                    break;
                }
            }

            // Close connection
            socket.close();
        }
    }
}