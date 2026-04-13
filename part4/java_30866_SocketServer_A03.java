import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30866_SocketServer_A03 {

    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    static class Handler implements Runnable {
        private Socket socket;

        public java_30866_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Perform injection attack if request contains SQL command
                    if (request.toLowerCase().contains("select")) {
                        System.out.println("SQL Injection attempt");
                        // Dangerous code, always check for SQL command before executing
                        System.out.println("Executed: " + request);
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(3456);
            System.out.println("Server started on port 3456...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                executorService.execute(new Handler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}