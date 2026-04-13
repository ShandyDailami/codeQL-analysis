import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_10218_SocketServer_A07 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_10218_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received: " + request);

                // TODO: Add real-world authentication logic here
                // This is just a placeholder
                if ("auth_request".equals(request)) {
                    writer.write("auth_response\n".getBytes());
                } else {
                    writer.write("auth_denied\n".getBytes());
                }

                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}