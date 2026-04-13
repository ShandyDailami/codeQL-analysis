import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_30752_SocketServer_A07 {

    private ExecutorService executor;
    private int port;

    public java_30752_SocketServer_A07(int port) {
        this.port = port;
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            executor.execute(new ClientHandler(socket));
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_30752_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    if (message.equals("auth fail")) {
                        out.println("auth fail");
                        out.flush();
                    } else {
                        out.println("auth success");
                        out.flush();
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}