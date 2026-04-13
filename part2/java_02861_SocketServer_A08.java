import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02861_SocketServer_A08 {

    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        startServer();

        // Wait for user input to stop server
        System.out.println("Press any key to stop server...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        stopServer();
    }

    private static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            executor.execute(new SocketHandler(socket));
        }
    }

    private static void stopServer() {
        executor.shutdown();
        try {
            serverSocket.close();
            System.out.println("Server stopped!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private Socket socket;

        public java_02861_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create streams for reading and writing
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                // Send response
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=utf-8\r\n\r\n" +
                        "Successfully connected!\r\n";
                outputStream.write(response.getBytes());
                outputStream.flush();

                // Close the socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}