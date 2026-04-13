import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05418_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                executor.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
            executor.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_05418_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Only accept requests from the same machine
                if (request.contains("localhost")) {
                    out.writeBytes("HTTP/1.1 403 Forbidden\r\n\r\n");
                } else {
                    out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                }

                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}