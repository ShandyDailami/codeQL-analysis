import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23985_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client connected at " + clientSocket.getRemoteSocketAddress());
            Handler handler = new Handler(clientSocket);
            executor.execute(handler);
        }
    }

    static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_23985_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    handleMessage(message);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void handleMessage(String message) {
            // This is a simple example of a command injection attack.
            // In a real-world application, you would need to sanitize and validate the input to prevent command injection.
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                public void run() {
                    // Do something with the message
                    System.out.println("Handled message: " + message);
                }
            });
            executor.shutdown();
        }

        private void close() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}