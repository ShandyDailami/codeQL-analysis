import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32756_SocketServer_A01 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 6666;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();

                // Check if the client's IP address is the same as the local machine
                String clientIp = socket.getInetAddress().getHostAddress();
                if (!clientIp.equals(LOCALHOST)) {
                    System.out.println("Connection from " + clientIp + " is rejected");
                    socket.close();
                    continue;
                }

                System.out.println("Connection from " + clientIp + " is accepted");

                // Handle the client connection in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server could not start due to " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_32756_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client's communication here
            // ...
        }
    }
}