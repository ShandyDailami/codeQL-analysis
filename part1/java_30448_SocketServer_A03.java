import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30448_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected " + socket.getRemoteSocketAddress());
            ClientHandler clientHandler = new ClientHandler(socket);
            executor.execute(clientHandler);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_30448_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}