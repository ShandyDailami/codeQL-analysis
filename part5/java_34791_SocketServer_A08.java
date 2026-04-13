import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34791_SocketServer_A08 {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Assume that the client is connecting from the same machine where the server is running.
        String clientHost = in.readUTF();
        if (!clientHost.equals(socket.getLocalSocketAddress().toString())) {
            System.out.println("Failed to authenticate client. Server exiting...");
            socket.close();
            serverSocket.close();
            return;
        }

        System.out.println("Received client host: " + clientHost);

        while (true) {
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Server received your message: " + message);
            out.flush();
        }
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer();
            server.start(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}