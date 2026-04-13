import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19554_SocketServer_A07 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");
                new AuthHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class AuthHandler extends Thread {
        private final Socket socket;

        public java_19554_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // TODO: Implement authentication logic
                // Here you should implement a method that accepts a socket and performs authentication.
                // This is a placeholder, replace it with your actual implementation.
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}