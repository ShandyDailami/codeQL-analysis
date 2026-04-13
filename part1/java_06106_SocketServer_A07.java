import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06106_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());
                executor.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
            executor.shutdown();
        }
    }

    static class SocketHandler implements Runnable {

        Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_06106_SocketServer_A07(Socket socket) {
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
            String message;
            try {
                if ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    // Perform authentication and respond appropriately
                    if ("auth".equals(message)) {
                        writer.println("Auth successful");
                    } else {
                        writer.println("Auth failure");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}