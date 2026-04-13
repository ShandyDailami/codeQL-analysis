import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04813_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // Perform authentication
            if (!authenticate(socket)) {
                System.out.println("Authentication failed. Closing connection.");
                socket.close();
                continue;
            }

            // Handle the client
            executor.execute(new ClientHandler(socket));
        }
    }

    private static boolean authenticate(Socket socket) throws IOException {
        // Here we're just simulating an authentication process.
        // In a real application, you would need to use a secure way to authenticate the client.
        // In this example, we're only checking if the client's IP matches a hard-coded list.

        String clientIP = socket.getInetAddress().getHostAddress();
        if ("192.168.1.1".equals(clientIP)) {
            return true;
        }

        System.out.println("Client IP (" + clientIP + ") is not allowed.");
        return false;
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_04813_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                int request;
                while ((request = in.read()) != -1) {
                    out.write(request);
                    out.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            socket.close();
        }
    }
}