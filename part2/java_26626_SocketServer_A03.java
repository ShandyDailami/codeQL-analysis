import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26626_SocketServer_A03 {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            Handler handler = new Handler(socket);
            exec.execute(handler);
        }
    }

    static class Handler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        Handler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(socket, in, out);
                System.out.println("Error handling client " + socket.getRemoteSocketAddress());
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Simulate a security-sensitive operation related to injection
                    String evasive_injection = new StringBuilder(message).reverse().toString();
                    out.println("Evasive injection done: " + evasive_injection);
                }
            } catch (IOException e) {
                close(socket, in, out);
                System.out.println("Error handling client " + socket.getRemoteSocketAddress());
           
            }
        }

        private void close(Socket socket, BufferedReader in, PrintWriter out) {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Ignore the exception
            }
        }
    }
}