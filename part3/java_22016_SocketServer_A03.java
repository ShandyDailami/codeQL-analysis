import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22016_SocketServer_A03 {

    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        int port = 1234; // port number

        executorService = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                executorService.execute(clientHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_22016_SocketServer_A03(Socket socket) {
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
                    out.println("Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}