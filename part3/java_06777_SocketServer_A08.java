import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_06777_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080, 50000, null);
        serverSocket.setReuseAddress(true);

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            executor.execute(new SocketHandler(socket));
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
                close(socket);
            }
        }

        public void run() {
            try {
                String message;
                while((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } finally {
                close(socket);
            }
        }

        void close(Socket socket) {
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }
}