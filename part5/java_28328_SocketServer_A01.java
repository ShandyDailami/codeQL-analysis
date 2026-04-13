import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_28328_SocketServer_A01 {
    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                executor.submit(handler);
            } catch (IOException e) {
                e.printStackTrace();
                server.close();
            }
        }
    }

    static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_28328_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate a security-sensitive operation
                    if (message.equals("Dangerous Command")) {
                        System.out.println("Denying access!");
                        writer.println("Access Denied");
                        writer.flush();
                        break;
                    }

                    writer.println("Message received: " + message);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        private void closeConnection() {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        reader.close();
                        writer.close();
                        socket.close();
                        System.out.println("Connection closed!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}