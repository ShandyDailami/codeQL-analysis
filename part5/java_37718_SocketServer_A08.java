import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_37718_SocketServer_A08 {

    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //Create a new ServerSocket that listens on PORT
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);
            executor = Executors.newFixedThreadPool(10);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        public java_37718_SocketServer_A08(Socket socket) {
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
            try {
                String message, response;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Basic Encryption: Convert message to uppercase
                    response = message.toUpperCase();
                    out.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}