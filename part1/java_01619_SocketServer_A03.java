import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01619_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handle the connection here, e.g. start a new thread for each connection

                // If you want to use a simple thread for this example, you can do the following:
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_01619_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client's request here, e.g. read a message from the client, send a response, etc.
        // For simplicity, this example just prints the received message.

        try (socket;
             java.io.DataInputStream in = new java.io.DataInputStream(socket.getInputStream())) {
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // In a real-world application, you would want to send a response back to the client.
            // For simplicity, this example just sends a back message.
            String response = "Server received your message: " + message;
            java.io.DataOutputStream out = new java.io.DataOutputStream(socket.getOutputStream());
            out.writeUTF(response);
        } catch (IOException e) {
            System.err.println("Client handler error: " + e.getMessage());
        }
    }
}