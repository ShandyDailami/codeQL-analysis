import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09167_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                // Perform authentication here, e.g. using SSLSocket for security
                // ...

                // Handle the socket connection in a separate thread
                new HandleSocketTask(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleSocketTask extends Thread {
        private final Socket socket;

        public java_09167_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle socket communication here
            // ...
        }
    }
}