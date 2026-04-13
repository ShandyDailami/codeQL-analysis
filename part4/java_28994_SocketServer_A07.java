import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28994_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Security-sensitive operation: Authentication
                // Here, we're just checking if the socket is authenticated.
                // In a real-world application, you'd use a secure authentication protocol here.
                if (authenticate(socket)) {
                    new Thread(new ClientHandler(socket)).start();
                } else {
                    System.out.println("Authentication failed for client: " + socket.getRemoteSocketAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // You'd replace this with your actual authentication logic.
        // In a real-world application, you'd use a secure method to authenticate the client.
        // This is just a placeholder.
        return true;
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_28994_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Process the client's message
            // Here, we're just reading the first message from the client and echoing it back.
            // In a real-world application, you'd process the client's message and send a response.
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Received: " + message);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}