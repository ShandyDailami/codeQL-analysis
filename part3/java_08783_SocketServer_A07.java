import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08783_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            executor.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_08783_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (Exception e) {
                System.err.println("Error setting up I/O for " + clientSocket.getRemoteSocketAddress());
                clientSocket.close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String response;
                    if ("user".equals(message)) {
                        response = "valid";
                    } else {
                        response = "invalid";
                    }
                    out.println(response);
                    out.flush();
                }
            } catch (IOException ex) {
                System.err.println("Error handling client " + clientSocket.getRemoteSocketAddress());
                ex.printStackTrace();
            } finally {
                clientSocket.close();
            }
        }
    }
}