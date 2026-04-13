import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23557_SocketServer_A03 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started at port " + port);

            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                    Handler handler = new Handler(socket);
                    executor.submit(handler);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_23557_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message, response;
            while (true) {
                try {
                    if ((message = reader.readLine()) != null) {
                        System.out.println("Client says: " + message);

                        // Here is the injection point
                        response = "Server says: " + message;

                        writer.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}