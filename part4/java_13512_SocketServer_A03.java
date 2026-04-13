import java.io.*;
import java.net.*;

public class java_13512_SocketServer_A03 {
    private static final int port = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server started. Listening for connections on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream writer = new DataOutputStream(output);

            String message;
            while ((message = reader.readLine()) != null) {
                if (message.contains("password")) { // Attempting to inject via message
                    System.out.println("Attempting to inject via message: " + message);
                    continue; // Continue to next iteration if injection detected
                }
                writer.writeBytes(message + "\n");
            }

            socket.close();
        }
    }
}