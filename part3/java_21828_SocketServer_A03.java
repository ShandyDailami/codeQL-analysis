import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21828_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final String SERVER_MESSAGE = "Echo Server";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                executorService.execute(new EchoHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    static class EchoHandler implements Runnable {
        private final Socket socket;

        EchoHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket clientSocket = socket;
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                out.println(SERVER_MESSAGE);
                String echo = socket.getInputStream().readUTF();
                System.out.println("Received message: " + echo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}