import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34117_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket server;
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(12345);

        while (running) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
            executor.execute(new SocketHandler(socket));
        }

        server.close();
        executor.shutdown();
    }

    static class SocketHandler implements Runnable {

        private Socket socket;
        BufferedReader in;
        PrintWriter out;

        public java_34117_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                running = false;
                try { socket.close(); } catch (IOException ex) { /* can't do anything */ }
                executor.shutdown();
            }
        }

        @Override
        public void run() {
            try {
                String message, response;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    response = "Server says: " + message;
                    out.println(response);
                }
            } catch (IOException e) {
                running = false;
                try { socket.close(); } catch (IOException ex) { /* can't do anything */ }
                executor.shutdown();
            }
        }
    }
}