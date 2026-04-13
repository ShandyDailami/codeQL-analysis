import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15203_SocketServer_A08 {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind port " + port + ": " + e.getMessage());
        }
    }
}

class HandlerThread extends Thread {
    private final Socket socket;

    public java_15203_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get a stream from the socket, handle the request and send the response
        } catch (IOException e) {
            System.err.println("Error handling request from " + socket.getRemoteSocketAddress() + ": " + e.getMessage());
        }
    }
}