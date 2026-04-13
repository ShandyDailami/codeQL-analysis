import java.io.*;
import java.net.*;

public class java_40093_SocketServer_A01 {
    private static final String SERVER_STATE = "Server is running...\n";
    private static int PORT = 8080;
    private static Socket serverSocket;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                serverSocket = server.accept();
                System.out.println("Client connected!");
                handleClient(serverSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private static void handleClient(Socket socket) {
        Thread thread = new Thread(new ClientHandler(socket));
        thread.start();
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_40093_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    out.println("Server: " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeConnection() {
        try {
            if (serverSocket != null) serverSocket.close();
            if (server != null) server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}