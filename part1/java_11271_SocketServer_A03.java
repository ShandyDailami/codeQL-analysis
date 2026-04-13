import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_11271_SocketServer_A03 {
    private static final int PORT = 4445;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        // Initialize the executor service
        executor = Executors.newCachedThreadPool();

        // Start the server
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");
            // handle the client in a new thread
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_11271_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Create data buffers
                DataInputStream dis = new DataInputStream(input);
                DataOutputStream dos = new DataOutputStream(output);

                // Receive a message from the client
                String message = dis.readUTF();
                System.out.println("Received message: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                dos.writeUTF(response);
                System.out.println("Sent response: " + response);

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}