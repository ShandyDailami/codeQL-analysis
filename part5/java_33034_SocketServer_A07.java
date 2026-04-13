import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_33034_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final String PASSWORD = "password";
    private static final String SERVER_MESSAGE = "Hello from server!";

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            executorService.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_33034_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(SERVER_MESSAGE);

                String message = socket.getInputStream().readUTF();
                if (!PASSWORD.equals(message)) {
                    out.println("Authentication failed!");
                    return;
                }

                out.println("Welcome to the chat!");
                String clientMessage;
                while ((clientMessage = socket.getInputStream().readUTF()) != null) {
                    out.println("Server: " + clientMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}