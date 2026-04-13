import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32581_SocketServer_A08 {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                         DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                        // Perform security-sensitive operations
                        performIntegrityFailure(in, out);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + port + ". Reason: " + e.getMessage());
        }
    }

    private static void performIntegrityFailure(DataInputStream in, DataOutputStream out) throws IOException {
        // Read and echo back the client's message
        String message = in.readUTF();
        System.out.println("Received: " + message);
        out.writeUTF(message);
        out.flush();

        // Perform some integrity-related operation
        // This is a simple example, in a real-world application you might want to implement a more complex operation
        byte[] buffer = new byte[1024];
        in.read(buffer, 0, buffer.length);

        // Here you can add your own security-sensitive operations

        // Send acknowledgment back to the client
        out.writeUTF("Message received successfully");
    }
}