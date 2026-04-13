import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22624_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server started on port 8080");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");
                HandleClientTask task = new HandleClientTask(socket);
                executor.execute(task);
            } catch (Exception ex) {
                System.out.println("Error handling client connection");
                ex.printStackTrace();
            }
        }
    }

    private static class HandleClientTask implements Runnable {
        private Socket socket;

        public java_22624_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    // Here, we assume the client sends a message in a single line.
                    // Realistically, the server might expect multiple lines of input,
                    // and we'd need to handle that.
                }

                socket.close();
            } catch (Exception ex) {
                System.out.println("Error handling client connection");
                ex.printStackTrace();
            }
        }
    }
}