import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15350_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive and validate input
                String message = in.readUTF();
                if ("bad_input".equals(message)) {
                    out.writeUTF("Error: Invalid input detected for security reasons");
                    out.flush();
                    continue;
                }

                // Process input
                String processedMessage = processInput(message);
                out.writeUTF("Processed message: " + processedMessage);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processInput(String input) {
        // TODO: Implement your own logic for input processing
        // This is just an example and should not be used for real security purposes
        return input + " (processed)";
    }
}