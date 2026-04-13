import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41491_SocketServer_A01 {
    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer();
    }

    private static void startServer() throws IOException {
        executorService = Executors.newFixedThreadPool(10);
        serverSocket = new ServerSocket(8080);

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        executorService.execute(new ClientHandler(in, out, clientSocket));
    }

    private static class ClientHandler implements Runnable {
        private final BufferedReader in;
        private final PrintWriter out;
        private final Socket clientSocket;

        public java_41491_SocketServer_A01(BufferedReader in, PrintWriter out, Socket clientSocket) {
            this.in = in;
            this.out = out;
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals("exit")) {
                        out.println("Goodbye!");
                        clientSocket.close();
                        break;
                    } else {
                        out.println("Hello, you said: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}