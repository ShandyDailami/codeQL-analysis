import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29769_SocketServer_A01 {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(HOST, PORT));
        System.out.println("Server started on " + HOST + " port " + PORT);

        while (true) {
            Socket socket = server.accept();
            InetAddress clientAddress = socket.getInetAddress();
            System.out.println("Client connected from " + clientAddress.getHostAddress());

            // Handling the client connection in a separate thread
            new HandlerThread(socket).start();
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_29769_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client connection and communication here
        }
    }
}