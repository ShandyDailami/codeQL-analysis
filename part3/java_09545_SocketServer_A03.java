import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_09545_SocketServer_A03 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");
            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    static class Handler extends Thread {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytes = input.read(buffer);
                while (bytes != -1) {
                    output.write(buffer, 0, bytes);
                    bytes = input.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}