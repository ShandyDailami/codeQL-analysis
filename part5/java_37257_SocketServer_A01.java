import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37257_SocketServer_A01 {
    private static final int PORT = 12345; // Choose a port number

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Perform basic authentication process
                if (authenticate(client)) {
                    new Thread(new ClientHandler(client)).start();
                } else {
                    client.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simple authentication process. Adjust as needed.
    private static boolean authenticate(Socket client) {
        // Here, we're using a very basic form of authentication.
        // In a real-world application, you would likely use a secure method of communication,
        // such as encrypted data or a secret key.
        // For the sake of simplicity, this example only works for demonstration purposes.

        // The client sends a username and a password.
        // In a real application, you would send this data encrypted or in some other way.
        try {
            String username = client.getInputStream().readUTF();
            String password = client.getInputStream().readUTF();

            // In a real application, you would compare the input data with a stored value.
            // This is just a simple example.
            return username.equals("admin") && password.equals("password");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_37257_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // The client can now communicate with the server.
                // For the sake of simplicity, this example only sends and receives data.
                client.getOutputStream().writeUTF("Hello, client!");
                client.getOutputStream().flush();

                String message = client.getInputStream().readUTF();
                System.out.println("Server says: " + message);

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}