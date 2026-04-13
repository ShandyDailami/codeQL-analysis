import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31823_SocketServer_A03 {

    private ExecutorService executorService;

    public java_31823_SocketServer_A03() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public void start(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");
            handleClient(socket);
        }
    }

    private void handleClient(Socket socket) {
        executorService.execute(new ClientHandler(socket));
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_31823_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message from client: " + message);
                    handleMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handleMessage(String message) {
            // TODO: Implement security-sensitive operations here
            // This is a placeholder. You should handle the message appropriately.
            System.out.println("Handled message: " + message);
        }
    }

    public static void main(String[] args) {
        try {
            new VanillaJavaSocketServer().start(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}