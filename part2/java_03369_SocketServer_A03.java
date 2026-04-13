import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_03369_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    static class ClientHandler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ClientHandler(Socket socket) {
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
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeConnection();
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}