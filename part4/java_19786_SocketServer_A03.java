import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19786_SocketServer_A03 {

    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                executorService.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_19786_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    // This is a simple form of authentication where we assume all valid requests are "valid"
                    if ("valid".equals(request)) {
                        out.println("Authentication successful!");
                    } else {
                        out.println("Authentication failed!");
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}