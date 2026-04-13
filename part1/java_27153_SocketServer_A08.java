import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_27153_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_27153_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = clientSocket.getInputStream();
                 OutputStream output = clientSocket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);

                while (bytesRead != -1) {
                    output.write(buffer, 0, bytesRead);
                    bytesRead = input.read(buffer);
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}