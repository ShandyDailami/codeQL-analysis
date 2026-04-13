import java.io.*;
import java.net.*;
import java.util.*;

public class java_07020_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected...");

            // Step 1: Read client's handshake
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clientHandshake = in.readUTF();
            System.out.println("Client's handshake: " + clientHandshake);

            // Step 2: Check if the handshake is valid (e.g., A07_AuthFailure)
            if (isHandshakeValid(clientHandshake)) {
                System.out.println("Valid handshake, starting communication...");

                // Step 3: Communication starts here.
                // Send a simple response to the client.
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello client, I'm a server!");
                out.flush();

                System.out.println("Sent a simple response...");
            } else {
                System.out.println("Invalid handshake. Closing connection...");
                socket.close();
            }
        }
    }

    private static boolean isHandshakeValid(String handshake) {
        // You can replace this with your own logic to validate the handshake
        // For now, let's just check if the handshake starts with "A07_AuthFailure"
        return handshake.startsWith("A07_AuthFailure");
    }
}