import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09473_SocketServer_A07 {

    private int port;
    private ServerSocket serverSocket;

    public java_09473_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Handle socket operations here
                // For example, you can start a new thread to handle the socket operations
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Handler extends Thread {
        private Socket socket;

        public java_09473_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle socket operations here
            // For example, you can read from the socket and send a response
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}