import java.io.*;
import java.net.*;
import java.util.*;

public class java_01019_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected at: " + socket.getRemoteSocketAddress());

            // Create new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_01019_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input stream
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Read a line from client
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Echo back the message to client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Echo: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}