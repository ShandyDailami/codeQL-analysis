import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18853_SocketServer_A03 {

    private final ExecutorService executor;
    private final ServerSocket server;

    public java_18853_SocketServer_A03(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.server = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server started on port " + server.getLocalPort() + ".");
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");
                executor.execute(new ClientHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void stop() {
        executor.shutdown();
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server stopped");
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;

        public java_18853_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) != -1) {
                    output.write(buffer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SecureSocketServer(8080).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}