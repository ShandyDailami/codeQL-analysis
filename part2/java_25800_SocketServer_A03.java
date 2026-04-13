import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25800_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;

        public java_25800_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Simulating security-sensitive operations related to injection
                String response = "Response: " + request;
                writer.write(response.getBytes());
                writer.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}