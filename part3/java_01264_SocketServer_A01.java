import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01264_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                // Handle the connection here, for example, by creating a new thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_01264_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the socket connection here, for example, by reading and writing data
        }
    }
}