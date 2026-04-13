import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05799_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server started");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");

                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;

        public java_05799_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String request = reader.readLine();
                System.out.println("Request: " + request);

                if (isValidRequest(request)) {
                    OutputStream output = socket.getOutputStream();
                    output.write("HTTP/1.1 200 OK\r\n".getBytes());
                    output.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                    output.write("\r\n".getBytes());
                    output.write("Hello, World!".getBytes());
                    output.flush();
                } else {
                    OutputStream output = socket.getOutputStream();
                    output.write("HTTP/1.1 403 Forbidden\r\n".getBytes());
                    output.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                    output.write("\r\n".getBytes());
                    output.write("Invalid request".getBytes());
                    output.flush();
                }

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private boolean isValidRequest(String request) {
            // Implement your own logic to validate the request here
            // For now, let's assume all requests are valid
            return true;
        }
    }
}