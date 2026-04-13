import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22787_SocketServer_A01 {

    private ExecutorService executor;

    public java_22787_SocketServer_A01() {
        executor = Executors.newCachedThreadPool();
    }

    public void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            executor.execute(new ClientHandler(socket));
        }
    }

    public void stopServer() {
        executor.shutdown();
   .
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_22787_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Server: Message received, thanks!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.startServer(5000);
    }
}