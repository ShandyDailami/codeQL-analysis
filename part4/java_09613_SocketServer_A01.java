import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09613_SocketServer_A01 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
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
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream inputStream;
        private DataOutputStream outputStream;

        public java_09613_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message = inputStream.readUTF();
                System.out.println("Received: " + message);
                outputStream.writeUTF("Hello, client");
                System.out.println("Sent: Hello, client");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}