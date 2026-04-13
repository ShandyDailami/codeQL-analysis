import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37646_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the connection
                new HandleConnection(socket).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    // Handles reading and writing for one connection
    private static class HandleConnection extends Thread {
        private final Socket socket;

        public java_37646_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here, you can add code to read and write data, handle exceptions, etc.
                // For now, just write a response back to the client
                socket.getOutputStream().write("Hello, client!\n".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}