import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08091_SocketServer_A07 {
    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) {
        System.out.println("Server starting on port " + PORT);

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            executor = Executors.newCachedThreadPool();
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08091_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                while (bytesRead != -1) {
                    // handle input here
                }
                output.write("Hello Client, you connected to server!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}