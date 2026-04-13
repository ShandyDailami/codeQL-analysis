import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_24662_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        // Create a pool of threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                // Accept a new connection
                Socket socket = new Socket("localhost", PORT);

                // Create a new thread to handle the new connection
                executorService.execute(new ClientHandler(socket));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_24662_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create a buffered reader and print writer
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Read from the client and write to the client
                String message;
                while ((message = reader.readLine()) != null) {
                    writer.println("Echo: " + message);
                }

                // Close the connections
                writer.close();
                reader.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}