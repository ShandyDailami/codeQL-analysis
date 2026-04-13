import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_13443_SocketServer_A01 {
    private static ExecutorService execService;

    public static void main(String[] args) throws IOException {
        startServer(8080);
    }

    public static void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        execService = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            execService.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        SocketHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Implement security-sensitive operations here
                    // For example, check if the message contains a specific keyword
                    // If the message contains a keyword, change the message to a secure one
                    if (message.contains("keyword")) {
                        out.println("Access denied: Message contains a keyword!");
                    } else {
                        out.println("Message received: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}