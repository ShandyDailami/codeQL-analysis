import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02214_SocketServer_A01 {
    private static ExecutorService executor;
    private static volatile boolean running = true;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");
            while (running) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                handleClient(socket);
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_02214_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Server response: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        private void closeConnection() {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                        System.out.println("Connection closed");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}