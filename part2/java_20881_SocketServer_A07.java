import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_20881_SocketServer_A07 {
    private static final int PORT = 6000;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Client connected");

                    // Start a new thread for each connection
                    executor.execute(new SocketHandler(socket));

                } catch (Exception ex) {
                    // Handle the exception here
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            // Handle the exception here
            ex.printStackTrace();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_20881_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);

                    // Check for authentication failures here
                    if ("auth".equals(message)) {
                        writer.writeBytes("Authentication failed\n");
                        writer.flush();
                        return;
                    }

                    writer.writeBytes("Message received\n");
                    writer.flush();
                }

            } catch (IOException ex) {
                // Handle the exception here
                ex.printStackTrace();
            }
        }
    }
}