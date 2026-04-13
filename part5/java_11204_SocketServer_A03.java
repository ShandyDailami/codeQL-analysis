import java.io.*;
import java.net.*;

public class java_11204_SocketServer_A03 {
    private static int serverPort = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server started at port " + serverPort);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Handling the client in a new thread
            HandleClient hc = new HandleClient(socket);
            Thread t = new Thread(hc);
            t.start();
        }
    }

    static class HandleClient implements Runnable {
        private Socket socket;

        public java_11204_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Simple example of SQL Injection attack
                    // TODO: Verify and sanitize input to prevent SQL Injection
                    // In real application, you should use PreparedStatements or other methods for database operations
                    if (clientMessage.contains("drop table")) {
                        out.println("Attempting to drop a table...");
                        // This is a very naive example of how an attack could occur
                        // In a real application, you should never do this, always sanitize inputs
                        out.println("Dropped table successfully!");
                    } else {
                        out.println("Client says: " + clientMessage);
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}