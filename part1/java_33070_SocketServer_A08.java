import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33070_SocketServer_A08 {

    private final ExecutorService executorService;
    private boolean running = true;

    public java_33070_SocketServer_A08() {
        executorService = Executors.newFixedThreadPool(10);
    }

    public void start(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (running) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new ClientHandler(clientSocket));
        }
        executorService.shutdown();
    }

    public void stop() {
        running = false;
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_33070_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                while (bytesRead != -1) {
                    output.write(buffer, 0, bytesRead);
                    bytesRead = input.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}