import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31453_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Here, we're using a very basic implementation of the BubbleSort algorithm.
            // This is a security-sensitive operation and should not be done in a real-world scenario.
            byte[] bytes = new byte[1];
            socket.getInputStream().read(bytes);
            bubbleSort(bytes, bytes.length);

            socket.getOutputStream().write(bytes);
            socket.getOutputStream().flush();
            System.out.println("Server sent back sorted bytes");
        }
    }

    private static void bubbleSort(byte[] bytes, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bytes[j] > bytes[j + 1]) {
                    // Swap bytes[j] and bytes[j+1]
                    byte temp = bytes[j];
                    bytes[j] = bytes[j + 1];
                    bytes[j + 1] = temp;
                }
            }
        }
    }
}