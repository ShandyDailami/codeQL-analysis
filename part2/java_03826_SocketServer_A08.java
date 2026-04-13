import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_03826_SocketServer_A08 {
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
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_03826_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                byte[] bytes = new byte[1024];
                int length;
                while ((length = input.read(bytes)) != -1) {
                    byte[] responseBytes = ("Hello, client!").getBytes();
                    output.write(responseBytes);
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}