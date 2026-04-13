import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41237_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        executor = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            } catch (Exception e) {
                server.close();
                System.out.println("Error occurred: " + e.getMessage());
                break;
            }
        }

        executor.shutdown();
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_41237_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // read from the socket
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                // write to the socket
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Server response: " + message);
                }
            } catch (Exception e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Error closing socket: " + ex.getMessage());
                }
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
    }
}