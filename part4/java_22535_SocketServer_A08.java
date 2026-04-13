import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22535_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            } catch (IOException ex) {
                System.out.println("Error accepting client connection");
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_22535_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equals("A08_IntegrityFailure")) {
                        writer.println("IntegrityFailureError: You have sent an A08_IntegrityFailure message");
                    } else {
                        writer.println("You sent: " + message);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error handling client");
            }
        }
    }
}