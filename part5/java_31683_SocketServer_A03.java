import java.io.*;
import java.net.*;

public class java_31683_SocketServer_A03 {

    private static int port = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server on port: " + port);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_31683_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        @Override
        public void run() {
            try {
                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    out.println("Server response: " + clientMessage);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}