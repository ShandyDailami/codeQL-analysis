import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20205_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here we're assuming that the server is secure and can only communicate
                // with clients who provide a valid handshake. In a real-world scenario,
                // this would be a more complex handshake process.
                String handshake = socket.getInputStream().readUTF();
                if ("valid handshake".equals(handshake)) {
                    // If the handshake is valid, we can now start a separate thread for the client.
                    new ClientHandler(socket).start();
                } else {
                    // If the handshake is not valid, we can close the connection.
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_20205_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we're assuming that the client can only send and receive a single message at a time.
            // In a real-world scenario, this would be a more complex protocol that allows multiple messages.
            String message = socket.getInputStream().readUTF();
            System.out.println("Received message from client: " + message);

            String response = "Message received, processing...";
            socket.getOutputStream().writeUTF(response);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}