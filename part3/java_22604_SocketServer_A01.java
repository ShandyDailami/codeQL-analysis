import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22604_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_22604_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Simulate broken access control
                if (request.contains("accessControl")) {
                    writer.writeBytes("Broken Access Control Detected! Access Denied.\n");
                    System.out.println("Access Denied");
                } else {
                    writer.writeBytes("OK.\n");
                }

                writer.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}