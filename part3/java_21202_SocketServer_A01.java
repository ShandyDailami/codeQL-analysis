import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_21202_SocketServer_A01 {

    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected at " + socket.getRemoteSocketAddress());
                MessageHandler handler = new MessageHandler(socket);
                executor.submit(handler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            executor.shutdown();
        }
    }

    private static class MessageHandler implements Runnable {
        private Socket socket;

        public java_21202_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String message;

                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    if (!message.equals("authenticate")) {
                        System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected");
                        socket.close();
                        return;
                    }
                }

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("authenticated");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}