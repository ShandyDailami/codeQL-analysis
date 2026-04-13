import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31235_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Start a new thread to handle the request
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_31235_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read the request from the client
                socket.getInputStream().read();

                // Send a response
                socket.getOutputStream().write("Hello, client!".getBytes());
                socket.getOutputStream().flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}