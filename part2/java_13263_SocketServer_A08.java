import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_13263_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        executor = Executors.newFixedThreadPool(50); // Create a pool of 50 threads

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Create a new handler for this client
            HandlerThread thread = new HandlerThread(clientSocket);
            thread.start();
        }
    }

    private static class HandlerThread extends Thread {
        private Socket socket;
        public java_13263_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("close")) {
                        socket.close();
                        System.out.println("Client disconnected");
                        return;
                    }

                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}