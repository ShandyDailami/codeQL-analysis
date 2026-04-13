import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37690_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(50);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_37690_SocketServer_A08(Socket socket) {
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
                    // Checking for integrity failure
                    if (message.equals("A08_IntegrityFailure")) {
                        out.println("A08_IntegrityFailure Error");
                    } else {
                        out.println("OK");
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}