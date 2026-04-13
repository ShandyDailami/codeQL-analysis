import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36226_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            executor = Executors.newCachedThreadPool();
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            server.close();
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_36226_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                String input, response;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    if (input.equals("exit")) {
                        response = "Connection closed by client";
                    } else {
                        response = "Hello, you said: " + input;
                    }
                    out.writeBytes(response + '\n');
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}