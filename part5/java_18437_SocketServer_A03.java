import java.io.*;
import java.net.*;

public class java_18437_SocketServer_A03 {
    private static final String SERVER_STREAM_NAME = "MyServer";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Handling client thread
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_18437_SocketServer_A03(Socket socket) {
            this.socket = socket;
            init();
        }

        private void init() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Send welcome message
                out.println("Welcome to the server!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;

            while ((message = readMessage()) != null) {
                handleMessage(message);
            }
        }

        private String readMessage() {
            try {
                return in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void handleMessage(String message) {
            // Handle the message here. For example, we'll just echo it back.
            out.println(message);
        }
    }
}