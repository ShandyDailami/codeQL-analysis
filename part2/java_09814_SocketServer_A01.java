import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09814_SocketServer_A01 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {

        Socket socket;

        public java_09814_SocketServer_A01(Socket socket) {
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