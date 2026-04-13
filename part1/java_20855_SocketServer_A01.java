import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_20855_SocketServer_A01 {

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");
            pool.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;

        public java_20855_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Simulate security sensitive operation
                if ("BROKEN".equals(request)) {
                    writer.write("ERROR: Broken Access Control".getBytes());
                } else {
                    writer.write("OK".getBytes());
                }

                writer.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}