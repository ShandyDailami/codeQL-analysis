import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_07080_SocketServer_A01 {
    private static final int PORT = 9876;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("New client connected!");
                    Handler handler = new Handler(socket);
                    executor.submit(handler);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            executor.shutdown();
        }
    }

    private static class Handler implements Runnable {
        private final Socket socket;

        public java_07080_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String request;
                while ((request = in.readLine()) != null) {
                    if (request.matches(".*password=.*")) {
                        out.println("Access denied!");
                        return;
                    }
                    out.println("Access granted!");
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}