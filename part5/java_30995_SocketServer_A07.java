import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30995_SocketServer_A07 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_30995_SocketServer_A07(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Starting server at port " + serverSocket.getLocalPort());
        while (!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());
                // Pass the socket to the handler
                executor.execute(new SocketHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(8080);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;

        public java_30995_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readLine();
                System.out.println("Received request: " + request);
                if (request.startsWith("GET")) {
                    out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                    out.flush();
                } else {
                    out.writeBytes("HTTP/1.1 400 Bad Request\r\n\r\n");
                    out.flush();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}