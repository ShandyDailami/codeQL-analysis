import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40380_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (IOException ex) {
                System.out.println("Error in accepting connections");
                server.close();
                executor.shutdown();
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_40380_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Error in creating I/O streams");
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);
                    out.println("Server says: " + message);
                }
            } catch (IOException ex) {
                System.out.println("Error in reading from or writing to the client");
            }
        }
    }
}