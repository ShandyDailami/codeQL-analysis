import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31577_SocketServer_A08 {

    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT);

        executor = Executors.newFixedThreadPool(10);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
            Handler handler = new Handler(clientSocket);
            executor.execute(handler);
        }
    }

    public static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_31577_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Implement your security-sensitive operations here
                    // For example, check if message contains specific keywords or sequences
                    // If found, then set the integrity of the message to failure

                    // For simplicity, we'll just send back the received message to the client
                    writer.println(message);
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                // Handle exception
            }
        }
    }
}