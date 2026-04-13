import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_12321_SocketServer_A01 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server started at port 8000");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // BrokenAccessControl: Do not create thread for each client
                executor.execute(new ClientHandler(socket));
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out");
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_12321_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request, response;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // BrokenAccessControl: Do not print the received message
                    response = "Server received: " + request;
                    out.writeBytes(response + '\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}