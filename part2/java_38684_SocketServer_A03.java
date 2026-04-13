import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_38684_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startServer() throws IOException {
        serverSocket = new ServerSocket(5000);
        executor = Executors.newCachedThreadPool();

        while (true) {
            System.out.println("Waiting for a connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_38684_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // You can add here code to prevent SQL Injection or any other injection by adding parameters to the query
                    // For example, a parameterized query or an ORM library
                    // For example, "INSERT INTO Users (username, password) VALUES (?, ?)", new String[]{"user1", "password1"});
                    // For example, "SELECT * FROM Users WHERE username = ? AND password = ?"

                    // Now we just echo back the message
                    writer.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    clientSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}