import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02484_SocketServer_A08 {
    private static final int PORT = 6789;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(5);

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            Handler handler = new Handler(socket);
            executorService.execute(handler);
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_02484_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // For demonstration purposes, we're going to simulate an integrity failure.
                    // A real-world application would need to take this into account, and likely use a more complex algorithm to secure against this.
                    if (message.equalsIgnoreCase("A08_IntegrityFailure")) {
                        writer.println("Error: Integrity failure");
                        writer.flush();

                        // Close the connection
                        socket.close();
                    } else {
                        writer.println("Processing the message: " + message);
                        writer.flush();
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}