import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30994_SocketServer_A07 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_30994_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        socket.close();
                        return;
                    }
                    out.println("Hello, client, you connected successfully");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}