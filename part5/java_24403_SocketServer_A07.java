import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_24403_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final int THREADS = 5;

    private final ExecutorService executorService;

    public java_24403_SocketServer_A07() {
        executorService = Executors.newFixedThreadPool(THREADS);
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                MessageHandler handler = new MessageHandler(clientSocket);
                executorService.submit(handler);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start();
    }
}

class MessageHandler implements Runnable {

    private final Socket socket;

    public java_24403_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (socket;
             java.io.BufferedReader in = new java.io.BufferedReader(
                     new java.io.InputStreamReader(socket.getInputStream()))) {

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client says: " + line);
                String response = authenticate(line);
                socket.getOutputStream().write((response + "\n").getBytes());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String authenticate(String message) {
        // Here you can implement the authentication logic
        // This is a simple example where we check if the message is 'login'
        return (message.equals("login")) ? "Welcome!" : "Access denied.";
    }
}