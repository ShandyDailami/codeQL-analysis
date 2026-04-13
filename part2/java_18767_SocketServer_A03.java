import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18767_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, InterruptedException {
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_18767_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String message = reader.readLine();

                if (message.equals(String.format("SELECT * FROM users WHERE username=%s AND password=%s", "test", "test"))) {
                    System.out.println("Attempted injection attack!");
                }

                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Message received");

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}