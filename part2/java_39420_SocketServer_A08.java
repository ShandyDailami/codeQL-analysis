import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_39420_SocketServer_A08 {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                System.out.println("Waiting for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                pool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException ex) {
            System.out.println("Error in starting server: " + ex.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.out.println("Error in closing server: " + ex.getMessage());
                }
            }
            System.out.println("Server closed");
            pool.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_39420_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Check for integrity failure
                // Add your code here

                // Check if the client is connected
                if (!clientSocket.isConnected()) {
                    System.out.println("Client disconnected");
                    return;
                }

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Add your code here

                    // Echo back the request
                    out.writeBytes("Server: " + request + "\n");
                }
            } catch (IOException ex) {
                System.out.println("Error in communication: " + ex.getMessage());
            }
        }
    }
}