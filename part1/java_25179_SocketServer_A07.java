import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25179_SocketServer_A07 {
    private static ExecutorService executor;
    private static int port = 12345;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_25179_SocketServer_A07(Socket socket) {
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
                    if (message.equals("auth")) {
                        out.println("Auth successful");
                    } else {
                        out.println("Auth failure");
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}