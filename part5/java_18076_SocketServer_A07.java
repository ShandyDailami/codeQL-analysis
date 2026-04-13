import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_18076_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) throws Exception {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected to client: " + socket.getRemoteSocketAddress());

            // Handling the request in a new thread
            executor.execute(new RequestHandler(socket));
        }
    }

    static class RequestHandler implements Runnable {

        private Socket socket;

        public java_18076_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Reading the request from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Handling the request here (Authentication)
                // This is a simple example, real-world applications would need more complex logic
                if (request.equals("AUTH_REQ")) {
                    writer.writeBytes("200 OK\n");
                } else {
                    writer.writeBytes("400 BAD REQUEST\n");
                }

                writer.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}