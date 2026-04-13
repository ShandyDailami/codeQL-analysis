import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34171_SocketServer_A01 {

    private static ExecutorService execService = Executors.newCachedThreadPool();
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(8080);
    }

    public static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                Handler handler = new Handler(clientSocket);
                execService.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Handler implements Runnable {
        private final Socket socket;
        private final BufferedReader reader;
        private final PrintWriter writer;

        public java_34171_SocketServer_A01(Socket socket) {
            this.socket = socket;

            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
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
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private void handleMessage(String message) {
            // This is a placeholder for a more secure version of handling the message.
            // For instance, you could check if the message is a command and then respond accordingly.
            // This is a basic example and a real-world application would need more complex logic.

            System.out.println("Received: " + message);
            writer.println("Received: " + message);
        }
    }
}