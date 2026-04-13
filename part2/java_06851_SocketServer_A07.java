import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06851_SocketServer_A07 {

    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted a new client " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_06851_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    if ("exit".equals(request)) {
                        socket.close();
                        executor.execute(new ClientHandlerExit(socket));
                        return;
                    }

                    if ("auth".equals(request)) {
                        // Authentication logic goes here.
                        // For now, let's say it's successful.
                        writer.println("Auth successful");
                        writer.flush();
                    } else {
                        writer.println("Unknown request");
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientHandlerExit implements Runnable {

        private Socket socket;

        public java_06851_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client has exited");
        }
    }
}