import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18828_SocketServer_A07 {
    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(1234); // listening on port 1234
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    private static void handleClient(Socket socket) {
        executorService.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_18828_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                // Server sends "login" message to client
                String clientMessage = reader.readLine();
                if ("login".equals(clientMessage)) {
                    // Client sends "password" to server
                    String password = reader.readLine();

                    // Implementing basic authentication here.
                    // In a real-world scenario, you should use a secure way to verify passwords.
                    if ("securepassword".equals(password)) {
                        writer.write("Authentication successful\n".getBytes());
                    } else {
                        writer.write("Authentication failed\n".getBytes());
                    }
                } else {
                    writer.write("Unknown command\n".getBytes());
                }

                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}