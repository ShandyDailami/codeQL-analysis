import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19979_SocketServer_A07 {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Handler extends Thread {
        private Socket socket;

        public java_19979_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Hello, client!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}