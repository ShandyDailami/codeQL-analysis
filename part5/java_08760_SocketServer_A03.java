import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08760_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                // NoSQL injection is not allowed here, this is for the sake of simplicity.
                // In a real-world application, you would always want to validate and sanitize user input.
                String response = process(message);
                output.writeUTF(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String process(String input) {
        // Simplified example of a noSQL injection attack.
        // In a real-world application, you would always want to validate and sanitize user input.
        return input + " (processed)";
    }
}