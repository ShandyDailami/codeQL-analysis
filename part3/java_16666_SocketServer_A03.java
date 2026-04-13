import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16666_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        int port = 1234; // use a port number that's not being used by any other server
        ServerSocket server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_16666_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform some operation
                    // You can use any operation related to A03_Injection here
                    // For example, a command injection attack
                    // Here we just echo back the received message
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}