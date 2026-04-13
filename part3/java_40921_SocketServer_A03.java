import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40921_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(5000); // Port 5000
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client connection
                executor.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_40921_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                // Read client's message
                message = reader.readLine();

                // Check for suspicious activity
                if (message.contains("passwd")) {
                    writer.println("Suspicious activity detected. Please change your password.");
                } else {
                    writer.println("Thank you for connecting, " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}