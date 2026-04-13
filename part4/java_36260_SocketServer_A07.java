import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36260_SocketServer_A07 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        server = new ServerSocket(5000);
        System.out.println("Server started at port 5000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_36260_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    if (isAuthenticated(clientMessage)) {
                        out.println("Authentication failed, please login again.");
                        out.flush();
                        break;
                    } else {
                        out.println("Welcome, client.");
                        out.flush();
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isAuthenticated(String message) {
            // Here we assume that the message sent by client is a username.
            // For real-world application, you should use more sophisticated methods
            // to check the authentication. For simplicity, we just check if the message
            // is "admin".
            return message.equals("admin");
        }
    }
}