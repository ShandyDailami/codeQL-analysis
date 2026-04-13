import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_15780_SocketServer_A01 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_15780_SocketServer_A01(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                executor.execute(new SocketHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error handling client connection");
            }
        }
    }

    private class SocketHandler implements Runnable {
        private final Socket socket;

        public java_15780_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform security-sensitive operations here

                    // Assume a successful operation with the message
                    if (message.equals("success")) {
                        out.println("Operation successful");
                    } else {
                        out.println("Operation failed");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
    }
}