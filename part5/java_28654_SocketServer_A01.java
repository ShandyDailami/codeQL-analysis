import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28654_SocketServer_A01 {

    private static final int PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }

        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_28654_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client connection here...
        // This is a placeholder and will not work as is in this example
        // You should replace this with code that actually handles the client connection

        // Close the socket when the client is finished
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}