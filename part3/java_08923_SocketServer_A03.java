import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08923_SocketServer_A03 {
    private static final String END_OF_LINE = "\r\n";
    private static final String CONNECTION_CLOSED = "Connection Closed";
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08923_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String request, response;
                while ((request = in.readLine()) != null) {
                    if ("QUIT".equals(request)) {
                        response = CONNECTION_CLOSED;
                    } else {
                        response = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n" +
                                "X-Content-Type-Options: nosniff\r\n" +
                                "X-Frame-Options: DENY\r\n" +
                                "X-XSS-Protection: 1; mode=block\r\n" +
                                "Connection: close\r\n\r\n" +
                                "<html><body>Hello, Client!</body></html>"; // Replace this with your own response
                    }
                    out.println(response + END_OF_LINE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}