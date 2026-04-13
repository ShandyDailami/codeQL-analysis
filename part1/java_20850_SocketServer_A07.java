import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_20850_SocketServer_A07 {
    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_20850_SocketServer_A07(int port) {
        try {
            serverSocket = new ServerSocket(port);
            executor = Executors.newCachedThreadPool();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void startServer() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                handleClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to accept connection");
            }
        }
    }

    private void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public java_20850_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                out.println("Welcome to the server!");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Server received your message");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}