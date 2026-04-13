import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31373_SocketServer_A07 {

    private static final String PASSWORD = "secret";
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class HandleClient extends Thread {
        private Socket socket;

        public java_31373_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read the password from the socket
                socket.getInputStream().readUTF();
                String input = socket.getInputStream().readUTF();

                if (input.equals(PASSWORD)) {
                    // Authentication successful, send a welcome message
                    socket.getOutputStream().writeUTF("Welcome!");
                    socket.getOutputStream().flush();
                } else {
                    // Authentication failed, send an error message
                    socket.getOutputStream().writeUTF("Authentication failed!");
                    socket.getOutputStream().flush();
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}