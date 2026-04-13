import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_00434_SocketServer_A08 {
    private static ExecutorService pool;
    private static int port = 12345;

    public static void main(String[] args) {
        pool = Executors.newFixedThreadPool(5);

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running and waiting for client connections on port " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                pool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_00434_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                DataInputStream dis = new DataInputStream(input);

                byte[] buffer = new byte[1024];
                int bytesRead = dis.read(buffer);

                if (bytesRead < 0) {
                    clientSocket.close();
                    return;
                }

                // Here you can add your security sensitive operation. For example, we can check the integrity of the data received.
                // If the received data is corrupted, we can throw an exception or send an error message back to the client.
                // This is a simple example and might not be fully secure.
                String receivedData = new String(buffer, 0, bytesRead);
                if (!isDataCorrupted(receivedData)) {
                    System.out.println("Received data: " + receivedData);
                } else {
                    OutputStream output = clientSocket.getOutputStream();
                    output.write("Error: Received data is corrupted".getBytes());
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isDataCorrupted(String data) {
            // Implement your own logic to check the integrity of the data here.
            // For the example, let's just return true if the data contains "corruption".
            return data.contains("corruption");
        }
    }
}