import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_00474_SocketServer_A07 {
    private static final String AUTH_USER = "test";
    private static final String AUTH_PASS = "test";

    private Map<String, String> users = new HashMap<>();

    public java_00474_SocketServer_A07() {
        users.put(AUTH_USER, AUTH_PASS);
    }

    public void startServer(int port) {
        System.out.println("Starting server on port " + port + "...");

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.err.println("Server failed to start: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private final InputStream input;
        private final OutputStream output;

        public java_00474_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                this.input = socket.getInputStream();
                this.output = socket.getOutputStream();
            } catch (IOException ex) {
                System.err.println("Failed to get input or output stream: " + ex.getMessage());
                ex.printStackTrace();
                return;
            }
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + message);

                    if ("exit".equals(message)) {
                        socket.close();
                        return;
                    }
                }
            } catch (IOException ex) {
                System.err.println("Failed to read from socket: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer(8080);
    }
}