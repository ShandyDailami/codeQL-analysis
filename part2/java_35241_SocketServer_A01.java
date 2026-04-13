import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35241_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new EchoHandler(socket).start();
            }
        } catch (IOException ex) {
            System.err.println("Failed to listen on port " + PORT);
            ex.printStackTrace();
        }
    }

    private static class EchoHandler extends Thread {
        private final Socket socket;

        EchoHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getInputStream();
                 socket.getOutputStream()) {
                // no code here, as the task is to demonstrate the security-sensitive operations related to A01_BrokenAccessControl
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}