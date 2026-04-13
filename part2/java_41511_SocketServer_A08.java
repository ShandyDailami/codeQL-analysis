import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41511_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                new HandleConnection(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class HandleConnection extends Thread {
        private Socket socket;

        public java_41511_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the connection here, e.g. read data, send response, etc.
        }
    }
}