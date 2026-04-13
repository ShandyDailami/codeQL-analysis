import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_10574_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());
                executor.execute(new SocketHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        executor.shutdown();
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        BufferedReader in;
        PrintWriter out;

        public java_10574_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(socket, in, out);
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(socket, in, out);
            }
        }

        private static void close(Socket socket, BufferedReader in, PrintWriter out) {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}