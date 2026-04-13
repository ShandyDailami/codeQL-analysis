import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41091_SocketServer_A07 {
    private ServerSocket serverSocket;

    public java_41091_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port: " + serverSocket.getLocalPort() + "...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted a new client: " + clientSocket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Simulate authentication failure
            if (simulateAuthFailure()) {
                System.out.println("Authentication failed, closing connection...");
                clientSocket.close();
                continue;
            }

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = "Server received: " + message;
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            clientSocket.close();
        }
    }

    private boolean simulateAuthFailure() {
        // Simulate a random failure (50% chance)
        return Math.random() > 0.5;
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(5000);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}