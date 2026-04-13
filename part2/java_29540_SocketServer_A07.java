import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_29540_SocketServer_A07 {

    private static ExecutorService execPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                execPool.execute(handler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            execPool.shutdown();
        }
    }

    static class Handler extends Thread {

        private Socket socket;

        public java_29540_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);
                    String serverMessage = "Server says: " + clientMessage;
                    writer.println(serverMessage);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}