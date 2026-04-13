import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36188_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Perform user authentication
                if (authenticateUser(clientSocket)) {
                    executor.execute(new ClientHandler(clientSocket));
                } else {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* cannot do anything because of non-finally resource */ }
            }
            executor.shutdown();
        }
    }

    private static boolean authenticateUser(Socket socket) {
        // Implement user authentication logic here
        // For simplicity, we'll just return true for all users
        return true;
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        public java_36188_SocketServer_A01(Socket socket) { this.socket = socket; }
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
                socket.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}