import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04583_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_04583_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String clientMessage = reader.readLine();
                System.out.println("Received message: " + clientMessage);

                String clientIP = socket.getRemoteSocketAddress().toString();
                System.out.println("Client IP: " + clientIP);

                String serverMessage = "Hello, you!";

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(serverMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}