import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18742_SocketServer_A07 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(12345); // Port number
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        System.out.println("Server started. Listening on port 12345...");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handshake process for authentication
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF(); // Read the client's message
                System.out.println("Client message: " + clientMessage);

                if ("AUTHENTICATE".equals(clientMessage)) {
                    // Send authentication response
                    dos.writeUTF("AUTHENTICATION_SUCCESSFUL");
                    dos.flush();
                } else {
                    // Send error message if authentication fails
                    dos.writeUTF("AUTHENTICATION_FAILED");
                    dos.flush();
                }

                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
                server.close();
            }
        }
    }
}