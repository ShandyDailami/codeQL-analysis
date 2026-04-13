import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19430_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    static class Handler implements Runnable {

        private Socket socket;

        public java_19430_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Request received: " + request);

                // This is a simple injection example. Please replace this with your real business logic.
                if (request.contains("INJECTION")) {
                    System.out.println("Attempting injection...");
                    String injection = "INJECTION";
                    request = request.replace(request, injection);
                }

                writer.writeBytes("Response: " + request);
                writer.flush();
                System.out.println("Response sent: " + request);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}