import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32674_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Handle client in a new thread
            new HandlerThread(socket).start();
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;

        public java_32674_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can add your code for security-sensitive operations related to A01_BrokenAccessControl
                // For example, checking the validity of the client's request and responding accordingly

                // Continue with your code...

            } finally {
                socket.close();
            }
        }
    }
}