import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23599_SocketServer_A01 {

    private static final int PORT = 9876;
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_23599_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                if ((message = in.readLine()) != null) {
                    processRequest(message);
                }
            } catch (IOException e) {
                closeConnection();
           
            }
        }

        private void processRequest(String message) {
            // Implement security-sensitive operations here
            // For example, checking if the message contains sensitive information
            if (message.contains("sensitive info")) {
                out.println("Error: Sensitive information detected");
                out.flush();
            } else {
                out.println("Message received: " + message);
                out.flush();
            }
        }

        private void closeConnection() {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        socket.close();
                        System.out.println("Connection closed at " + socket.getRemoteSocketAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}