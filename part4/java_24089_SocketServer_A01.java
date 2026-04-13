import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24089_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(5);

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port: 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket);
                executor.execute(handler);
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

    static class Handler implements Runnable {
        private Socket socket;

        public java_24089_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String request = dataInputStream.readUTF();
                System.out.println("Received request: " + request);

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Server received your message");
                outputStream.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}