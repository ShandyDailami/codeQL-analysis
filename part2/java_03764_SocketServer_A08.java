import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_03764_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive a message from the client
            String message = in.readLine();

            // Encrypt the message (This is a very simple encryption method and not secure)
            message = encrypt(message);

            // Send the encrypted message back to the client
            out.println(message);
        }
    }

    // Simple encryption method
    private static String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c += 1; // Adds 1 to the ascii value of the character
            encrypted.append(c);
        }

        return encrypted.toString();
    }
}