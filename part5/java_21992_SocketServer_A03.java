import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_21992_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected...");
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
                serverSocket.close();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_21992_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    // Process the request here, for example, by echoing back to the client
                    String response = request;

                    out.println(response);
                }

                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}