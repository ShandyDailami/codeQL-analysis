import java.io.*;
import java.net.*;

public class java_19012_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final String QUIT = "quit";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals(QUIT)) {
                    out.writeBytes("Connection closed by client\n");
                    socket.close();
                    break;
                } else {
                    handleMessage(message, out);
                }
            }
        }
    }

    private static void handleMessage(String message, DataOutputStream out) throws IOException {
        // Bypass the message and perform some operation (e.g., logging, encryption, etc.)
        // and then send the result back

        // This is a simple demonstration of a secure operation. In a real scenario, the operation
        // would depend on the specific security requirements, and might involve additional
        // steps, such as decryption, checking against a predefined list of known good words,
        // or other security measures.
        out.writeBytes("Received: " + message + "\n");
    }
}