import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25013_SocketServer_A07 {
    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(10);
        serverSocket = new ServerSocket(1234);

        while (true) {
            try {
                System.out.println("Waiting for client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from: " + clientSocket.getRemoteSocketAddress());

                Future<?> future = executorService.submit(new VanillaClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class VanillaClientHandler implements Runnable {
        private Socket clientSocket;

        public java_25013_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received from client: " + clientMessage);

                    // Simple authentication
                    if ("auth".equals(clientMessage)) {
                        out.println("Authentication successful");
                    } else {
                        out.println("Authentication failed");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}