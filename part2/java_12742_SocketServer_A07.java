import java.net.*;
import java.util.concurrent.*;

public class java_12742_SocketServer_A07 {

    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_12742_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Create a new socket for the client and stream its input and output
                Socket client = new Socket(clientSocket.getInetAddress(), clientSocket.getPort());

                // Use a buffered reader and writer to handle the client's input and output
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Handle authentication failure by sending a failure message
                out.println("Authentication failure");
                out.flush();

                // Close the connection
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}