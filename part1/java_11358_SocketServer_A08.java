import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11358_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Handle request and response in a non-blocking way
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public java_11358_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle request and response here
            // For simplicity, we're just echoing back the data
            try {
                byte[] data = new byte[socket.getInputStream().available()];
                socket.getInputStream().read(data);
                socket.getOutputStream().write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}