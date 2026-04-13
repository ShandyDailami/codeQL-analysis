import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13736_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start");
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public java_13736_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle request and response here
        }
    }
}