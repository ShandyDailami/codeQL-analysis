import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14084_SocketServer_A01 {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws Exception {
        int port = 8080;

        serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());

            // Start a new thread to handle the client
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_14084_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    out.println("Server received: " + request);
                    out.flush();
                }

                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}