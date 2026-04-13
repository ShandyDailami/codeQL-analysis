import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36043_SocketServer_A01 {

    private static ExecutorService executor;
    private static int port = 8080;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    public static class ClientHandler implements Runnable {
        private Socket socket;
        public java_36043_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("close")) {
                        socket.close();
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}