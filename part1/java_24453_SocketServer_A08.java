import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24453_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        // Create the executor service with fixed thread pool of 10
        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started at port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            // Start a new thread for each connection
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_24453_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    // Add your integrity failure related code here
                    // You can use data manipulation techniques like XOR, bit flipping, etc.

                    // Here's an example of how you might send a response
                    out.println("Server says: Hello, client!");
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}