import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_22514_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345, 1024, InetAddress.getByName("localhost"));
            LOGGER.info("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.info("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client request
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (Exception e) {
            LOGGER.severe("Server failed to start: " + e.getMessage());
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_22514_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you would handle the client request. For instance, you can read the request data and perform an integrity check.
            // For this example, we will just echo the data back.
            socket.getInputStream().read();
            socket.getOutputStream().write(socket.getInputStream().read());
        } catch (Exception e) {
            LOGGER.severe("Error handling client request: " + e.getMessage());
        }
    }
}